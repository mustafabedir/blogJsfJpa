package com.blog.entities;

import javax.persistence.*;

@Entity
@Table(name = "etiket")
public class Etiket {
	@Id
	@GeneratedValue
	private Integer etiketID;
	private String etiketAd;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "makale_makaleID")
	private Makale makale;
	
	public Integer getEtiketID() {
		return etiketID;
	}
	public void setEtiketID(Integer etiketID) {
		this.etiketID = etiketID;
	}
	public String getEtiketAd() {
		return etiketAd;
	}
	public void setEtiketAd(String etiketAd) {
		this.etiketAd = etiketAd;
	}
	public Makale getMakale() {
		return makale;
	}
	public void setMakale(Makale makale) {
		this.makale = makale;
	}
	
	
}
