package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Beverage;
import com.skilldistillery.eventtracker.services.BeverageService;

@RestController
@RequestMapping("api")
public class BeverageController {

	@Autowired
	private BeverageService bevSvc;

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("beverages")
	public List<Beverage> showAllBeverages(HttpServletRequest req, HttpServletResponse resp) {
		List<Beverage> bevs = bevSvc.findAll();

		if (bevs == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}

		return bevs;
	}

}
