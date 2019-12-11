package ch.hevs.libraryService;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;

public class libraryBean implements library{

	@Override
	public List<Book> getBookListByWriterLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Borrowing> getBorrowingListByCustomerLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
