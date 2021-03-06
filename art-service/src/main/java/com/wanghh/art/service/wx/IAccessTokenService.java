package com.wanghh.art.service.wx;

import com.whh.art.dao.model.WxAccessTokenModel;
import com.whh.art.dao.model.WxUserModel;

public interface IAccessTokenService {
	
	public WxUserModel getWxUser(String openid);
	
	public WxAccessTokenModel getAccessToken();

}
