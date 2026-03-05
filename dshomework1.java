import java.util.Arrays;

public class dshomework1 {
    static final int infinity = Integer.MAX_VALUE; // Represents "infinity"
    static final int NUM_CITIES = 8; //  8 cities 
   // all of the cities in order put into a string called cites 
    static String[] cities = {"Boston", "New York", "Chicago", "Miami", "New Orleans", "Denver", "San Francisco", "Los Angeles"};
    
    //making the 2D graph with the distances with every city 
    static int[][] distances = {
        {0, 250, 1450, infinity, infinity, infinity, infinity, infinity}, // Boston
        {250, 0, 1000, 920, infinity, infinity, infinity, infinity}, // New York
        {1450, 1000, 0, infinity, 910, 1200, infinity, infinity}, // Chicago
        {infinity, 920, infinity, 0, 600, infinity, infinity, infinity}, // Miami
        {infinity, infinity, 910, 600, 0, 1100, infinity, 1700}, // New Orleans
        {infinity, infinity, 1200, infinity, 1100, 0, 800, infinity}, // Denver
        {infinity, infinity, infinity, infinity, infinity, 800, 0, 300}, // San Francisco
        {infinity, infinity, infinity, infinity, 1700, infinity, 300, 0}  // Los Angeles
    };
    
    //making the start 0 at bosten stated in the problem and start of main method
    //also using the dijkstra method for the start 
    public static void main(String[] args) {
        int start = 0; 
        dijkstra(start);
    }
   //calling dijkstra method and initializing shortestdistance and visted as a true or false boolen and another int 
    static void dijkstra(int start) {
        int[] shortestDist = new int[NUM_CITIES];
        boolean[] visited = new boolean[NUM_CITIES];
        int[] previous = new int[NUM_CITIES];

        Arrays.fill(shortestDist, infinity);
        Arrays.fill(previous, -1);
        shortestDist[start] = 0;
      
      //starting a loop statment making min the shortest distance getting ton the next city 
        for (int i = 0; i < NUM_CITIES; i++) {
            int minCity = -1;
            for (int j = 0; j < NUM_CITIES; j++) {
                if (!visited[j] && (minCity == -1 || shortestDist[j] < shortestDist[minCity])) {
                    minCity = j;
                }
            }

            visited[minCity] = true;
            
            for (int j = 0; j < NUM_CITIES; j++) {
                if (distances[minCity][j] != infinity) {
                    int newDist = shortestDist[minCity] + distances[minCity][j];
                    if (newDist < shortestDist[j]) {
                        shortestDist[j] = newDist;
                        previous[j] = minCity;
                    }
                }
            }
        }

        printResults(shortestDist, previous, start);
    }
   //final print from the loop and 2D grpah to print the output 
    static void printResults(int[] shortestDist, int[] previous, int start) {
        System.out.println("Shortest paths from " + cities[start] + ":");
        for (int i = 0; i < NUM_CITIES; i++) {
            System.out.print("To " + cities[i] + " -> Distance: ");
            if (shortestDist[i] == infinity) {
                System.out.print("unreachable, Path: ");
            } else {
                System.out.print(shortestDist[i] + " miles, Path: ");
            }
            printPath(previous, i);
            System.out.println();
        }
    }
   //saying the paths and the start of bosten and how we are able to get to that selected city 
    static void printPath(int[] previous, int city) {
        if (previous[city] == -1) {
            System.out.print(cities[city]);
            return;
        }
        printPath(previous, previous[city]);
        System.out.print(" → " + cities[city]);
    }
}
