package com.whh.art.wx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutNewsMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutNewsMessage.Item;
import me.chanjar.weixin.cp.util.xml.XStreamTransformer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.service.IArtService;

@Controller
public class WxReceiver {

	private static String APPID = "wx5d32a0a3aaa63013";
	private static String APPSECRET = "fe67e928329a5d8d540090e3fb6aa704";
	private static String TOKEN = "junart123";
	private static String EAK = "tRcAbyFvcsEOObrnhLjXslaTcsIH1mqiJmmoWvOdgSy";

	private static String DOMAIN = "http://121.40.172.232/art/detail.form?id=";

	@Resource
	IArtService artService;

	@SuppressWarnings("all")
	@RequestMapping(value = "art/wx/receiver", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public @ResponseBody
	String wxCenter(
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam(value = "timestamp", required = false) String timestamp,
			@RequestParam(value = "nonce", required = false) String nonce,
			@RequestParam(value = "echostr", required = false) String echostr,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("接收微信信息！");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		try {
			String mySignature = SHA1.gen(TOKEN, timestamp, nonce);

			System.out.println("mySignature:" + mySignature + ",signature:"
					+ signature + ",equals:" + (signature.equals(mySignature)));

			WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
			config.setToken(TOKEN);
			config.setCorpId(APPID);
			config.setAesKey(EAK);
			config.setCorpSecret(APPSECRET);

			WxCpXmlMessage inMessage = XStreamTransformer.fromXml(
					WxCpXmlMessage.class, request.getInputStream());

			String code = inMessage.getContent();
			Item item = new Item();

			try {
				int artId = Integer.parseInt(code);

				ArtModel art = artService.getArt(artId);

				if (art == null || art.getId() == 0) {
					getDefaultItem(item);
				} else {
					item.setDescription(art.getArtDesc());
					item.setPicUrl(art.getArtImage());
					item.setTitle(art.getArtName());
					item.setUrl(DOMAIN + art.getId());
				}

			} catch (Exception e) {
				getDefaultItem(item);
			}

			WxCpXmlOutNewsMessage news = WxCpXmlOutMessage.NEWS()
					.addArticle(item).fromUser(inMessage.getToUserName())
					.toUser(inMessage.getFromUserName()).build();

			if (news != null) {
				String rtnXML = XStreamTransformer.toXml(
						(Class) news.getClass(), news);
				response.getWriter().write(rtnXML);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// return null;
		return echostr;
	}

	private void getDefaultItem(Item item) {

		item.setDescription("描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？");
		item.setPicUrl("https://www.mlook.mobi/img/month_1509/201509100900289792_66_88.jpg");
		item.setTitle("标题几个字标题几个字标题几个字标题几个字");
		item.setUrl("http://www.qupai.me");
	}

}
