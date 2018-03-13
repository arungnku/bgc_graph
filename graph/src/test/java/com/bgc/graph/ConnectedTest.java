package com.bgc.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectedTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConnections() {
		List<String> citiesPairList = Arrays.asList("Philadelphia, Pittsburgh", "Boston, New York", "Hartford, New York", "Los Angeles, San Diego", "New York, Croton-Harmon", "St. Petersburg, Tampa", "Croton-Harmon, Pittsburgh");
		
		Connected connected = new Connected(citiesPairList);
		
		assertEquals(true, connected.isConnected("Boston", "New York"));
		assertEquals(false, connected.isConnected("Boston", "Tampa"));
		assertEquals(true, connected.isConnected("Boston", "Pittsburgh"));
		assertEquals(false, connected.isConnected("Boston", "San Diego"));
		assertEquals(true, connected.isConnected("New York", "Boston"));
		assertEquals(false, connected.isConnected("Tampa", "Boston"));
		assertEquals(true, connected.isConnected("Pittsburgh", "Boston"));
		assertEquals(false, connected.isConnected("San Diego", "Boston"));
			
	}

}
