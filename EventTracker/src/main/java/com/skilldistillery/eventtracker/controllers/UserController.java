package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Beverage;
import com.skilldistillery.eventtracker.entities.User;
import com.skilldistillery.eventtracker.services.BeverageService;
import com.skilldistillery.eventtracker.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	private UserService userSvc;
	@Autowired
	private BeverageService bevSvc;

	@GetMapping("users")
	public List<User> findAll(HttpServletRequest req, HttpServletResponse resp) {
		List<User> users = userSvc.findAll();

		if (users == null) {
			resp.setStatus(404);
		}
		if (users.size() == 0) {
			resp.setStatus(204);
		}

		return users;
	}

	@PostMapping("users")
	public User create(@RequestBody User newUser, HttpServletRequest req, HttpServletResponse resp) {
		try {
			newUser = userSvc.createUser(newUser);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(newUser.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		return newUser;
	}

	@PostMapping("users/{id}/beverages")
	public Beverage createBeverage(@PathVariable int id, @RequestBody Beverage bev, HttpServletRequest req,
			HttpServletResponse resp) {
		Beverage bevCreated = null;
		try {
			bevCreated = bevSvc.createBeverage(id, bev);

			if (bevCreated == null) {
				resp.setStatus(404);
			}

			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(bevCreated.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}

		return bevCreated;
	}

	@DeleteMapping("users/{userId}/beverages/{bevId}")
	public void deleteComment(@PathVariable int userId, @PathVariable int bevId, HttpServletRequest req,
			HttpServletResponse resp) {

		try {
			boolean bevDeleted = bevSvc.deleteBeverage(userId, bevId);

			if (!bevDeleted) {
				resp.setStatus(404);
			} else {
				resp.setStatus(204);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}

	}
}
