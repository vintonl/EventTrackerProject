package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Beverage;
import com.skilldistillery.eventtracker.entities.BeverageTracker;

public interface BeverageTrackerRepository extends JpaRepository<BeverageTracker, Integer> {

}