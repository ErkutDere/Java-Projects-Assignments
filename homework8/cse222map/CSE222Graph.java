package cse222map;

import java.util.List;
import java.util.ArrayList;

public class CSE222Graph {
    private int[][] map;
    private int xLength;
    private int yLength;
    private List<List<Integer>> adjacencyList;

    public CSE222Graph(CSE222Map map) {
        this.map = map.getMap();
        this.xLength = map.getMapXLength();
        this.yLength = map.getMapYLength();
        this.adjacencyList = new ArrayList<List<Integer>>();
        buildGraph();
    }

    // buildGraph method
    public void buildGraph() {
        // initialize adjacencyList
        for (int i = 0; i < this.xLength * this.yLength; i++) {
            this.adjacencyList.add(new ArrayList<Integer>());
        }
        // add edges
        for (int i = 0; i < this.xLength; i++) {
            for (int j = 0; j < this.yLength; j++) {
                if (this.map[i][j] == 0) {
                    // check if the node is valid
                    if (isValid(i - 1, j)) {
                        if (this.map[i - 1][j] == 0) {
                            this.adjacencyList.get(i * this.yLength + j).add((i - 1) * this.yLength + j);
                        }
                    }
                    if (isValid(i + 1, j)) {
                        if (this.map[i + 1][j] == 0) {
                            this.adjacencyList.get(i * this.yLength + j).add((i + 1) * this.yLength + j);
                        }
                    }
                    if (isValid(i, j - 1)) {
                        if (this.map[i][j - 1] == 0) {
                            this.adjacencyList.get(i * this.yLength + j).add(i * this.yLength + j - 1);
                        }
                    }
                    if (isValid(i, j + 1)) {
                        if (this.map[i][j + 1] == 0) {
                            this.adjacencyList.get(i * this.yLength + j).add(i * this.yLength + j + 1);
                        }
                    }
                }
            }
        }
    }

    private boolean isValid(int x, int y) {
        return (x >= 0) && (x < this.xLength) && (y >= 0) && (y < this.yLength);
    }

    public List<List<Integer>> getAdjacencyList() {
        return this.adjacencyList;
    }

    // getGraph method
    public int[][] getGraph() {
        return this.map;
    }

    public int getMapYLength() {
        return this.yLength;
    }

    public int getMapXLength() {
        return this.xLength;
    }

}
