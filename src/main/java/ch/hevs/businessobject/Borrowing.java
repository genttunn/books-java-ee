package ch.hevs.businessobject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Borrowing")

public class Borrowing 
{

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Customer customer;
	
	@Column(name="dateBorrow")
	private Date dateBorrow;
	
	public Borrowing(long id) {
		super();
		this.id = id;
	}
	
	public Borrowing() {
		super();
	}



	public Borrowing(long id, Book book, Customer customer, Date dateBorrow) {
		super();
		this.id = id;
		this.book = book;
		this.customer = customer;
		this.dateBorrow = dateBorrow;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateBorrow() {
		return dateBorrow;
	}

	public void setDate(Date dateBorrow) {
		this.dateBorrow = dateBorrow;
	}	
}
