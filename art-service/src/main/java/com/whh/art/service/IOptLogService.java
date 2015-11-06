package com.whh.art.service;

import com.whh.art.dao.model.ArtOutModel;

public interface IOptLogService {
	
	
	void insert(int adminId,String url);
	
	void insertArtOut(ArtOutModel out);

}
