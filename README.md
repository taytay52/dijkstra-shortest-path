A Java implementation of Dijkstra's shortest path algorithm applied to 
a real-world graph of 8 major US cities. Finds the shortest driving 
distance from Boston to every other city in the network.

## Features
- Implements Dijkstra's algorithm from scratch without any libraries
- Uses a 2D adjacency matrix to represent city distances
- Handles unreachable cities gracefully
- Prints the full shortest path and total distance to every city
- Uses recursive path reconstruction to display routes

## Cities Included
Boston, New York, Chicago, Miami, New Orleans, Denver, San Francisco, 
Los Angeles

## How It Works
1. Initializes all distances as infinity except the start city (Boston = 0)
2. Visits the unvisited city with the smallest known distance
3. Updates neighbor distances if a shorter path is found
4. Tracks the previous city for each node to reconstruct the full path
5. Prints shortest distance and full route to every city

## Technologies Used
- Java
- 2D Arrays (Adjacency Matrix)
- Dijkstra's Algorithm
- Recursive Path Reconstruction

## How to Run
1. Clone the repository
2. Compile: `javac DijkstraShortestPath.java`
3. Run: `java DijkstraShortestPath`

## Sample Output
```
Shortest paths from Boston:
To New York -> Distance: 250 miles, Path: Boston → New York
To Chicago -> Distance: 1250 miles, Path: Boston → New York → Chicago
To Miami -> Distance: 1170 miles, Path: Boston → New York → Miami
```

## What I Learned
- How Dijkstra's greedy algorithm works step by step
- Representing weighted graphs using adjacency matrices
- Recursive algorithms for path reconstruction
- Handling edge cases like unreachable nodes
