package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.jpaeventtracker.entities.Beverage;

public interface BeverageService {

	List<Beverage> findBeveragesByNameOrDescription(String keyword);

}
