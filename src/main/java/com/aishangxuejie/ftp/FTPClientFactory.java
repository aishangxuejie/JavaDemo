package com.aishangxuejie.ftp;
 
import java.io.IOException;
 
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import lombok.extern.log4j.Log4j2;
 
 
/**
 * @author: Cuigm
 * @ClassName:  FTPClientFactory
 * @Description: TODO ftp连接池bean
 * @date: 2019年2月26日下午4:09:42
 */
@Log4j2
public class FTPClientFactory extends BasePooledObjectFactory<FTPClient> {
	
    private FTPClientPoolConfig ftpClientPoolConfig;

    
	public FTPClientPoolConfig getFtpClientPoolConfig() {
		return ftpClientPoolConfig;
	}

	public void setFtpClientPoolConfig(FTPClientPoolConfig ftpClientPoolConfig) {
		this.ftpClientPoolConfig = ftpClientPoolConfig;
	}

	/**
	 * new FTPClient
	 */
    @Override
    public FTPClient create() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(ftpClientPoolConfig.getConnectTimeOut());
        try {
        	
        	log.info("连接ftp服务器:" +ftpClientPoolConfig.getHost()+":"+ftpClientPoolConfig.getPort());
        	ftpClient.connect(ftpClientPoolConfig.getHost(), ftpClientPoolConfig.getPort());
            
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                log.error("FTPServer 拒绝连接");
                return null;
            }
            boolean result = ftpClient.login(ftpClientPoolConfig.getUsername(),ftpClientPoolConfig.getPassword());
            if (!result) {
                log.error("ftpClient登录失败!");
                throw new Exception("ftpClient登录失败! userName:"+ ftpClientPoolConfig.getUsername() + ", password:"
                        + ftpClientPoolConfig.getPassword());
            }
         
			ftpClient.setControlEncoding(ftpClientPoolConfig.getControlEncoding());
			ftpClient.setBufferSize(ftpClientPoolConfig.getBufferSize());
			ftpClient.setFileType(ftpClientPoolConfig.getFileType());
			ftpClient.setDataTimeout(ftpClientPoolConfig.getDataTimeout());
			ftpClient.setUseEPSVwithIPv4(ftpClientPoolConfig.isUseEPSVwithIPv4());
			if(ftpClientPoolConfig.isPassiveMode()){
				log.info("进入ftp被动模式");
				ftpClient.enterLocalPassiveMode();//进入被动模式
			}
        } catch (IOException e) {
            log.error("FTP连接失败：", e);
        }
        return ftpClient;
    }
 
    @Override
    public PooledObject<FTPClient> wrap(FTPClient ftpClient) {
        return new DefaultPooledObject<FTPClient>(ftpClient);
    }
 
    /**
     * 销毁对象
     */
    @Override
    public void destroyObject(PooledObject<FTPClient> p) throws Exception {
        FTPClient ftpClient = p.getObject();
        ftpClient.logout();
        super.destroyObject(p);
    }
 
    /**
     * 验证对象
     */
    @Override
    public boolean validateObject(PooledObject<FTPClient> p) {
        FTPClient ftpClient = p.getObject();
        boolean connect = false;
        try {
            connect = ftpClient.sendNoOp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connect;
    }
    
 
    /**
     *  No-op.
     *
     *  @param p ignored
     */
    @Override
    public void activateObject(PooledObject<FTPClient> p) throws Exception {
        // The default implementation is a no-op.
    }
 
    /**
     *  No-op.
     *
     * @param p ignored
     */
    @Override
    public void passivateObject(PooledObject<FTPClient> p)
        throws Exception {
        // The default implementation is a no-op.
    }
}