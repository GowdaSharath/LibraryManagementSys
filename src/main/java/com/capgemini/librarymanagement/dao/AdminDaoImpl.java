package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.User;
@Repository
public class AdminDaoImpl implements AdminDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;

	private Integer id;

	@Override
	public Boolean deleteStudent(String userId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			User user = null;
			user = entityManager.find(User.class, userId);
			if (user == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(user);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
	}

	@Override
	public User searchStudent(String userId) {
		entityManager = entityManagerFactory.createEntityManager();
		User user=null;
		String jpql="from User where id= :id and type='student'" ;	
		Query query=(Query)entityManager.createQuery(jpql);
		query.setParameter( "id",userId);
		user = (User)query.getSingleResult();
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public User searchLibrarian(String LibrarianId) {
		entityManager = entityManagerFactory.createEntityManager();
		User librarian=null;
		String jpql="from User where id= :id and type='librarian'" ;	
		Query query=(Query)entityManager.createQuery(jpql);
		query.setParameter( "id",LibrarianId);
		librarian = (User)query.getSingleResult();
		if(librarian!=null) {
			return librarian;
		}else {
			return null;
		}
	}

	@Override
	public Boolean deleteLibrarian(String LibrarianId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			User librarian = null;
			librarian = entityManager.find(User.class, LibrarianId);
			if (librarian == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(librarian);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
		
	}

	@Override
	public List<User> getAllLibrarian() {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from User where type='librarian'";
		Query query = entityManager.createQuery(jpqa);
		List<User> librarian = null;
		
		try {
			librarian = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return librarian;
	}

	@Override
	public List<User> getAllStudent() {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from User where type ='student'";
		Query query = entityManager.createQuery(jpqa);
		List<User> student = null;
		
		try {
			student = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return student;
	}

	@Override
	public Boolean registerLibrarian(User librarian) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(librarian);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}

	@Override
	public Boolean registerStudent(User student) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}

	

	@Override
	public User login(String id, String password) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql="from User where id=:id  and password=:pw  and type='admin'" ;	
		Query query=entityManager.createQuery(jpql);
		query.setParameter( "id",id);
		query.setParameter( "pw",password);
		User admin=(User) query.getSingleResult();
		if(admin!=null) {
			return admin;
		}else {
			return null;	
		}
	}
	
	

}
