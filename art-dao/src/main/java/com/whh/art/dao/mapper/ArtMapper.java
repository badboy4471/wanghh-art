package com.whh.art.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;
import com.whh.art.dao.model.SearchModel;

public interface ArtMapper {

	void insertArt(ArtModel model);

	ArtModel getArt(int id);

	void updateArtImage(@Param("id") int id,
			@Param("artImageUrl") String artImageUrl);

	void updateArtAudio(@Param("id") int id,
			@Param("artAudioUrl") String artAudioUrl);

	void deletArt(int id);

	List<ArtModel> searchArts(SearchModel search);

	int countArts(SearchModel search);

	void insertMuseum(MuseumModel model);

	MuseumModel getMuseum(int id);

	void deletMuseum(int id);

	void updateMuseum(MuseumModel model);

	List<MuseumModel> loadAllMuseum();

	void insertArt2Museum(@Param("artId") int artId,
			@Param("museumId") int museumId);

	List<ArtModel> loadArtsFromMueum(@Param("museumId") int museumId,
			@Param("start") int start, @Param("limit") int limit);

	int countArtsFromMueum(int museumId);

	void deleteMuseumArt(@Param("museumId") int museumId,
			@Param("artId") int artId);

	void deleteMuseumArtById(int id);
	
	void updateArt(ArtModel art);

}
