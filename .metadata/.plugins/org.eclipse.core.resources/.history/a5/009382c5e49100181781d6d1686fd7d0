package com.mergeCons.egitim.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {
	private static EntityManagerFactory entityManagerFactory;
	public static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<EntityManager>();

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("baglantiBir");
		}
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = threadLocal.get();
		if (entityManager == null) {
			entityManager = getEntityManagerFactory().createEntityManager();
			threadLocal.set(entityManager);
		}
		return entityManager;
	}
}
