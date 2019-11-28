package com.skilldistillery.jpaeventtracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beverage {

//	+------------------+--------------+------+-----+---------+----------------+
//	| Field            | Type         | Null | Key | Default | Extra          |
//	+------------------+--------------+------+-----+---------+----------------+
//	| id               | int(11)      | NO   | PRI | NULL    | auto_increment |
//	| name             | varchar(200) | NO   |     | NULL    |                |
//	| description      | varchar(400) | YES  |     | NULL    |                |
//	| ingredients      | text         | YES  |     | NULL    |                |
//	| caffeinated      | tinyint(4)   | NO   |     | 0       |                |
//	| contains_alcohol | tinyint(4)   | NO   |     | 0       |                |
//	| calories         | int(11)      | NO   |     | 0       |                |
//	| volume           | double       | NO   |     | 8       |                |
//	| active           | tinyint(4)   | NO   |     | 1       |                |
//	+------------------+--------------+------+-----+---------+----------------+

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String ingredients;
	private boolean caffeinated;
	@Column(name = "contains_alcohol")
	private boolean containsAlcohol;
	private Integer calories;
	private Double volume;
	private boolean active;

	public Beverage() {
		super();
	}

	public Beverage(int id, String name, String description, String ingredients, boolean caffeinated,
			boolean containsAlcohol, Integer calories, Double volume, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.caffeinated = caffeinated;
		this.containsAlcohol = containsAlcohol;
		this.calories = calories;
		this.volume = volume;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public boolean isCaffeinated() {
		return caffeinated;
	}

	public void setCaffeinated(boolean caffeinated) {
		this.caffeinated = caffeinated;
	}

	public boolean isContainsAlcohol() {
		return containsAlcohol;
	}

	public void setContainsAlcohol(boolean containsAlcohol) {
		this.containsAlcohol = containsAlcohol;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		Beverage other = (Beverage) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beverage [id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients
				+ ", caffeinated=" + caffeinated + ", containsAlcohol=" + containsAlcohol + ", calories=" + calories
				+ ", volume=" + volume + ", active=" + active + "]";
	}

}
