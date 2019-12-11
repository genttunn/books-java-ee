package ch.hevs.libraryService;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;
@Stateful
public class LibraryBean implements Library  {
	@PersistenceContext(name = "LibraryPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	@Resource 
	private SessionContext ctx;
	
	@Override
	public List<Book> getBookListByWriterLastname(String lastname) {
		Query query = em.createQuery("SELECT w.books FROM Writer w WHERE w.lastname=:lastname");
		query.setParameter("lastname", lastname);
		return (List<Book>) query.getResultList();
	}

	@Override
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("FROM Book").getResultList();
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Writer> getWritters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String borrow(Customer borrower, Book borrowedBook) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
