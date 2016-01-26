package com.wanghh.art.service.wx;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.alibaba.fastjson.JSON;
import com.whh.art.dao.model.WxAccessTokenModel;
import com.whh.art.dao.model.WxUserModel;
import com.whh.art.service.IOptLogService;
import com.whh.art.untils.WxError;

public class AccessTokenServiceImpl implements IAccessTokenService {

	/*public static String APPID = "wx5d32a0a3aaa63013";
	public static String APPSECRET = "fe67e928329a5d8d540090e3fb6aa704";
	public static String TOKEN = "junart123";
	public static String EAK = "tRcAbyFvcsEOObrnhLjXslaTcsIH1mqiJmmoWvOdgSy";*/
	
	public static String APPID = "wx7c6b13d91c03fdb8";
	public static String APPSECRET = "48c4dd03142c5b86c33a427c3a1c26a4";
	public static String TOKEN = "junart123";
	public static String EAK = "tRcAbyFvcsEOObrnhLjXslaTcsIH1mqiJmmoWvOdgSy";

	private static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
			+ APPID + "&secret=" + APPSECRET;

	IOptLogService optLogService;


	public WxAccessTokenModel getAccessToken() {

		WxAccessTokenModel token = optLogService.getWxAccessTokenModel();

		if (token == null) {
			token = this.getTokenFormWx();
			optLogService.insertAccessToken(token);
			return token;

		} else {
			long now = System.currentTimeMillis();
			if ((now - token.getCreate_time()) / 1000 > token.getExpires_in()) {// 过期
				optLogService.deleteAccessToken(token.getAccess_token());
				token = this.getTokenFormWx();
				optLogService.insertAccessToken(token);
			}
			return token;
		}

	}

	/**
	 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&
	 * appid=wx5d32a0a3aaa63013&secret=fe67e928329a5d8d540090e3fb6aa704
	 * 
	 * @return
	 */
	private WxAccessTokenModel getTokenFormWx() {

		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(10 * 1000);
		client.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);

		GetMethod method = new GetMethod(access_token_url);
		StringBuilder pen = new StringBuilder(100);
		try {
			client.executeMethod(method);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					method.getResponseBodyAsStream(), "utf-8"));
			pen.setLength(0);
			String tmp;
			while ((tmp = br.readLine()) != null) {
				pen.append(tmp);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		System.out.println(pen.toString());

		try{
			
			WxError error = JSON.parseObject(pen.toString(), WxError.class);
		    try{
		    	if (error.getErrcode() == 0){
		    		WxAccessTokenModel token = JSON.parseObject(pen.toString(),
							WxAccessTokenModel.class);

					token.setCreate_time(System.currentTimeMillis());
					return token;
		    	}
		    }catch(Exception e){
		    	
		    }
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		return null;
	}
	
	
	/**
	 * https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 * @param openid
	 * @return
	 */
	@Override
	public WxUserModel getWxUser(String openid) {
		String access_token = this.getAccessToken().getAccess_token();
		
		if (access_token == null){
			return null;
		}
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+ access_token + "&openid=" + openid + "&lang=zh_CN";
		
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(10 * 1000);
		client.getHttpConnectionManager().getParams().setSoTimeout(20 * 1000);

		GetMethod method = new GetMethod(url);
		StringBuilder pen = new StringBuilder(100);
		try {
			client.executeMethod(method);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					method.getResponseBodyAsStream(), "utf-8"));
			pen.setLength(0);
			String tmp;
			while ((tmp = br.readLine()) != null) {
				pen.append(tmp);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		System.out.println(pen.toString());

		try{
			
			WxError error = JSON.parseObject(pen.toString(), WxError.class);
		    try{
		    	if (error.getErrcode() == 0){
		    		WxUserModel user = JSON.parseObject(pen.toString(),
							WxUserModel.class);
					return user;
		    	}
		    }catch(Exception e){
		    	
		    }
			
		}catch(Exception e){
			
		}
		return null;

	}

	public void setOptLogService(IOptLogService optLogService) {
		this.optLogService = optLogService;
	}

	
}
