package com.whh.art.service;

import com.whh.art.dao.model.ArtOutModel;
import com.whh.art.dao.model.WxAccessTokenModel;

public interface IOptLogService {

	void insert(int adminId, String url);

	void insertArtOut(ArtOutModel out);

	WxAccessTokenModel getWxAccessTokenModel();

	void deleteAccessToken(String accessToken);

	void insertAccessToken(WxAccessTokenModel token);

}
