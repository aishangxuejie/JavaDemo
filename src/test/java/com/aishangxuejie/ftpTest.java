package com.aishangxuejie;

import java.io.IOException;

import org.junit.Test;

import com.aishangxuejie.java.FTPUtil;

import lombok.extern.log4j.Log4j2;

/**
 * @author: Cuigm
 * @ClassName:  ftpTest
 * @Description: TODO
 * @date: 2019年2月26日下午4:36:57
 */
@Log4j2
public class ftpTest {
	
	/**
	 * @Author: Cuigm
	 * @Title: changeDirectory   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年2月26日下午4:47:14    
	 * @throws
	 */
//	@Test
	public void changeDirectory() {

		try (FTPUtil ftpUtil = new FTPUtil()){
            if(ftpUtil.createFTPDirectory("/MedsRecords")) {
            	log.error("success");
            }else {
            	log.error("false");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

	}
	
//	@Test
    public void downloadFile() throws Exception {
        try (FTPUtil ftpUtil = new FTPUtil()){
            if(ftpUtil.downloadFile("/MedsRecords/201902/10000125/20018_1_201903.pdf","F:/MedsRecords/20018_1_201904.pdf"))
            	log.error("success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Test
    public void uploadFile() throws Exception {
        try (FTPUtil ftpUtil = new FTPUtil()){
        	//F:\MedsRecords\201902\10000125
    		if(ftpUtil.uploadFile("/MedsRecords/201902/10000125/","20018_1_201903.pdf","F:\\MedsRecords\\201902\\10000125\\20018_1_201902.pdf")) {
    			log.error("success");
    		}else {
    			log.error("false");
    		}
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
	 * @Author: Cuigm
	 * @Title: simpleUploadFile   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年2月27日上午8:51:30    
	 * @throws
	 */
    @Test
	public void connectFTP() {
    	try {
			FTPUtil ftpUtil = new FTPUtil();
//			ftpUtil.showPDF("/MedsRecords/10000305/201902");
//			ftpUtil.createFTPDirectory("/MedsRecords");
//			ftpUtil.showPDF("111504_1_201902.pdf");
			ftpUtil.syso();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
