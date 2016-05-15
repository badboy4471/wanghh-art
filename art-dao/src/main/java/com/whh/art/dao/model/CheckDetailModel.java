package com.whh.art.dao.model;

public class CheckDetailModel {
	private int id;
	private String artNumber;
	private String artInnerNumber;//内部编号
	private String artName;
	private String artSize;
	private String artMaterial;
	private String artAuthor;
	private String artCert;
	private String artYear;
	private String artImage;
	private String artDesc;
	private String artAudio;
	private float artPrice;
	private int come;
	private int type;
	private int receiptId;
	private int ceeateUid;
	
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
	public String getArtInnerNumber() {
		return artInnerNumber;
	}
	public void setArtInnerNumber(String artInnerNumber) {
		this.artInnerNumber = artInnerNumber;
	}
	
	public String getArtAudio() {
		return artAudio;
	}
	public void setArtAudio(String artAudio) {
		this.artAudio = artAudio;
	}
	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}
	public float getArtPrice() {
		return artPrice;
	}
	public void setArtPrice(float artPrice) {
		this.artPrice = artPrice;
	}
	public int getCome() {
		return come;
	}
	public void setCome(int come) {
		this.come = come;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getCeeateUid() {
		return ceeateUid;
	}
	public void setCeeateUid(int ceeateUid) {
		this.ceeateUid = ceeateUid;
	}
	@Override
	public String toString() {
		return "CheckDetailModel [id=" + id + ", artNumber=" + artNumber
				+ ", artInnerNumber=" + artInnerNumber + ", artName=" + artName
				+ ", artSize=" + artSize + ", artMaterial=" + artMaterial
				+ ", artAuthor=" + artAuthor + ", artCert=" + artCert
				+ ", artYear=" + artYear + ", artImage=" + artImage
				+ ", artDesc=" + artDesc + ", artAudio=" + artAudio
				+ ", artPrice=" + artPrice + ", come=" + come + ", type="
				+ type + ", receiptId=" + receiptId + ", ceeateUid="
				+ ceeateUid + "]";
	}
	
}
