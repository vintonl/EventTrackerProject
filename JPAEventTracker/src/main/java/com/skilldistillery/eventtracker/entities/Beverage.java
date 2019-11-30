package com.skilldistillery.eventtracker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Beverage {

//	+------------------+--------------+------+-----+-------------------+-----------------------------+
//	| Field            | Type         | Null | Key | Default           | Extra                       |
//	+------------------+--------------+------+-----+-------------------+-----------------------------+
//	| id               | int(11)      | NO   | PRI | NULL              | auto_increment              |
//	| name             | varchar(200) | NO   |     | NULL              |                             |
//	| description      | varchar(400) | YES  |     | NULL              |                             |
//	| ingredients      | text         | YES  |     | NULL              |                             |
//	| caffeinated      | tinyint(4)   | NO   |     | 0                 |                             |
//	| contains_alcohol | tinyint(4)   | NO   |     | 0                 |                             |
//	| calories         | int(11)      | NO   |     | 0                 |                             |
//	| volume           | double       | NO   |     | 8                 |                             |
//	| active           | tinyint(4)   | NO   |     | 1                 |                             |
//	| user_id          | int(11)      | NO   | MUL | NULL              |                             |
//	| caffeine         | int(11)      | NO   |     | 0                 |                             |
//	| updated_at       | datetime     | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
//	| created_at       | date         | NO   |     | NULL              |                             |
//	+------------------+--------------+------+-----+-------------------+-----------------------------+

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String ingredients;
	private boolean caffeinated;
	private Integer caffeine;
	@Column(name = "contains_alcohol")
	private boolean containsAlcohol;
	private Integer calories;
	private Double volume;
	private boolean active;
	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return "Beverage [id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients
				+ ", caffeinated=" + caffeinated + ", caffeine=" + caffeine + ", containsAlcohol=" + containsAlcohol
				+ ", calories=" + calories + ", volume=" + volume + ", active=" + active + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", user=" + user + "]";
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

	public Integer getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Integer caffeine) {
		this.caffeine = caffeine;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Beverage() {
		super();
	}

}
