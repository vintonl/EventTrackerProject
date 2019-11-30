package com.skilldistillery.eventtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Beverage;
import com.skilldistillery.eventtracker.repositories.BeverageRepository;

@Service
public class BeverageServiceImpl implements BeverageService {

	@Autowired
	private BeverageRepository bevRepo;

	@Override
	public List<Beverage> findAll() {
		return bevRepo.findAll();
	}

}
