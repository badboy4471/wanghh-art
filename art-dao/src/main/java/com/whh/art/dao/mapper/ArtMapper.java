package com.whh.art.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.SearchModel;

public interface ArtMapper {
	
	void insertArt(ArtModel model);
	
	ArtModel getArt(int id);
	
	void updateArtImage(@Param("id")int id,@Param("artImageUrl")String artImageUrl);
	
	void updateArtAudio(@Param("id")int id, @Param("artAudioUrl")String artAudioUrl);
	
	void deletArt(int id);
	
	List<ArtModel> searchArts(SearchModel search);
	
	int countArts(SearchModel search);

}
