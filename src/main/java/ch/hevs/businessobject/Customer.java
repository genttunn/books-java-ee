package ch.hevs.businessobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer extends Person {
	@OneToMany
	@JoinColumn(name = "FK_CUSTOMER")
	private Set<Borrowing> borrowings;

	public Customer() {
		super();
		this.borrowings = new HashSet<Borrowing>();
	}

	public Customer(String lastName, String firstName, int yearBorn) {
		super(lastName, firstName, yearBorn);
		this.borrowings = new HashSet<Borrowing>();
	}
	
	// Helper methods
	public void addBorrowings(Borrowing b) {
		borrowings.add(b);
	}
}
