package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BeverageTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Beverage bev;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		bev = em.find(Beverage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		bev = null;
	}

	@Test
	@DisplayName("Test the primary fields")
	void test() {
		assertEquals("water", bev.getName());
		assertEquals("H2O from the tap", bev.getDescription());
		assertEquals("water", bev.getIngredients());
		assertFalse(bev.isCaffeinated());
		assertFalse(bev.isContainsAlcohol());
		assertEquals(0, bev.getCaffeine());
		assertEquals(0, bev.getCalories());
		assertEquals(8, bev.getVolume());
		assertTrue(bev.isActive());
		assertTrue(bev.getCreatedAt().toString().contains("2019"));
		assertTrue(bev.getUpdatedAt().toString().contains("2019"));
	}
	
	@Test
	@DisplayName("Test relationship with beverage tracker")
	void test1() {
		assertEquals("Bobby", bev.getUser().getFirstName());
	}

}
