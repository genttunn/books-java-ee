package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Book")
public class Book {
	///FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="yearPublished")
	private int yearPublished;
	
	@Column(name="statusAvailable")
	private boolean statusAvailable;
	
	@OneToMany
	private Set<Category> categories;
	
	///CONSTRUCTORS
	public Book() {
		super();
		this.categories  = new HashSet<Category>();
	}
	
	public Book(String name, int yearPublished, boolean statusAvailable) {
		super();
		this.name = name;
		this.yearPublished = yearPublished;
		this.statusAvailable = statusAvailable;
		this.categories  = new HashSet<Category>();
	}
	
	public Book(String name) {
		super();
		this.name = name;
		this.yearPublished = 0;
		this.statusAvailable = true;
		this.categories  = new HashSet<Category>();
	}
	
	
	///GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public boolean isStatusAvailable() {
		return statusAvailable;
	}

	public void setStatusAvailable(boolean statusAvailable) {
		this.statusAvailable = statusAvailable;
	}
	
	// HELPERS
	public void addCategory(Category c) {
		categories.add(c);
	}
	
}
