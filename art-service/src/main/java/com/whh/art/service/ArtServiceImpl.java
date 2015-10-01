package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.mapper.ArtMapper;
import com.whh.art.dao.model.ArtModel;
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
	public ArtModel getArt(int id) {
		return artMapper.getArt(id);
	}

	public void setArtMapper(ArtMapper artMapper) {
		this.artMapper = artMapper;
	}


	@Override
	public List<ArtModel> searchArts(SearchModel search) {
		return artMapper.searchArts(search);
	}


	@Override
	public int countArts(SearchModel search) {
		return artMapper.countArts(search);
	}


	
}
