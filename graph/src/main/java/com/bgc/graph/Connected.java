package com.bgc.graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bgc.graph.Graph;

public class Connected {
	
	private Map<String, Integer> citiesMap;

	private String[] keys;
	private Graph graph;

	public Connected(List<String> strList) {
		citiesMap = new HashMap<String, Integer>();
		
		// Cities => integer mappings 
		for(String connection: strList) {
			String nodes[] = connection.split(",");
			for(int i=0; i< nodes.length; i++) {
				if(!citiesMap.containsKey(nodes[i].trim())) {
					citiesMap.put(nodes[i].trim(), citiesMap.size());
				}
			}
		}
		
		// Keys indexes to be mapped to integers from above step
		keys = new String[citiesMap.size()];
        for (String name : citiesMap.keySet()) {
            keys[citiesMap.get(name)] = name;
        }
        
        // creating the lines/edges between 2 nodes
        graph = new Graph(citiesMap.size());
        for(String connection: strList) {
			String nodes[] = connection.split(",");
			graph.addEdge(citiesMap.get(nodes[0].trim()), citiesMap.get(nodes[1].trim()));
		}
        
	}
	
	public boolean isConnected(String city1, String city2) {
		if(this.getCitiesMap().get(city1)==null) {
			System.out.println("City: "+city1+" is not a valid node in the graph" );
			return false;
		}
		if(this.getCitiesMap().get(city2)==null) {
			System.out.println("City: "+city2+" is not a valid node in the graph" );
			return false;
		}
		return this.getGraph().isConnected(this.getCitiesMap().get(city1), this.getCitiesMap().get(city2));
	}
	
	public static void main(String args[]) {

		// Validate the input - BEGIN
		if(args.length != 3) {
			System.out.println("Please provide the input file, city1 and city2. For E.g: cities.txt Boston Hartford");
			return;
		}
		
		List<String> strList;
		try {
			strList = Files.readAllLines(Paths.get(args[0]));
		} catch (IOException e) {
			System.err.println("Invalid file:" + args[0]);
			//System.err.println(e.getMessage());
			return;
		}
		if(strList==null || strList.size()==0) {
			System.out.println("Please check the input file and add connected cities in this format: Boston, Hartford");
			return;
		}
		for(String citiesPair: strList) {
			String cities[] = citiesPair.split(",");
			if(cities[0]==null || cities[0].length() == 0 ||cities[0].trim().length() == 0|| cities[1]==null || cities[1].length() == 0|| cities[1].trim().length() == 0) {
				System.out.println("This pair of cities is not valid:  " + citiesPair + " .Please enter it in this format city1,city2");
				return;
			}
		}
		// Validate the input - END
				
		Connected connected = new Connected(strList);
		
		System.out.println(connected.isConnected(args[1], args[2])?"Yes":"No");
		
	}
	
	public Map<String, Integer> getCitiesMap() {
		return citiesMap;
	}

	public void setCitiesMap(Map<String, Integer> citiesMap) {
		this.citiesMap = citiesMap;
	}
	
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}



}

