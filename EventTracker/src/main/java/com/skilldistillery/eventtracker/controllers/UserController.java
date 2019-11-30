package com.skilldistillery.eventtracker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

//	@Autowired
//	private BeverageService bevSvc;

//	@GetMapping("trackers/search/{keyword}")
//	public List<Beverage> findBeveragesByNameOrTitle(@PathVariable String keyword, HttpServletRequest req,
//			HttpServletResponse resp) {
//
//		List<Beverage> bevs = bevSvc.findBeveragesByNameOrDescription(keyword);
//
//		if (bevs == null) {
//			resp.setStatus(404);
//		}
//
//		return bevs;
//	}

//	@GetMapping("trackers/search/price/{low}/{high}")
//	public List<Beverage> findBeveragesWithinPriceRange(@PathVariable double low, @PathVariable double high, HttpServletRequest req, HttpServletResponse resp) {
//		
//		List<Beverage> bevs = bevSvc.findBeveragesWithinPriceRange(low, high);
//		
//		if (bevs == null) {
//			resp.setStatus(404);
//		}
//		
//		return bevs;
//	}
}
