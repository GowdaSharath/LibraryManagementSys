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

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.Registration;
import com.capgemini.librarymanagement.beans.Transaction;
@Repository
public class LibrarianDaoImpl implements LibrarianDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
	private EntityManager entityManager;
	private EntityTransaction transaction;
	Books book = null;

	@Override
	public Boolean add(Books book) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			transaction.begin();
			entityManager.persist(book);
			transaction.commit();
			isadded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}

	@Override
	public Boolean update(Books bookId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isadded = false;
		try {
			if (findBookById(book.getBookid()) == null) {
				return isadded;
			} else {
				transaction.begin();
				entityManager.persist(book);
				;
				transaction.commit();
				isadded = true;
			}
		} catch (Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}

	@Override
	public List<Books> findAll() {
		entityManager = entityManagerFactory.createEntityManager();
		String jpqa = "from Books";
		Query query = entityManager.createQuery(jpqa);
		List<Books> allBooks = null;

		try {
			allBooks = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		entityManager.close();
		return allBooks;
	}

	@Override
	public Books findBookById(String bookId) {
		entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from Books where bookId= :bookId";
		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("bookId", bookId);
		book = (Books) query.getSingleResult();
		if (book != null) {
			return book;
		} else {
			return null;
		}
	}

	@Override
	public Transaction acceptRequest(String registrationid) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		
		String jpqa = "from Registration where registrationid=:regid ";
		Query query= entityManager.createQuery(jpqa);
		query.setParameter("regid", registrationid);
		Registration bookdetails = (Registration) query.getSingleResult();
		Random random = new Random();
		int transactionid = random.nextInt();
		
		Transaction trans = null;
		trans.setRegistrationid(registrationid);
		trans.setTransactionid(Integer.toString(transactionid));
		trans.setIssuedate(bookdetails.getRegistrationdate());
		trans.setFine(0.0);
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(bookdetails.getRegistrationdate());
		cal.add(Calendar.DATE, 14);
		trans.setReturndate(cal.getTime());
				
		entityManager.persist(trans);
		transaction.commit();
			
		return trans;
	}

	@Override
	public Transaction generateFine(String registrationid, Date returndate) {
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		
		String jpqa = "from Transaction where registrationid=:regid ";
		Query query= entityManager.createQuery(jpqa);
		query.setParameter("regid", registrationid);
		Transaction fine = (Transaction) query.getSingleResult();
		Date returnDate = fine.getReturndate();
 		long days=returnDate.getTime()-returndate.getTime();
 		if(days<=0) {
 			fine.setFine(0.0);
 		}else {
 			fine.setFine((double) (days*1));
 		}
 		fine.setReturndate(returnDate);
		
		entityManager.persist(fine);
		transaction.commit();
		return fine;
		
	}

	

}
