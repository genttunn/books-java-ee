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
	
	private Customer customer;
	private String customerName;
	private List<String> customerNames;
	
	private Book book;
	private String bookName;
	private List<String> bookNames;
	
	@PostConstruct
	public void init() throws NamingException {
		System.out.println("init here");
		InitialContext ctx = new InitialContext();
		library = (Library) ctx.lookup("java:global/LibraryProject-0.0.1/LibraryBean!ch.hevs.libraryService.Library");
		addBooks();

	}

	
	
	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
			this.customerNames.add(c.getLastName());
		}
		System.out.println(this.customerNames);
		return customerNames;
	}

	public List<String> getBookNames() {
		List<Book> bookList = library.getAllBooks();
		for (Book b : bookList) {
			this.bookNames.add(b.getName());
		}
		return bookNames;
	}
	
	public String performAddWriter() {
		try {
			library.insertWriter(lastNameWriter, firstNameWriter, yearBornWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listWriters";
	}
	public String performAddBorrowing() {
		try {
			library.borrow(customer, book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listBorrowings";
	}
	// TO DO
	public void updateCustomer(ValueChangeEvent event) throws Exception {
    	this.customerName = (String)event.getNewValue(); 	
	    this.customer = library.getCustomerByLastName(customerName);
    }
	public void updateBook(ValueChangeEvent event) throws Exception {
    	this.bookName = (String)event.getNewValue(); 	
	    this.book = library.getBookByName(bookName);
    }

