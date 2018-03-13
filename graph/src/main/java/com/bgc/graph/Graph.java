package com.bgc.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	// This gives the number of nodes or cities.
	private int noOfNodes; 
	
	// List of Edges or lines between nodes
	private LinkedList<Integer> edges[]; 

	public Graph(int noOfNodes) {
		this.noOfNodes = noOfNodes;
		edges = new LinkedList[noOfNodes];
		for (int i = 0; i < noOfNodes; ++i) {
			edges[i] = new LinkedList<Integer>();
		}
	}

	// Function to add an edge/line into the graph
	public void addEdge(int node1, int node2) {
		edges[node1].add(node2); // Adding edge from node1 to node2
		edges[node2].add(node1); // Adding edge from node2 to node1 as there is no direction between 2 nodes.
	}

	public boolean isConnected(int sourceKey, int destinationKey) {

		// Mark all nodes as not visited in the graph.
		boolean visited[] = new boolean[noOfNodes];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[sourceKey] = true;
		queue.add(sourceKey);

		
		Iterator<Integer> iterator;  
		while (queue.size() != 0) {
			
			sourceKey = queue.poll();

			int node;
			iterator = edges[sourceKey].listIterator(); // this gives all the nodes linked to sourceKey

			while (iterator.hasNext()) {
				node = iterator.next();

				// If this linked node is the destination node,
				// then return true
				if (node == destinationKey) {
					return true;
				}

				// This will add nodes linked to sourceKey one after another and looks up
				// each edge/line linked to another node
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
				}
			}
		}

		// In case there is no match or connection 
		// found between input cities, false will be returned.
		return false;
	}

}