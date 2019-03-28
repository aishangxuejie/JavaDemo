package com.aishangxuejie.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 * @author: Cuigm
 * @ClassName: FTPClientPool
 * @Description: TODO
 * @date: 2019年2月26日下午4:14:02
 */
public class FTPClientPool {

	/**
	 * ftp客户端连接池
	 */
	private GenericObjectPool<FTPClient> pool;

	/**
	 * ftp客户端工厂
	 */
	private FTPClientFactory ftpClientFactory;

	/**
	 * 构造函数中 注入一个bean
	 * 
	 * @param clientFactory
	 */
	public FTPClientPool(FTPClientFactory ftpClientFactory) {
		this.ftpClientFactory = ftpClientFactory;
		pool = new GenericObjectPool<FTPClient>(ftpClientFactory, ftpClientFactory.getFtpClientPoolConfig());

	}

	public FTPClientFactory getClientFactory() {
		return ftpClientFactory;
	}

	public GenericObjectPool<FTPClient> getPool() {
		return pool;
	}

	/**
	 * 借 获取一个连接对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public FTPClient borrowObject() throws Exception {

		FTPClient client = pool.borrowObject();

//		 if(!client.sendNoOp()){
//		 //使池中的对象无效
//		 client.logout();
//		 client.disconnect();
//		 pool.invalidateObject(client);
//		 client =clientFactory.create();
//		 pool.addObject();
//		 }
//		
		return client;

	}

	/**
	 * 还 归还一个连接对象
	 * 
	 * @param ftpClient
	 */
	public void returnObject(FTPClient ftpClient) {

		if (ftpClient != null) {
			pool.returnObject(ftpClient);
		}
	}
}
