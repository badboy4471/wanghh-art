package com.whh.art.dao.model;

public class ArtModel {
	private int id;
	private String artNumber;
	private String artName;
	private String artSize;
	private String artMaterial;
	private String artAuthor;
	private String artCert;
	private String artYear;
	private String artImage;
	private String artDesc;
	private String imageUrl;
	private String audioUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArtNumber() {
		return artNumber;
	}
	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	public String getArtName() {
		return artName;
	}
	public void setArtName(String artName) {
		this.artName = artName;
	}
	public String getArtSize() {
		return artSize;
	}
	public void setArtSize(String artSize) {
		this.artSize = artSize;
	}
	public String getArtMaterial() {
		return artMaterial;
	}
	public void setArtMaterial(String artMaterial) {
		this.artMaterial = artMaterial;
	}
	public String getArtAuthor() {
		return artAuthor;
	}
	public void setArtAuthor(String artAuthor) {
		this.artAuthor = artAuthor;
	}
	public String getArtCert() {
		return artCert;
	}
	public void setArtCert(String artCert) {
		this.artCert = artCert;
	}
	public String getArtYear() {
		return artYear;
	}
	public void setArtYear(String artYear) {
		this.artYear = artYear;
	}
	public String getArtImage() {
		return artImage;
	}
	public void setArtImage(String artImage) {
		this.artImage = artImage;
	}
	public String getArtDesc() {
		return artDesc;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	@Override
	public String toString() {
		return "ArtModel [id=" + id + ", artNumber=" + artNumber + ", artName="
				+ artName + ", artSize=" + artSize + ", artMaterial="
				+ artMaterial + ", artAuthor=" + artAuthor + ", artCert="
				+ artCert + ", artYear=" + artYear + ", artImage=" + artImage
				+ ", artDesc=" + artDesc + "]";
	}
	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}
	
	
}
