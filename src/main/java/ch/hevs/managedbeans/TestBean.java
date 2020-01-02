package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Borrowing;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Writer;
import ch.hevs.libraryService.Library;

public class TestBean {
	private Library library;
	private List<Book> books;
	private List<Writer> writers;
	private List<Borrowing> borrowings;
	private String firstNameWriter;
	private String lastNameWriter;
	private int yearBornWriter;
	
	
	private String customer;
	private List<String> customerNames;
	
	
	@PostConstruct
	public void init() throws NamingException {
		System.out.println("init here");
		InitialContext ctx = new InitialContext();
		library = (Library) ctx.lookup("java:global/LibraryProject-0.0.1/LibraryBean!ch.hevs.libraryService.Library");
		addBooks();

	}

	
	
	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}

	

	public String getFirstNameWriter() {
		return firstNameWriter;
	}

	public void setFirstNameWriter(String firstNameWriter) {
		this.firstNameWriter = firstNameWriter;
	}

	public String getLastNameWriter() {
		return lastNameWriter;
	}

	public void setLastNameWriter(String lastNameWriter) {
		this.lastNameWriter = lastNameWriter;
	}

	public int getYearBornWriter() {
		return yearBornWriter;
	}

	public void setYearBornWriter(int yearBornWriter) {
		this.yearBornWriter = yearBornWriter;
	}

	public String addBooks() {
		System.out.println("add books here");
		library.insertBookData();
		return "method executed";
	}

	public List<Book> getBooks() {
		this.books = library.getAllBooks();
		return books;
	}

	public List<Writer> getWriters() {
		this.writers = library.getWriters();
		return writers;
	}

	public List<Borrowing> getBorrowings() {
		this.borrowings = library.getBorrowings();
		return borrowings;
	}
	
	///////////////

	public List<String> getCustomerNames() {
		List<Customer> customerList = library.getCustomers();
		for (Customer c : customerList) {
			this.customerNames.add(c.getFirstName() + " " + c.getLastName());
		}
		return customerNames;
	}

	public String performAddWriter() {
		try {
			library.insertWriter(lastNameWriter, firstNameWriter, yearBornWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listWriters";
	}
	
	// TO DO
	public void updateCustomer(ValueChangeEvent event) {
//    	this.customer = (String)event.getNewValue();
//    	
//	    List<Customer> customerList = bank.getAccountListFromClientLastname(this.sourceClientName);
//	    this.sourceAccountDescriptions = new ArrayList<String>();
//		for (Account account : accounts) {
//			this.sourceAccountDescriptions.add(account.getDescription());
		}
    }
}
