package com.wk68.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendMsg {
	private static String accessKeyId = "LTAI4GAKYrxNSF8yjetWoqPC";
	private static String accessSecret = "LplLuLC06X4Vkwyf32omN7odFb5eoK";
	private static String signName = "忍冬论坛";
	private static String templateCode = "SMS_189524003";
	
	/**
	   *      发送短信方法
	 * @param phoneNumbers
	 * @param code
	 */
	public static String sendMessage(String phoneNumbers,String code) {
		String msg = "";
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
      IAcsClient client = new DefaultAcsClient(profile);
      CommonRequest request = new CommonRequest();
      request.setMethod(MethodType.POST);
      request.setDomain("dysmsapi.aliyuncs.com");
      request.setVersion("2017-05-25");
      request.setAction("SendSms");
      request.putQueryParameter("RegionId", "cn-hangzhou");
      request.putQueryParameter("PhoneNumbers", phoneNumbers);
      request.putQueryParameter("SignName", signName);
      request.putQueryParameter("TemplateCode", templateCode);
      request.putQueryParameter("TemplateParam", "{\"code\":\""+ code +"\"}");
      try {
          CommonResponse response = client.getCommonResponse(request);
          msg = response.getData();
      } catch (ServerException e) {
          e.printStackTrace();
      } catch (ClientException e) {
          e.printStackTrace();
      }
		return msg;
	}
	/**
	 *    六位验证码
	 * @return
	 */
	public static String getCode() {
		return ((int)((Math.random()*9+1)*100000)) + "";
	}
	 	
	
}
