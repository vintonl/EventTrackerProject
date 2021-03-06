package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Beverage;

public interface BeverageService {
	List<Beverage> findAll();

	Beverage findById(int id);

	Beverage createBeverage(Beverage bev);

	Beverage updateBeverage(int id, Beverage bev) throws Exception;

	boolean deleteBeverage(int id);

	List<Beverage> findByCaffeinated();

	List<Beverage> findByKeyword(String keyword);

	List<Beverage> findByCaffeineBetween(Integer min, Integer max);

	List<Beverage> findByCreatedAt(String date);

	Beverage createBeverage(int id, Beverage bev) throws Exception;

	boolean deleteBeverage(int userId, int bevId);

}