package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Writer extends Person {
	@OneToMany
	@JoinColumn(name = "FK_WRITER")
	private Set<Book> books;

	public Writer() {
		super();
		this.books = new HashSet<Book>();
	}
	public Writer(String lastName, String firstName, int yearBorn) {
		super(lastName, firstName, yearBorn);
		this.books = new HashSet<Book>();
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	
}
