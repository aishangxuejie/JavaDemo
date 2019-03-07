package com.aishangxuejie.alisms;

import com.aliyuncs.exceptions.ClientException;

public class SendMessageService {

	public static String akb020;//协议机构名称
	public static String aab034;//经办机构名称
	public static String utype;//机构类型：0经办机构；1协议机构
	public static String msgtype;//业务类型:0工伤继续（康复）治疗申请业务
	
	
	private static ALiSMS alisms;
	
	public static void main(String[] args) {
		//1.医院发起继续治疗申请，保存
		sendMessage("10000329","","1","0","申请日期：2018年11月7日。");
	}
	
	//调用短信接口
	private static String sendMessage(String akb020,String aab034,String utype,String msgtype,String others) {
		//获取短信接收人信息list
		String querySmsUser = "select * from sms_user where akb020 = '"+akb020+"' and utype = '"+utype+"'";
		//判断接收短信人的发送时间与发送状态，同一天已发送过短信之后，不再继续发送短信。
		
		//当天未发送短信，继续发送短信
		
		//获取短信模板
		String querySmsMsg = "select * from sms_Msg where msgtype = '"+msgtype+"'";
		//获取sms_user phonelist
		String[] phoneList = {"1301102102","13210210646","..."};
		//获取模板sms_user templateCode
		String templateCode ="JKFHHYOPI546a123";
		//发送短信实现
		try {
			alisms.sendSms(phoneList,templateCode,others);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//发送成功，更新sms_user
		return "";
	}
	
	
}
