package com.skilldistillery.jpaeventtracker.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "beverage_tracker")
public class BeverageTracker {

//	+---------------+-------------+------+-----+---------+----------------+
//	| Field         | Type        | Null | Key | Default | Extra          |
//	+---------------+-------------+------+-----+---------+----------------+
//	| id            | int(11)     | NO   | PRI | NULL    | auto_increment |
//	| first_name    | varchar(45) | YES  |     | NULL    |                |
//	| last_name     | varchar(45) | YES  |     | NULL    |                |
//	| date_consumed | datetime    | YES  |     | NULL    |                |
//	+---------------+-------------+------+-----+---------+----------------+

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "date_consumed")
	@CreationTimestamp
	private Date dateConsumed;

	@JsonIgnore
	@OneToMany(mappedBy = "beverageTracker")
	private List<Beverage> beverages;
	
	public BeverageTracker() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateConsumed() {
		return dateConsumed;
	}

	public void setDateConsumed(Date dateConsumed) {
		this.dateConsumed = dateConsumed;
	}

	public List<Beverage> getBevs() {
		return beverages;
	}

	public void setBevs(List<Beverage> bevs) {
		this.beverages = bevs;
	}

	public List<Beverage> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<Beverage> beverages) {
		this.beverages = beverages;
	}

	@Override
	public String toString() {
		return "BeverageTracker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateConsumed="
				+ dateConsumed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeverageTracker other = (BeverageTracker) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
