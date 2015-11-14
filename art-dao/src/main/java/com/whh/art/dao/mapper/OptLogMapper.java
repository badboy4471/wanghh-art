package com.whh.art.dao.mapper;

import java.util.List;

import com.whh.art.dao.model.ArtOutModel;
import com.whh.art.dao.model.OptLogModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.WxAccessTokenModel;

public interface OptLogMapper {

	void insert(OptLogModel opt);
	
	void insertArtOut(ArtOutModel artOut);
	
	List<ArtOutModel> loadArtOuts(SearchModel search);
	
	int countArtOuts(SearchModel search);
	
	
	WxAccessTokenModel getWxAccessTokenModel();
	
	void deleteAccessToken(String accessToken);
	
	void insertAccessToken(WxAccessTokenModel token);
}
