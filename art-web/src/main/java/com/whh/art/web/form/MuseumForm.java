package com.whh.art.web.form;

import java.util.List;

import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;

public class MuseumForm {
	
	private MuseumModel museum;
	private List<ArtModel> arts;
	private int artCount;
	public MuseumModel getMuseum() {
		return museum;
	}
	public void setMuseum(MuseumModel museum) {
		this.museum = museum;
	}
	public List<ArtModel> getArts() {
		return arts;
	}
	public void setArts(List<ArtModel> arts) {
		this.arts = arts;
	}
	public int getArtCount() {
		return artCount;
	}
	public void setArtCount(int artCount) {
		this.artCount = artCount;
	}
	
	

}
