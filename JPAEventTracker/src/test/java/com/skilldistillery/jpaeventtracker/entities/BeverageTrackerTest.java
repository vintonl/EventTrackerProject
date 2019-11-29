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

class BeverageTrackerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private BeverageTracker bevT;

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
		bevT = em.find(BeverageTracker.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		bevT = null;
	}

	@Test
	@DisplayName("Test the primary fields")
	void test() {
		assertEquals("Test", bevT.getFirstName());
		assertEquals("Test", bevT.getLastName());
		assertTrue(bevT.getDateConsumed().toString().contains("2019-11-28"));
	}

}
