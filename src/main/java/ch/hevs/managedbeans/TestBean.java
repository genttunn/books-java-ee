package ch.hevs.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Book;

import ch.hevs.libraryService.Library;

public class TestBean {
	private Library library;
	private List<String> bookNames;
	 @PostConstruct
	    public void init() throws NamingException{
		 	System.out.println("init here");
	    	InitialContext ctx = new InitialContext();
			library = (Library) ctx.lookup("java:global/LibraryProject-0.0.1/LibraryBean!ch.hevs.libraryService.Library");
	    }
	 
	 public String addBooks() {
		 System.out.println("add books here");
			library.insertBookData();
			return "method executed";
	 }
	    public List<String> getBooks() {
	    	this.bookNames = library.getAllBookNames();
			return bookNames;
	    }
}
