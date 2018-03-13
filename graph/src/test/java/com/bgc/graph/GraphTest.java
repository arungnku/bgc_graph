/**
 * 
 */
package com.bgc.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bgc.graph.Graph;


/**
 * @author ArunKumar
 *
 */
class GraphTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEdges() {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 4);
		g.addEdge(3, 3);

		assertEquals(true, g.isConnected(0, 1), "Not connected");
		assertEquals(true, g.isConnected(0, 3), "Not connected");
		assertEquals(false, g.isConnected(0, 4), "Not connected");
		assertEquals(true, g.isConnected(1, 3), "Not connected");
		assertEquals(true, g.isConnected(1, 2), "Not connected");
		assertEquals(false, g.isConnected(1, 4), "Not connected");
		assertEquals(true, g.isConnected(2, 3), "Not connected");
		assertEquals(false, g.isConnected(2, 4), "Not connected");
		
	}

}
