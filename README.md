# Greedy-Graph
Implements a Greedy Graph Class and a derived class that computes the shortest path tree and minimum spanning tree.

This project implements a Greedy Graph Class and a derived class that computes the shortest path tree and minimum spanning tree. The input were 4 file classes that contains vertices, and the weight of the edge that are connecting two vertices. All these graphs were undirected and were inputted through the command argument. The expected outputs were the order of the graph, size of the graph, and the adjacency list of the graph. The minimum spanning tree and its edges are printed out along with its total cost of edge. The shortest path tree also prints out all the edges that are marked along with its total. The shortest path from index 0 to n-1 is printed with its distance.

The project had us implement a greedy algorithm that traverses through the the graphs vertices and edges. This greedy algorithm utilizes a newCost() method that takes in the indices of two vertices as arguments. This method is overridden from the base in the derived class. This method is crucial for the proper outputs for shortest path tree and minimum spanning tree. Depending on which is tree is displayed, the method’s algorithm must be adjusted accordingly. Priority Queue, TreeMaps, KeySets, and ArrayList and a few of many data structures that are used to keep track of information to ensure efficiency.

The graph.zip file is uploaded into the source file of the project. This graph class contains various class needed to implement the greedy algorithm. These classes extend one another. For example, the Greedy Graph class extends the Graph class, allowing it to inherit the parent class’s properties needed to implement the greedy algorithm. The Greedy Graph class is a tweaked version of the Graph class. By having the derive class extend the Greedy Graph class, properties of the Graph class are also inherited, such that methods to track the vertices and weight of the graph from other classes in the package is possible.

There are four graphs are supposed to be tested. The input of graph10.txt, graph11.txt, graph12.txt, and graph13.txt are inputted through the command individually. The output of each graph displays what the project had required us to do. The minimum spanning tree outputs its edges and total cost, while the shortest path tree displays the indices of the shortest path and the entire cost of that path.

From this project, I have learned how to implement a Greedy Graph class using the greedy algorithm. I have a better understand of what minimum spanning tree and shortest path tree is. In addition, I have also learned other methods to traverse a graph such as depth first search and breadth first search.
