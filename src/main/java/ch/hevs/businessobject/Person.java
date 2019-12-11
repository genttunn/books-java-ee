package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
	
	/// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String lastName;
	private String firstName;
	private int yearBorn;
	
	/// CONSTRUCTORS
	public Person() {}
	
	public Person(String lastName, String firstName, int yearBorn) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearBorn = yearBorn;
	}
	
	/// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYearBorn() {
		return yearBorn;
	}
	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}
	
	
}
