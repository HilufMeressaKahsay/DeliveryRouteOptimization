//importing all java packages
import java.util.*;

//Creating main class
public class DeliveryRouteOptimization {

      //Creating of variables to store different value 
      private int[][] graph;
      private boolean[] visited;
      private List<Integer> tour;
      private int tourLength;

      //Creating constructor to initilize the private variables
      public DeliveryRouteOptimization(int[][] graph) {

            //assign the value of the graph to static variable of graph
            this.graph = graph;

            //assign the the length of graph to the boolean variable and mark as unvisited 
            this.visited = new boolean[graph.length + 1];
            
            //create ArrayList to the store the tours 
            this.tour = new ArrayList<Integer>();
            this.tourLength = 0;
      }

      public int solve(int startBuilding) {

            //Checking if the start building is not negative and more than the buildings length
            if (startBuilding < 0 || startBuilding > graph.length - 1) {
                  return 0;
            }

            //adding the first building to tour
            tour.add(startBuilding);

            //make the the first building as visited
            visited[startBuilding] = true;
            int currentNode = startBuilding;
            while (tour.size() < graph.length) {
                  int nextNode = getNearestNeighbor(currentNode);
                  tour.add(nextNode);
                  visited[nextNode] = true;
                  tourLength += graph[currentNode][nextNode];
                  currentNode = nextNode;
            }

            //finally add the start building to the last building, it is used to the traveler to make cyclic walking.
            tour.add(startBuilding);

            //this return statment returns the total cost that the traveler take to visit all buildings
            return tourLength += graph[currentNode][startBuilding];
      }
      
      //this is functions is used to get nearest building to the current building
      private int getNearestNeighbor(int currentNode) {

            // This means that no number of type Integer that is greater than 2147483647 can exist in Java.
            int minDistance = Integer.MAX_VALUE;

            //let at the starting there is no nearest building to the first building
            int nearestNeighbor = -1;
            
            for (int i = 0; i < graph.length; i++) {
                  if (!visited[i] && graph[currentNode][i] < minDistance) {
                        minDistance = graph[currentNode][i];
                        nearestNeighbor = i;
                  }
            }
            return nearestNeighbor;
      }

      //returns the path that the traveler takes
      public List<Integer> getTour() {
            return tour;
      }

      //returns the total const that the traveler take to finish the route
      public int getTourLength() {
            return tourLength;
      }

      public static void main(String[] args) {

            int[][] graph = {
                        { 0, 10, 15, 20 },
                        { 10, 0, 35, 25 },
                        { 15, 35, 0, 30 },
                        { 20, 25, 30, 0 },
            };

            //Creating instance of the main class to access the methods
            DeliveryRouteOptimization deliveryRouteOptimization = new DeliveryRouteOptimization(graph);

            //assigning the corner case test please uncomment the below code and check the test cases for negative and out of buildings
            deliveryRouteOptimization.solve(0);//works fine
            // deliveryRouteOptimization.solve(-1);//returns null array because it does not work with negative node
            // deliveryRouteOptimization.solve(4);//returns null array because it does not work out of the buildings


            System.out.println("The path of the shortest building is : "+deliveryRouteOptimization.getTour());
            System.out.println("The Cost of the building is : "+deliveryRouteOptimization.getTourLength());
      }
}
