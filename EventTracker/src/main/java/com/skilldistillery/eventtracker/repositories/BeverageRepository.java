package com.skilldistillery.eventtracker.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {

	List<Beverage> findByCaffeinatedTrue();

	List<Beverage> findByNameContaining(String keyword);

	List<Beverage> findByCaffeineBetween(Integer min, Integer max);

	List<Beverage> findByCreatedAtBetween(Date start, Date end);
}