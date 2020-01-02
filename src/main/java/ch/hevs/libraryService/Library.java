package ch.hevs.libraryService;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;
import ch.hevs.businessobject.Category;
public interface Library {
	public List<Book> getBookListByWriterLastname(String lastname);
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname);
	
	public List<Customer>getCustomers();
	public List<Writer>getWriters();
	public void borrow(Customer borrower, Book borrowedBook) throws Exception;
	public void addCategoryToBook(Book book, Category cat) throws Exception;
	public void insertCustomer(String lastName, String firstName, int yearBorn)throws Exception;
	public void insertWriter(String lastName, String firstName, int yearBorn)throws Exception;
	public List<Customer> getCustomerByLastName(String lastname) throws Exception;
	
	public void insertBookData();

	public String bookName();
	List<String> getAllBookNames();
	public List<Book> getAllBooks();
	public List<Borrowing> getBorrowings();
}



