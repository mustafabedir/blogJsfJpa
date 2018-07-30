package com.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kategori")
public class Kategori {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer kategoriID;
	private String kategoriAd;
	private String kategoriAciklama;

	public Integer getKategoriID() {
		return kategoriID;
	}

	public void setKategoriID(Integer kategoriID) {
		this.kategoriID = kategoriID;
	}

	public String getKategoriAd() {
		return kategoriAd;
	}

	public void setKategoriAd(String kategoriAd) {
		this.kategoriAd = kategoriAd;
	}

	public String getKategoriAciklama() {
		return kategoriAciklama;
	}

	public void setKategoriAciklama(String kategoriAciklama) {
		this.kategoriAciklama = kategoriAciklama;
	}

}
