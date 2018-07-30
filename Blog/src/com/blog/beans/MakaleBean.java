package com.blog.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.blog.entities.Makale;
import com.mergeCons.egitim.util.EntityUtil;

@ManagedBean
@SessionScoped
public class MakaleBean {
	private Makale makale = new Makale();
	private List<Makale> makaleCek = new ArrayList<Makale>();

	public void makaleGetir() {
		EntityManager em = EntityUtil.getEntityManager();
		String queryString = "FROM Makale Where kategoriID=:ad";
		Query query = em.createQuery(queryString);
		query.setParameter("ad", makale.getKategori().getKategoriID());
		makaleCek = query.getResultList();
		getListMakale();
		System.out.println(makale.getKategori().getKategoriID());
	}

	public List<Makale> getListMakale() {
		
		return makaleCek;
	}

	public void kaydet() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(makale);
		em.getTransaction().commit();
		makale = new Makale();
	}

	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(makale);
		em.getTransaction().commit();
		makale = new Makale();
	}

	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(makale);
		em.getTransaction().commit();
		makale = new Makale();
	}

	@SuppressWarnings("unchecked")
	public List<Makale> getMakaleListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		String queryString = "FROM Makale";
		Query query = em.createQuery(queryString);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Makale> getSecilenKategoriListesi() {

		EntityManager em = EntityUtil.getEntityManager();
		String queryString = "FROM Makale Where kategoriID=15";
		Query query = em.createQuery(queryString);
		return query.getResultList();

	}

	public Makale getMakale() {
		return makale;
	}

	public void setMakale(Makale makale) {
		this.makale = makale;
	}

	public List<Makale> getMakaleCek() {
		return makaleCek;
	}

	public void setMakaleCek(List<Makale> makaleCek) {
		this.makaleCek = makaleCek;
	}

}