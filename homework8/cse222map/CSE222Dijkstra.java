package cse222map;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class CSE222Dijkstra {
    private CSE222Graph graph;
    private List<List<Integer>> adjacencyList;

    public CSE222Dijkstra(CSE222Graph graph) {
        this.graph = graph;
        this.adjacencyList = graph.getAdjacencyList();
    }

    public List<Integer> findShortestPath(int startNode, int endNode){
        //initialize distance array
        int[] distance = new int[this.adjacencyList.size()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        //initialize visited array
        boolean[] visited = new boolean[this.adjacencyList.size()];
        //initialize parent array
        int[] parent = new int[this.adjacencyList.size()];
        //initialize priority queue
        PriorityQueue<Node> pq = new PriorityQueue<Node>(this.adjacencyList.size(), new Node());
        //add start node to pq
        pq.add(new Node(startNode, 0));
        //set distance of start node to 0
        distance[startNode] = 0;
        //while pq is not empty
        while (!pq.isEmpty()) {
            //remove the min distance node from pq
            int currentNode = pq.remove().node;
            //mark the node as visited
            visited[currentNode] = true;
            //iterate through all adjacent nodes of currentNode
            for (int i = 0; i < this.adjacencyList.get(currentNode).size(); i++) {
                //get the adjacent node
                int adjacentNode = this.adjacencyList.get(currentNode).get(i);
                //check if the adjacent node is not visited
                if (!visited[adjacentNode]) {
                    //check if the distance of currentNode + distance of adjacentNode is less than the distance of adjacentNode
                    int newDistance = distance[currentNode] + 1;
                    if (newDistance < distance[adjacentNode]) {
                        //update the distance of adjacentNode
                        distance[adjacentNode] = newDistance;
                        //update the parent of adjacentNode
                        parent[adjacentNode] = currentNode;
                        //add adjacentNode to pq
                        pq.add(new Node(adjacentNode, distance[adjacentNode]));
                    }
                }
            }
        }
        //return the shortest path
        return getPath(parent, startNode, endNode);
    }
    //Node class
    private class Node implements Comparator<Node> {
        public int node;
        public int distance;

        public Node() {
        }

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.distance < node2.distance) {
                return -1;
            }
            if (node1.distance > node2.distance) {
                return 1;
            }
            return 0;
        }
    }
    //getPath method
    private List<Integer> getPath(int[] parent, int startNode, int endNode){
        List<Integer> path = new ArrayList<Integer>();
        int currentNode = endNode;
        while (currentNode != startNode) {
            path.add(currentNode);
            currentNode = parent[currentNode];
        }
        path.add(startNode);
        return path;
    }
}
