package com.aishangxuejie.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: Cuigm
 * @ClassName: FTPUtil
 * @Description: TODO
 * @date: 2019年2月26日下午4:35:20
 */

@PropertySource(value={"ftp.properties"}, ignoreResourceNotFound = true)
public class FTPUtil implements AutoCloseable {
	@Value(value="${ftp.username}")
	private String USERNAME;
	@Value(value="${ftp.password}")
	private String PASSWORD;
	@Value(value="${ftp.ip}")
	private String IP;
	@Value(value="${ftp.port}")
	private int PORT;
	
	private FTPClient ftpClient;
	public void syso() {
		System.out.println(USERNAME+PASSWORD+IP+PORT);
	}
	/**
	 * @Author: Cuigm
	 * @Title: FTPUtil   
	 * @Description: TODO   尝试连接ftp服务器
	 * @param: @param serverIP
	 * @param: @param port
	 * @param: @param userName
	 * @param: @param password
	 * @param: @throws IOException  
	 * @throws
	 */
	public FTPUtil() throws IOException {
		System.out.println(USERNAME+PASSWORD+IP+PORT);
		String serverIP =IP;
		int port=PORT;
		String userName=USERNAME;
		String password=PASSWORD;
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(serverIP, port);
		} catch (SocketException e) {
			try {
				Thread.sleep(1000);// 尝试重新连接
				ftpClient.connect(serverIP, port);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		ftpClient.login(userName, password);
		int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			System.out.println("connect failed...ftp 服务器:" + serverIP + ":" + port);
		} else {
			System.out.println("connect successfu...ftp 服务器:" + serverIP + ":" + port);
		}
		ftpClient.setBufferSize(1024);// 设置上传缓存大小
		ftpClient.setControlEncoding("UTF-8");// 设置编码
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);// 设置文件类型
	}

	/**
	 * ftp下载
	 * 
	 */
	public boolean downloadFile(String remoteFileName, String local_file) throws IOException {
		boolean status;
		File outFileName = new File(local_file);
		if (ftpClient == null)
			throw new IOException("ftp server login error");
		try (OutputStream outputStream = new FileOutputStream(outFileName)) {
			status = ftpClient.retrieveFile(remoteFileName, outputStream);
		}
		return status;
	}

	public boolean showPDF(String remoteFileName) throws IOException {
		ftpClient.setBufferSize(1024 * 1024 * 10);
		ftpClient.enterLocalPassiveMode();
		ftpClient.changeWorkingDirectory("/Data/MedsRecords/10000305/201902/");
		FTPFile[] fs = ftpClient.listFiles();
		InputStream is = null;
		for (FTPFile ff : fs) {
			System.out.println("     "+ff.getName());
			if(ff.getName() == remoteFileName) {
				System.out.println("该文件存在");
			}
		}
		if(null == is || ftpClient.getReplyCode() == 550){
			System.out.println("该文件不存在");
		}
		return true;
	}
	/**
	 * ftp上传
	 * ftp_path ftp文件路径
	 * ftp_fileName ftp 文件名称（带后缀名）
	 * local_file 本地文件（全路径）
	 */
	public boolean uploadFile(String ftp_path,String ftp_fileName, String local_file) throws IOException {
		boolean status =false;//默认上传失败
		String remoteFileName = ftp_path+ftp_fileName;//全路径
		try (InputStream inputStream = new FileInputStream(local_file)) {
			if (ftpClient == null) {
				throw new IOException("ftp server login error");
			}else {
				createFTPDirectory(ftp_path);
				ftpClient.setBufferSize(1024 * 1024 * 10);
				ftpClient.enterLocalPassiveMode();
				status = ftpClient.storeFile(remoteFileName, inputStream);
				// 关闭输入流
				inputStream.close();
				// 退出ftp
				ftpClient.logout();
			}
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ftpClient.isConnected()) {
				status = ftpClient.logout();
				ftpClient.disconnect();//确认已关闭连接
			}
		}
		return status;
	}

	/**
	 * 切换目录
	 *
	 * @param path
	 *            创建目录
	 * @return 创建标志
	 * @throws IOException
	 *             异常
	 */
	public boolean changeDirectory(String path) throws IOException {
		return ftpClient.changeWorkingDirectory(path);
	}

	/**
	 * 创建目录
	 *
	 * @param path
	 *            创建目录
	 * @return 创建标志
	 * @throws IOException
	 *             异常
	 */
	public boolean createFTPDirectory(String path) throws IOException {
		boolean status = false;
		if(System.getProperty("os.name").toLowerCase().contains("linux")) {
			String fileSeperator = File.separator;
			String[] paths = path.split(fileSeperator);
			// 检查是否存在该路径，不存在创建多级文件路径
			if (paths == null || paths.length == 0) {
				status = false;
			}else {
				String totalPath = "";
				for (String p : paths) {
					if (StringUtils.isNotEmpty(p)) {
						String createPath = p;
						totalPath += "/" + createPath;
						// 转到指定上传目录,如果未成功转入说明目录不存在，创建一个
						boolean change = ftpClient.changeWorkingDirectory(createPath);
						if (!change) {
							ftpClient.makeDirectory(createPath);
							ftpClient.changeWorkingDirectory(totalPath);
						}
					}
				}
				status = true;
			}
		}else {
			File dirFile = new File(path);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
				
			}
		}
		return status;
	}
	/**
	 * 自动关闭资源
	 */
	public void close() throws Exception {
		if (ftpClient != null && ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}

	public static boolean downFile(String ip, String port, String username, String password, String fileServerDir,
			String localDir) {
		// 初始表示下载失败
		boolean success = false;
		try{
		// 创建FTPClient对象
		FTPClient ftp = new FTPClient();

			ftp.setBufferSize(1024 * 1024 * 10);
			ftp.enterLocalPassiveMode();
			// 转到指定下载目录
			String fileName = fileServerDir.substring(fileServerDir.lastIndexOf("/") + 1);
			String remotePath = fileServerDir.substring(0, fileServerDir.lastIndexOf("/") + 1);
			ftp.changeWorkingDirectory(remotePath);
			FTPFile[] fs = ftp.listFiles();
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localDir + "/" + ff.getName());

					OutputStream is = new FileOutputStream(localFile);
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}

			// 退出ftp
			ftp.logout();
			// 下载成功
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return success;
	}
}
