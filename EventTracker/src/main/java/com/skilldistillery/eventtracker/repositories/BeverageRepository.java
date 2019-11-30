package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpaeventtracker.entities.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Integer> {

}