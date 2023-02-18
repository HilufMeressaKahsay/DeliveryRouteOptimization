Algorithm Used : Nearest neighbour algorithm(Heuristics algorithm)

In contrast to precise and optimal algorithms, heuristics algorithms rely on experience, intuition, and trial and error to guide their search for solutions. They are often used in complex problems where an exact solution is not possible, too time-consuming, or too expensive to compute. Heuristics algorithms can be used in a wide range of applications, including artificial intelligence, optimization problems, decision-making, game-playing, and many others. Some examples of heuristics algorithms include greedy algorithms, simulated annealing, genetic algorithms, and particle swarm optimization.

It's important to note that heuristics algorithms are not always guaranteed to find the best solution, but they can be effective in finding good solutions that are practical and useful.

The problem implementation documentaion is presented as below 

First, Create a class for the traveling Delivery Route Optimization problem, with instance variables to store the number of buildings ,to store for unvisited buildings and the adjacency matrix representing the distances between buildings.

Create a method to implement the nearest neighbor algorithm, which takes  starting building as input and returns an array of integers representing the order in which the cities should be visited.

Here's a basic algorithm to implement the given problem in Java:

First, you need to represent the set of Buildings and their distances as a matrix or a graph. You can use a two-dimensional array to represent the matrix.

Initialize a list of unvisited Buildings and set the current city to the starting city.

Next, you need to generate all possible routes that the traveler can take.

For each route, you need to calculate the total distance traveled by the traveler. You can use the matrix to calculate the distance between two Buildings.

Finally, you need to select the route with the shortest distance as the optimal solution.