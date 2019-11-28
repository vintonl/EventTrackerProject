package com.skilldistillery.jpaeventtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

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
		assertEquals(0, bev.getCalories());
		assertEquals(8, bev.getVolume());
		assertTrue(bev.isActive());
	}

}
