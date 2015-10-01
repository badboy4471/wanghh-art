package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.SearchModel;

public interface IArtService {

	ArtModel insertArt(ArtModel art);

	ArtModel getArt(String number);

	ArtModel getArt(int id);

	boolean numberExist(String number);

	List<ArtModel> searchArts(SearchModel search);

	int countArts(SearchModel search);

}
