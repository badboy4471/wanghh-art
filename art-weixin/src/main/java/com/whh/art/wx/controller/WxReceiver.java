package com.whh.art.wx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.common.util.crypto.WxCryptUtil;

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

	@RequestMapping(value = "art/wx/receiver", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public @ResponseBody
	String viewArtDetail(
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam(value = "timestamp", required = false) String timestamp,
			@RequestParam(value = "nonce", required = false) String nonce,
			@RequestParam(value = "echostr", required = false) String echostr,
			HttpServletRequest request) {

		System.out.println("接收微信信息！");

		try {
			String mySignature = SHA1.gen(TOKEN, timestamp, nonce);

			System.out.println("mySignature:" + mySignature + ",signature:"
					+ signature + ",equals:" + (signature.equals(mySignature)));

		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		int i = 0;
		byte[] b = new byte[1024];
		try {
			while ((i = request.getInputStream().read(b)) != -1) {
				System.out.println(new String(b, "utf-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return echostr;
	}

}
