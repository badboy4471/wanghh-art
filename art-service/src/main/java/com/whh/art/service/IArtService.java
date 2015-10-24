package com.whh.art.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;
import com.whh.art.dao.model.SearchModel;

public interface IArtService {

	ArtModel insertArt(ArtModel art);

	ArtModel getArt(String number);

	ArtModel getArt(int id);

	boolean numberExist(String number);

	List<ArtModel> searchArts(SearchModel search);

	int countArts(SearchModel search);
	
	void delArt(int id);
	
	
	void insertMuseum(MuseumModel model);
	
	MuseumModel getMuseum(int id);
	
	void deletMuseum(int id);
	
	void updateMuseum(MuseumModel model);
	
	List<MuseumModel> loadAllMuseum();

	
	void insertArt2Museum(int artId, int museumId);

	List<ArtModel> loadArtsFromMueum(int museumId, int start, int limit);

	int countArtsFromMueum(int museumId);

	void deleteMuseumArt(int museumId, int artId);

	void deleteMuseumArtById(int id);
}
