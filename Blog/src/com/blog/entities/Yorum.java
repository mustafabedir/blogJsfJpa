package com.blog.entities;

import javax.persistence.*;

@Entity
@Table(name = "yorum")
public class Yorum {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer yorumID;
	private String yorumMetni;
	private String adSoyad;
	private String eMail;
	@ManyToOne(cascade = CascadeType.ALL)
	private Makale makale = new Makale();
	
	
	public Integer getYorumID() {
		return yorumID;
	}
	public void setYorumID(Integer yorumID) {
		this.yorumID = yorumID;
	}
	public String getYorumMetni() {
		return yorumMetni;
	}
	public void setYorumMetni(String yorumMetni) {
		this.yorumMetni = yorumMetni;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Makale getMakale() {
		return makale;
	}
	public void setMakale(Makale makale) {
		this.makale = makale;
	} 
	
	
}
