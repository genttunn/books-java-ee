package ch.hevs.libraryService;

import java.sql.Date;
import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;
import ch.hevs.businessobject.Customer;


public interface Library {
	public List<Book> getBookListByWriterLastname(String lastname);
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname);
	
	public List<Customer>getCustomers();
	public List<Writer>getWriters();
	public void borrow(Customer borrower, Book borrowedBook) throws Exception;
	public void addCategoryToBook(Book book, Category cat) throws Exception;
	public void insertCustomer(String lastName, String firstName, int yearBorn)throws Exception;
	public void insertWriter(String lastName, String firstName, int yearBorn)throws Exception;
	public Customer getCustomerByLastName(String lastname) throws Exception;
	public Book getBookByName(String name);
	public void insertBookData();
	
	public void deleteBook(Book book);
	public void deleteBorrowing(String bookname, Date date);

	public String bookName();
	List<String> getAllBookNames();
	public List<Book> getAllBooks();
	public List<Borrowing> getBorrowings();
}

