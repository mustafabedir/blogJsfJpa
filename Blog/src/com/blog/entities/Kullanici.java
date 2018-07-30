package com.blog.entities;

import javax.persistence.*;

@Entity
@Table(name = "kullanici")
public class Kullanici {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer kullaniciID;
	@Column(nullable = false)
	private String kullaniciAd;
	@Column(nullable = false)
	private String kullaniciSifre;
	
	
	public Integer getKullaniciID() {
		return kullaniciID;
	}
	public void setKullaniciID(Integer kullaniciID) {
		this.kullaniciID = kullaniciID;
	}
	public String getKullaniciAd() {
		return kullaniciAd;
	}
	public void setKullaniciAd(String kullaniciAd) {
		this.kullaniciAd = kullaniciAd;
	}
	public String getKullaniciSifre() {
		return kullaniciSifre;
	}
	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	

}
