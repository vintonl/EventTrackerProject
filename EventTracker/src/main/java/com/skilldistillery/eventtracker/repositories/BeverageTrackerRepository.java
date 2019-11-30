package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jpaeventtracker.entities.Beverage;
import com.skilldistillery.jpaeventtracker.entities.BeverageTracker;

public interface BeverageTrackerRepository extends JpaRepository<BeverageTracker, Integer> {

}