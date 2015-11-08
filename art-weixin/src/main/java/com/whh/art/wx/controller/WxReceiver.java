package com.whh.art.wx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutTextMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WxReceiver {

	private static String APPID = "wx5d32a0a3aaa63013";
	private static String APPSECRET = "fe67e928329a5d8d540090e3fb6aa704";
	private static String TOKEN = "junart123";
	private static String EAK = "tRcAbyFvcsEOObrnhLjXslaTcsIH1mqiJmmoWvOdgSy";

	@RequestMapping(value = "art/wx/receiver", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public @ResponseBody
	String viewArtDetail(
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam(value = "timestamp", required = false) String timestamp,
			@RequestParam(value = "nonce", required = false) String nonce,
			@RequestParam(value = "echostr", required = false) String echostr,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("接收微信信息！");

		try {
			String mySignature = SHA1.gen(TOKEN, timestamp, nonce);

			System.out.println("mySignature:" + mySignature + ",signature:"
					+ signature + ",equals:" + (signature.equals(mySignature)));

			WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
			config.setToken(TOKEN);
			config.setCorpId(APPID);
			config.setAesKey(EAK);
			config.setCorpSecret(APPSECRET);

			WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(
					request.getInputStream(), config, timestamp, nonce,
					signature);

			WxCpXmlOutTextMessage m = WxCpXmlOutMessage.TEXT().content("测试一下")
					.fromUser(inMessage.getToUserName())
					.toUser(inMessage.getFromUserName()).build();

			if (m != null) {
				response.getWriter().write(m.toEncryptedXml(config));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// return null;
		return echostr;
	}

}
