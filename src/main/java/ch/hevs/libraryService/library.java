package ch.hevs.libraryService;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;

public interface Library {
	public List<Book> getBookListByWriterLastname(String lastname);
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname);
	public List<Book> getAllBooks();
	public List<Customer>getCustomers();
	public List<Writer>getWritters();
	public String borrow(Customer borrower, Book borrowedBook) throws Exception;
}
