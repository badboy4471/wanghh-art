import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage.WxArticle;


public class Test {
	
	public static void main(String[] args) {
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("wx5d32a0a3aaa63013"); // 设置微信公众号的appid
		config.setSecret("fe67e928329a5d8d540090e3fb6aa704"); // 设置微信公众号的app corpSecret
		config.setToken("junart123"); // 设置微信公众号的token
//		config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
		
		WxMpService wxService = new WxMpServiceImpl();
		wxService.setWxMpConfigStorage(config);
		
		String openid = "...";
		WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content("Hello World").build();
		
		WxArticle article = new WxArticle();
		article.setDescription("");
		article.setTitle("");
		article.setUrl("");
		article.setPicUrl("");
		
		
		WxMpCustomMessage news = WxMpCustomMessage.NEWS().toUser(openid).addArticle(article).build();
		
		try {
			wxService.customMessageSend(news);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		
	}

}
