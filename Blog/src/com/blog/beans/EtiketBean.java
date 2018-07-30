package com.blog.beans;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.blog.entities.Etiket;
import com.blog.entities.Kategori;
import com.blog.entities.Makale;
import com.mergeCons.egitim.util.EntityUtil;

@ManagedBean
@SessionScoped
public class EtiketBean {
	
	private Etiket etiket;
	private KullaniciBean kb = new KullaniciBean();
	
	public EtiketBean() {
		// TODO Auto-generated constructor stub
		denetle();
	}
	
	public String denetle()
	{
		if(kb.isDeger()==false)
		{
			return "Login?faces-redirect=true";
		}
		else
			return "Makale?faces-redirect=true";
		
	}
	
	@PostConstruct
	public void init() {
		etiket = new Etiket();
		Makale makale = new Makale(); 
		makale.setKategori(new Kategori());
		etiket.setMakale(makale);
	}

	public void kaydet() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		String queryString = "FROM Kategori where kategoriID=:ID";
		Query query = em.createQuery(queryString);
		query.setParameter("ID", etiket.getMakale().getKategori().getKategoriID());
		
		Kategori kategori = (Kategori) query.getSingleResult();
		etiket.getMakale().setKategori(kategori);
		em.persist(etiket);
		em.getTransaction().commit();
		init();
	}

	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		String queryString = "FROM Etiket where etiketID=:ID";
		Query query = em.createQuery(queryString);
		query.setParameter("ID", etiket.getEtiketID());
		
		Etiket rmEtiket = (Etiket) query.getSingleResult();
		em.remove(rmEtiket);
		em.getTransaction().commit();
		init();
	}

	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		
		String queryString2 = "FROM Etiket where etiketID=:ID";
		Query query2 = em.createQuery(queryString2);
		query2.setParameter("ID", etiket.getEtiketID());
		Etiket duzenleEtiket = (Etiket) query2.getSingleResult();
		
		String queryString = "FROM Kategori where kategoriID=:ID";
		Query query = em.createQuery(queryString);
		query.setParameter("ID", etiket.getMakale().getKategori().getKategoriID());
		
		Kategori kategori = (Kategori) query.getSingleResult();
		duzenleEtiket.getMakale().setMakaleBaslik(etiket.getMakale().getMakaleBaslik());
		duzenleEtiket.getMakale().setMakaleIcerik(etiket.getMakale().getMakaleIcerik());
		duzenleEtiket.getMakale().setKategori(kategori);
		duzenleEtiket.setEtiketAd(etiket.getEtiketAd());
		em.merge(duzenleEtiket);
		em.getTransaction().commit();
		init();
	}

	@SuppressWarnings("unchecked")
	public List<Etiket> getEtiketListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		String queryString = "FROM Etiket";
		Query query = em.createQuery(queryString);
		return query.getResultList();

	}

	public Etiket getEtiket() {
		return etiket;
	}

	public void setEtiket(Etiket etiket) {
		this.etiket = etiket;
	}


}
