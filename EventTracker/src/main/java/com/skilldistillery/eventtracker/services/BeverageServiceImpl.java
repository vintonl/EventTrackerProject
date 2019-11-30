package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Beverage findById(int id) {

		Optional<Beverage> bevOpt = bevRepo.findById(id);
		Beverage bev = null;
		if (bevOpt != null) {
			bev = bevOpt.get();
		}

		return bev;
	}

	@Override
	public Beverage createBeverage(Beverage bev) {
		return bevRepo.saveAndFlush(bev);
	}

	@Override
	public Beverage updateBeverage(int id, Beverage bev) {
		Optional<Beverage> bevOpt = bevRepo.findById(id);
		if (bevOpt.isPresent()) {
			Beverage managedBev = bevOpt.get();
			managedBev.setName(bev.getName());
			managedBev.setDescription(bev.getDescription());
			managedBev.setIngredients(bev.getIngredients());
			managedBev.setCaffeine(bev.getCaffeine());
			managedBev.setVolume(bev.getVolume());
			managedBev.setCalories(bev.getCalories());
			managedBev.setCaffeinated(bev.isCaffeinated());
			managedBev.setContainsAlcohol(bev.isContainsAlcohol());
			managedBev.setActive(bev.isActive());
			return managedBev;
		}

		return null;
	}

	@Override
	public boolean deleteBeverage(int id) {
		Optional<Beverage> bevOpt = bevRepo.findById(id);
		if (bevOpt.isPresent()) {
			Beverage bev = bevOpt.get();
			bevRepo.delete(bev);
			return true;
		}

		return false;
	}

//	@Override
//	public List<Beverage> findByCaffeinated() {
//		return bevRepo.findByCaffeinated();
//	}

}
