package com.blog.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "makale")
public class Makale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer makaleID;
	private String makaleBaslik;
	private String makaleIcerik;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "kategoriID")
	private Kategori kategori;

	public Integer getMakaleID() {
		return makaleID;
	}

	public void setMakaleID(Integer makaleID) {
		this.makaleID = makaleID;
	}

	public String getMakaleBaslik() {
		return makaleBaslik;
	}

	public void setMakaleBaslik(String makaleBaslik) {
		this.makaleBaslik = makaleBaslik;
	}

	public String getMakaleIcerik() {
		return makaleIcerik;
	}

	public void setMakaleIcerik(String makaleIcerik) {
		this.makaleIcerik = makaleIcerik;
	}

	public Kategori getKategori() {
		return kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

}
