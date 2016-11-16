package com.whh.art.wx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.util.crypto.SHA1;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutImageMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutNewsMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutNewsMessage.Item;
import me.chanjar.weixin.cp.bean.WxCpXmlOutTextMessage;
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
import com.whh.art.dao.model.SystemConfigModel;
import com.whh.art.dao.model.WxUserModel;
import com.whh.art.service.IAdminService;
import com.whh.art.service.IArtService;
import com.whh.art.service.ISystemConfigService;
import com.whh.art.untils.AliyunUpload;

@Controller
public class WxReceiver {

//	private static String DOMAIN = "http://121.40.172.232/art/art/detail.form?id=";
	private static String DOMAIN = "http://gl.791whys.com/art/art/detail.form?id=";

	@Resource
	IArtService artService;
	@Resource
	IAdminService adminService;
	@Resource
	IAccessTokenService accessTokenService;
	@Resource
	ISystemConfigService systemConfigService;

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
		Item item = null;

		try {
			ArtModel art = artService.getArt(number);

			if (art == null || art.getId() == 0) {
				
			} else {
				item = new Item();
				item.setDescription(art.getArtDesc());
				item.setPicUrl(AliyunUpload.IMAGE_DOMAIN+art.getArtImage());
				item.setTitle(art.getArtName());
				item.setUrl(DOMAIN + art.getId());
			}

		} catch (Exception e) {
			
		}
		if (item != null){
			WxCpXmlOutNewsMessage news = WxCpXmlOutMessage.NEWS()
					.addArticle(item).fromUser(inMessage.getToUserName())
					.toUser(inMessage.getFromUserName()).build();

			if (news != null) {
				String rtnXML = XStreamTransformer.toXml(
						(Class) news.getClass(), news);
				return rtnXML;
			}
		}else{
			WxCpXmlOutTextMessage text = WxCpXmlOutMessage.TEXT()
					.content("没有编号为：" + number + "的艺术品!")
					.fromUser(inMessage.getToUserName())
					.toUser(inMessage.getFromUserName()).build();
			if (text != null) {
				String rtnXML = XStreamTransformer.toXml(
						(Class) text.getClass(), text);
				return rtnXML;
			}
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
					}else{
						user.setSubscribeTime(inMessage.getCreateTime());
					}
					adminService.insertUser(user);
				}
			}.start();
			
			SystemConfigModel config = systemConfigService.getSystemConfig();
			
			/*WxCpXmlOutTextMessage text = WxCpXmlOutTextMessage.TEXT()
					.content(config.getWelcomeMessage())
					.fromUser(inMessage.getToUserName())
					.toUser(inMessage.getFromUserName()).build();*/
			
			WxCpXmlOutNewsMessage news = this.buildActiveDesc(inMessage);
			
			
			String rtnXML = XStreamTransformer.toXml(
					(Class) news.getClass(), news);
			return rtnXML;	
		}
		
		if (inMessage.getEvent().equals("unsubscribe")){
			adminService.deleteUser(inMessage.getFromUserName());
		}
		return null;
	}
	
	/**
	 * 组装企业介绍信息
	 * @param inMessage
	 * @return
	 */
	private WxCpXmlOutNewsMessage buildCompanyDesc(WxCpXmlMessage inMessage) {
		Item item = new Item();
		item.setDescription("791艺术街区，位于南昌市三经路与五纬路交汇处，与省委、省军区毗邻，地理位置得天独厚。街区于二0一0年开始规划,经过一年多时间的打造和招商……");
		item.setPicUrl("http://art-images.oss-cn-hangzhou.aliyuncs.com/system/791-big.jpg");
		item.setTitle("791艺术街区介绍");
		item.setUrl("http://gl.791whys.com/company.html");

		WxCpXmlOutNewsMessage news = WxCpXmlOutMessage.NEWS().addArticle(item)
				.fromUser(inMessage.getToUserName())
				.toUser(inMessage.getFromUserName()).build();
		return news;
	}
	
	private WxCpXmlOutNewsMessage buildActiveDesc(WxCpXmlMessage inMessage) {
		Item item = new Item();
		item.setDescription("与大家对话-黑泽明电影分镜头绘画展");
		item.setPicUrl("http://art-images.oss-cn-hangzhou.aliyuncs.com/system/huodong-hzm.jpg");
		item.setTitle("欢迎关注791艺术街区");
		item.setUrl("http://gl.791whys.com/avtivehzm.html");

		WxCpXmlOutNewsMessage news = WxCpXmlOutMessage.NEWS().addArticle(item)
				.fromUser(inMessage.getToUserName())
				.toUser(inMessage.getFromUserName()).build();
		return news;
	}

	private void getDefaultItem(Item item) {

		item.setDescription("描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？描述几个字？");
		item.setPicUrl("https://www.mlook.mobi/img/month_1509/201509100900289792_66_88.jpg");
		item.setTitle("标题几个字标题几个字标题几个字标题几个字");
		item.setUrl("http://www.qupai.me");
	}

}
