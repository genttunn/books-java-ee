package ch.hevs.libraryService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
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

// Roles
// Librarian = L
// Borrower = B
//Declarative security: add a constraint in LibraryBean (using @RolesAllowed)
@RolesAllowed(value = { "librarian" , "borrower" })
@Stateful
public class LibraryBean implements Library {
	@PersistenceContext(name = "LibraryPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	@Resource
	private SessionContext ctx;

	// L and B View all writers
	@Override
	public List<Writer> getWriters() {
		return em.createQuery("FROM Writer").getResultList();
	}

	// L and B View writer's books
	@Override
	public List<Book> getBookListByWriterLastname(String lastname) {
		Query query = em.createQuery("SELECT w.books FROM Writer w WHERE w.lastname=:lastname");
		query.setParameter("lastname", lastname);
		return (List<Book>) query.getResultList();
	}

	// L and B View customer's borrowing
	@Override
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname) {
		Query query = em.createQuery("SELECT c.borrowing FROM Customer c WHERE c.lastname=:lastname");
		query.setParameter("lastname", lastname);
		return (List<Borrowing>) query.getResultList();
	}

	// B View all customer
	@Override
	public List<Customer> getCustomers() {
		return em.createQuery("FROM Customer").getResultList();
	}

	// B and L Create customer
	@Override
	public void insertCustomer(String lastName, String firstName, int yearBorn) throws Exception {
		Customer cust = new Customer(lastName, firstName, yearBorn);
		em.persist(cust);
	}
	@Override
	public Customer getCustomerByLastName(String lastname) throws Exception {
		Query query = em.createQuery("SELECT c FROM Customer c WHERE c.lastname=:lastname");
		query.setParameter("lastname", lastname);
		return (Customer) query.getResultList().get(0);
	}

	// L and B
	@Override
	public void borrow(Customer borrower, Book borrowedBook) throws Exception {

		System.out.println(
				borrower.getFirstName() + " " + borrower.getLastName() + " has borrowed " + borrowedBook.getName());

		Date currentDate = Date.valueOf(LocalDate.now());
		borrowedBook.setStatusAvailable(false);
		
		Borrowing borrowing = new Borrowing(borrowedBook, borrower, currentDate);
		borrower.addBorrowing(borrowing);
		em.persist(borrower);
		em.persist(borrowedBook);
		em.persist(borrowing);


	}

	@Override
	public void addCategoryToBook(Book book, Category cat) throws Exception {

		System.out.println(book.getName() + " is now categorized as " + cat.getName());

		em.persist(book);
		em.persist(cat);
		book.addCategory(cat);
	}

	@Override
	public void insertWriter(String lastName, String firstName, int yearBorn) throws Exception {

		Writer Writer = new Writer(lastName, firstName, yearBorn);
		em.persist(Writer);
		// To be defined...
	}

	@Override
	public void insertBookData() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//		LocalDateTime localDateTime = LocalDateTime.now();
//		String date = dtf.format(localDateTime);
		Date currentDate = Date.valueOf(LocalDate.now());
		Book b1 = new Book("Harry Pooter", 1990, true);
		Book b2 = new Book("Lord of the Bracelet", 1983, true);
		Writer w1 = new Writer("J.K", "Rowling", 1987);
		Writer w2 = new Writer("J.R.R", "Tolkien", 1977);
		Customer c1 = new Customer("Hanks", "Tom", 1990);
		Borrowing bo1 = new Borrowing(b1, c1, currentDate);
		c1.addBorrowing(bo1);
		w1.addBook(b1);
		w2.addBook(b2);
		em.persist(b1);
		em.persist(b2);
		em.persist(w1);
		em.persist(w2);
		em.persist(c1);
		em.persist(bo1);
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
	public Book getBookByName(String name) {
		Query query = em.createQuery("SELECT b FROM Book b WHERE b.name=:name");
		query.setParameter("name", name);
		return (Book) query.getResultList().get(0);
	}
	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("FROM Book").getResultList();
	}
	@Override
	public List<Borrowing> getBorrowings() {
		return em.createQuery("FROM Borrowing").getResultList();
	}
	
}
