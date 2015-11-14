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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanghh.art.service.wx.AccessTokenServiceImpl;
import com.wanghh.art.service.wx.IAccessTokenService;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.WxUserModel;
import com.whh.art.service.IAdminService;
import com.whh.art.service.IArtService;
import com.whh.art.untils.AliyunUpload;

@Controller
public class WxReceiver {

	private static String DOMAIN = "http://121.40.172.232/art/art/detail.form?id=";

	@Resource
	IArtService artService;
	@Resource
	IAdminService adminService;
	@Resource
	IAccessTokenService accessTokenService;

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

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);

		try {
			String mySignature = SHA1.gen(AccessTokenServiceImpl.TOKEN, timestamp, nonce);

			WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
			config.setToken(AccessTokenServiceImpl.TOKEN);
			config.setCorpId(AccessTokenServiceImpl.APPID);
			config.setAesKey(AccessTokenServiceImpl.EAK);
			config.setCorpSecret(AccessTokenServiceImpl.APPSECRET);

			WxCpXmlMessage inMessage = XStreamTransformer.fromXml(
					WxCpXmlMessage.class, request.getInputStream());
			
			System.out.println("接收微信信息！"+inMessage);
			String rtnXML = null;
			if (inMessage.getMsgType().equals("text")){
				rtnXML = this.handleNumber(inMessage);
			}
			
			if (inMessage.getMsgType().equals("event")){
				rtnXML = this.handleEvent(inMessage);
			}
			if (StringUtils.isNotBlank(rtnXML)){
				response.getWriter().print(rtnXML);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return echostr;
	}
	
	@SuppressWarnings("all")
	private String handleNumber(WxCpXmlMessage inMessage){
		String number = inMessage.getContent();
		Item item = new Item();

		try {
			ArtModel art = artService.getArt(number);

			if (art == null || art.getId() == 0) {
				getDefaultItem(item);
			} else {
				item.setDescription(art.getArtDesc());
				item.setPicUrl(AliyunUpload.IMAGE_DOMAIN+art.getArtImage());
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
			return rtnXML;
		}
		return null;
	}
	
	
	@SuppressWarnings("all")
	private String handleEvent(final WxCpXmlMessage inMessage){
		if (inMessage.getEvent().equals("subscribe")){
			new Thread(){
				public void run(){
					System.out.println("++++++++++++++++++Thread++++++++++++++++++++++++++"+this.getName());
					WxUserModel user = accessTokenService.getWxUser(inMessage.getFromUserName());
					if (user == null){
						user = new WxUserModel();
						user.setOpenId(inMessage.getFromUserName());
						user.setSubscribeTime(inMessage.getCreateTime());
					}
					adminService.insertUser(user);
				}
			}.start();
		}
		
		if (inMessage.getEvent().equals("unsubscribe")){
			adminService.deleteUser(inMessage.getFromUserName());
		}
		return null;
	}

	private void getDefaultItem(Item item) {

		item.setDescription("描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？");
		item.setPicUrl("https://www.mlook.mobi/img/month_1509/201509100900289792_66_88.jpg");
		item.setTitle("标题几个字标题几个字标题几个字标题几个字");
		item.setUrl("http://www.qupai.me");
	}

}
