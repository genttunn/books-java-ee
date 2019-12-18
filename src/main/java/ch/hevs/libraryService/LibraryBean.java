package ch.hevs.libraryService;

import java.sql.Date;
import java.time.LocalDate;
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
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;

@Stateful
public class LibraryBean implements Library {
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
		Query query = em.createQuery("SELECT c.borrowing FROM Customer c WHERE c.lastname=:lastname");
		query.setParameter("lastname", lastname);
		return (List<Borrowing>) query.getResultList();
	}

	@Override
	public List<Writer> getWriters() {
		return em.createQuery("FROM Writer").getResultList();
	}

	@Override
	public void borrow(Customer borrower, Book borrowedBook) throws Exception {

		System.out.println(
				borrower.getFirstName() + " " + borrower.getLastName() + " has borrowed " + borrowedBook.getName());

		Date currentDate = Date.valueOf(LocalDate.now());
		Borrowing borrowing = new Borrowing();

		em.persist(borrower);
		em.persist(borrowedBook);
		em.persist(borrowing);

		borrowedBook.setStatusAvailable(false);
		borrowing = new Borrowing(borrowedBook, borrower, currentDate);
		borrower.addBorrowing(borrowing);
	}

	@Override
	public void addCategoryToBook(Book book, Category cat) throws Exception {

		System.out.println(book.getName() + " is now categorized as " + cat.getName());

		em.persist(book);
		em.persist(cat);
		book.addCategory(cat);
	}

	@Override
	public void insertCustomer(String lastName, String firstName, int yearBorn) throws Exception {

		Customer cust = new Customer(lastName, firstName, yearBorn);
		
		// To be defined...
	}

	@Override
	public void insertWriter(String lastName, String firstName, int yearBorn) throws Exception {

		Writer Writer = new Writer(lastName, firstName, yearBorn);
		
		// To be defined...
	}
	@Override 
	public void insertBookData() {
			Book b1 = new Book("Harry Pooter",1990, true);
			Book b2 = new Book("Lord of the Bracelet",1983, true);
			em.persist(b1);
			em.persist(b2);
	}
	@Override
	public String bookName() {
		return null;
	}

	@Override
	public List<String> getAllBookNames() {
		return em.createQuery("SELECT o.name FROM Book o").getResultList();
	}
	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("FROM Book").getResultList();
	}

	@Override
	public List<Customer> getCustomers() {
		return null;
	}
}

