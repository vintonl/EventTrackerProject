package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		}
		if (bevs.size() == 0) {
			resp.setStatus(204);
		}

		return bevs;
	}

	@GetMapping("beverages/{id}")
	public Beverage showBeverageById(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
		Beverage bevs = bevSvc.findById(id);

		if (bevs == null) {
			resp.setStatus(404);
		} else {
			resp.setStatus(200);
		}

		return bevs;
	}

	@GetMapping("beverages/caffeinated")
	public List<Beverage> showCaffeinatedBeverages(HttpServletRequest req, HttpServletResponse resp) {
		List<Beverage> bevs = bevSvc.findByCaffeinated();

		if (bevs == null) {
			resp.setStatus(404);
		}
		if (bevs.size() == 0) {
			resp.setStatus(204);
		}

		return bevs;
	}

	@GetMapping("beverages/name/{keyword}")
	public List<Beverage> searchByKeyword(@PathVariable String keyword, HttpServletRequest req,
			HttpServletResponse resp) {
		List<Beverage> bevs = bevSvc.findByKeyword(keyword);

		if (bevs.size() == 0) {
			resp.setStatus(404);
		}
		if (bevs.size() == 0) {
			resp.setStatus(204);
		}

		return bevs;
	}

	@GetMapping("beverages/{min}/{max}")
	public List<Beverage> searchByMinMaxCaffeine(@PathVariable Integer min, @PathVariable Integer max,
			HttpServletRequest req, HttpServletResponse resp) {
		List<Beverage> bevs = bevSvc.findByCaffeineBetween(min, max);

		if (bevs == null) {
			resp.setStatus(404);
		}
		if (bevs.size() == 0) {
			resp.setStatus(204);
		}

		return bevs;
	}

	@GetMapping("beverages/date/{date}")
	public List<Beverage> searchByDate(@PathVariable String date, HttpServletRequest req, HttpServletResponse resp) {
		List<Beverage> bevs = bevSvc.findByCreatedAt(date);

		if (bevs == null) {
			resp.setStatus(404);
		}

		if (bevs.size() == 0) {
			resp.setStatus(204);
		}

		return bevs;
	}

	@PostMapping("beverages")
	public Beverage create(@RequestBody Beverage bev, HttpServletRequest req, HttpServletResponse resp) {
		try {
			bev = bevSvc.createBeverage(bev);
			resp.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(bev.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		return bev;
	}

	@PutMapping("beverages/{id}")
	public Beverage replaceExistingBeverage(@RequestBody Beverage bev, @PathVariable int id, HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			bev = bevSvc.updateBeverage(id, bev);
			if (bev == null) {
				resp.setStatus(404);
				return null;
			}
			resp.setStatus(202);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(bev.getId());
			resp.addHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
			return null;
		}
		return bev;
	}

	@DeleteMapping("beverages/{id}")
	public void deleteBeverage(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
		try {
			boolean deleted = bevSvc.deleteBeverage(id);
			if (deleted) {
				resp.setStatus(204);
			} else {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(400);
		}
	}

}
