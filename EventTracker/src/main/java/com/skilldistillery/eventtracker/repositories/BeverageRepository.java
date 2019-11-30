package com.skilldistillery.eventtracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {

//	List<Beverage> findByCaffeinated();
}