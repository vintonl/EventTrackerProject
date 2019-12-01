package com.skilldistillery.eventtracker.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Beverage;
import com.skilldistillery.eventtracker.entities.User;
import com.skilldistillery.eventtracker.repositories.BeverageRepository;
import com.skilldistillery.eventtracker.repositories.UserRepository;

@Service
public class BeverageServiceImpl implements BeverageService {

	@Autowired
	private BeverageRepository bevRepo;
	@Autowired
	private UserRepository uRepo;

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

			if (bev.getCreatedAt() == null) {
				Date date = new Date();
				managedBev.setCreatedAt(date);
			} else {
				managedBev.setCreatedAt(bev.getCreatedAt());
			}

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

	@Override
	public List<Beverage> findByCaffeinated() {
		return bevRepo.findByCaffeinatedTrue();
	}

	@Override
	public List<Beverage> findByKeyword(String keyword) {
		return bevRepo.findByNameContaining(keyword);
	}

	@Override
	public List<Beverage> findByCaffeineBetween(Integer min, Integer max) {
		return bevRepo.findByCaffeineBetween(min, max);
	}

	@Override
	public List<Beverage> findByCreatedAt(String dateStr) {

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return bevRepo.findByCreatedAtBetween(date, date);
	}

	@Override
	public Beverage createBeverage(int id, Beverage bev) {

		Optional<User> userOpt = uRepo.findById(id);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			bev.setUser(user);
			return bevRepo.saveAndFlush(bev);
		}

		return bev;
	}

	@Override
	public boolean deleteBeverage(int userId, int bevId) {
		Optional<User> userOpt = uRepo.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			Optional<Beverage> bev = bevRepo.findById(bevId);
			if (bev.isPresent()) {
				bevRepo.deleteById(bevId);
				return true;
			}
		}

		return false;
	}

}
