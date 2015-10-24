package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.mapper.ArtMapper;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;
import com.whh.art.dao.model.SearchModel;

public class ArtServiceImpl implements IArtService {
	
	ArtMapper artMapper;
	

	@Override
	public ArtModel insertArt(ArtModel art) {
		try{
			artMapper.insertArt(art);
			return art;
		}catch(Exception e){
			return art;
		}
		
	}


	@Override
	public ArtModel getArt(String number) {
		SearchModel search = new SearchModel();
		search.setNumber(number);
		
		List<ArtModel> arts = artMapper.searchArts(search);
		if (arts.size() > 0){
			if (arts.size()> 1){
				//TODO 编号重复
			}
			return arts.get(0);
		}
		return null;
	}
	
	@Override
	public boolean numberExist(String number) {
		SearchModel search = new SearchModel();
		search.setNumber(number);
		int count = artMapper.countArts(search);
		
		return count > 0;
	}
	
	@Override
	public void delArt(int id) {
		try{
			artMapper.deletArt(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ArtModel getArt(int id) {
		return artMapper.getArt(id);
	}

	@Override
	public List<ArtModel> searchArts(SearchModel search) {
		return artMapper.searchArts(search);
	}


	@Override
	public int countArts(SearchModel search) {
		return artMapper.countArts(search);
	}

	public void setArtMapper(ArtMapper artMapper) {
		this.artMapper = artMapper;
	}


	@Override
	public void insertMuseum(MuseumModel model) {
		artMapper.insertMuseum(model);
		
	}


	@Override
	public MuseumModel getMuseum(int id) {
		return artMapper.getMuseum(id);
	}


	@Override
	public void deletMuseum(int id) {
		artMapper.deletMuseum(id);
	}


	@Override
	public void updateMuseum(MuseumModel model) {
		artMapper.updateMuseum(model);
	}


	@Override
	public List<MuseumModel> loadAllMuseum() {
		return artMapper.loadAllMuseum();
	}


	@Override
	public void insertArt2Museum(int artId, int museumId) {
		artMapper.insertArt2Museum(artId, museumId);
	}


	@Override
	public List<ArtModel> loadArtsFromMueum(int museumId, int start, int limit) {
		return artMapper.loadArtsFromMueum(museumId, start, limit);
	}


	@Override
	public int countArtsFromMueum(int museumId) {
		return artMapper.countArtsFromMueum(museumId);
	}


	@Override
	public void deleteMuseumArt(int museumId, int artId) {
		if (museumId > 0 || artId > 0){
			artMapper.deleteMuseumArt(museumId, artId);
		}
	}


	@Override
	public void deleteMuseumArtById(int id) {
		artMapper.deleteMuseumArtById(id);
	}
}
