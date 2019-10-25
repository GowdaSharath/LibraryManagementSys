package com.capgemini.librarymanagement.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.Registration;
import com.capgemini.librarymanagement.beans.Transaction;
import com.capgemini.librarymanagement.beans.User;
@Repository
public class StudentDaoImpl implements StudentDao {
	AdminDao admin = new AdminDaoImpl();
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;


	@Override
	public List<Books> getAllBooks() {
		entityManager=entityManagerFactory.createEntityManager();
		String jpqa = "from Books ";
		Query query = entityManager.createQuery(jpqa);
		List<Books> allbooks = null;
		
		try {
			allbooks = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return allbooks;
	}

	@Override
	public Boolean updateStudent(User student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			if(admin.searchStudent(student.getId())==null) {
				return isadded;
			}else {
				transaction.begin();
				entityManager.persist(student);
				transaction.commit();
				isadded=true;
			}
		}catch(Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}

	@Override
	public Boolean requestBook(String userId,String bookId,Date date) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		Registration reg = null;
		String jpqa = "from Registration where userid=:userid and bookid=:bookid and registrationdate=:date";
		Query query= entityManager.createQuery(jpqa);
		query.setParameter("userid", userId);
		query.setParameter("bookid", bookId);
		query.setParameter("date", date);
		Registration bookdetails = (Registration) query.getSingleResult();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(reg);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}

	@Override
	public Boolean returnBook(String transactionid, Date returnDate) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		Transaction returnBook = null;
		String jpqa = "from Transaction where transactionid=id and returndate=:date";
		Query query= entityManager.createQuery(jpqa);
		query.setParameter("id", transactionid);
		query.setParameter("date", returnDate);
		Registration bookdetails = (Registration) query.getSingleResult();
		boolean isreturned= false;
		try {
			transaction.begin();
			entityManager.remove(returnBook);
			transaction.commit();
			isreturned = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isreturned;

	}

	@Override
	public Boolean cancelRequest(Books bookId) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		try {
			Books book = null;
			book = entityManager.find(Books.class, bookId);
			if (book == null) {
				return false;
			} else {
				transaction.begin();
				entityManager.remove(book);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
		
	}

	
	
}
