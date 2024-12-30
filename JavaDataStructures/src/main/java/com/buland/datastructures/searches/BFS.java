package com.buland.datastructures.searches;

import java.util.*;
	
	public class BFS {
	    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
	        Queue<Integer> queue = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        
	        queue.add(start);
	        visited.add(start);
	        
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            System.out.print(node + " ");
	            
	            for (int neighbor : graph.get(node)) {
	                if (!visited.contains(neighbor)) {
	                    queue.add(neighbor);
	                    visited.add(neighbor);
	                }
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        graph.put(0, Arrays.asList(1, 2));
	        graph.put(1, Arrays.asList(0, 3, 4));
	        graph.put(2, Arrays.asList(0, 4));
	        graph.put(3, Arrays.asList(1));
	        graph.put(4, Arrays.asList(1, 2));
	        
	        bfs(graph, 0);  // Output: 0 1 2 3 4
	    }
}