package com.blog.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.blog.entities.Yorum;
import com.mergeCons.egitim.util.EntityUtil;

@ManagedBean
@SessionScoped
public class YorumBean {
	
	private Yorum yorum = new Yorum();

	public void kaydet()
	{
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(yorum);
		em.getTransaction().commit();
		yorum = new Yorum();
	}
	
	public void sil() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(yorum);
		em.getTransaction().commit();
		yorum = new Yorum();
	}

	public void duzenle() {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(yorum);
		em.getTransaction().commit();
		yorum = new Yorum();
	}
	
	@SuppressWarnings("unchecked")
	public List<Yorum> getYorumListesi() {
		EntityManager em = EntityUtil.getEntityManager();
		String queryString = "FROM Yorum";
			Query query = em.createQuery(queryString);
		return query.getResultList();
		
	}

	public Yorum getYorum() {
		return yorum;
	}

	public void setYorum(Yorum yorum) {
		this.yorum = yorum;
	}
	
}