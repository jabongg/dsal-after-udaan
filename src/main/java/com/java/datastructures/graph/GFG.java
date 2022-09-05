package com.java.datastructures.graph;

import java.util.ArrayList;

/**
 *
 * un-directed graph
 * 1-----2
 * |     | \
 * |     |  5
 * |     | /
 * 3-----4
 */
public class GFG {
    public static void main(String[] args) {
        int n = 3 , m = 3;

        // Adjecency Matrix is good for dense graphs, for sparse graphs, we use adjecency list.

        // Adjecency Matrix
        int adj[][] = new int[n + 1] [ n + 1]; // n2 space.
        //edge 1--2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //edge 2--3
        adj[3][2] = 1;
        adj[2][3] = 1;

        //edge 1--3
        adj[1][3] = 1;
        adj[3][1] = 1;

        // similarly other edged adj[u][v] = 1; adj[v][u] = 1;


        // Adjecency List
        ArrayList<ArrayList<Integer>> adjecencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjecencyList.add(new ArrayList<>()); // creating buckets.
        }

        // edge 1--2
        adjecencyList.get(1).add(2);
        adjecencyList.get(2).add(1);

        // edge 2--3
        adjecencyList.get(2).add(3);
        adjecencyList.get(3).add(2);

        // edge 1--2
        adjecencyList.get(1).add(3);
        adjecencyList.get(3).add(1);


        // print all the edges
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < adjecencyList.get(i).size(); j++) {
                System.out.println(adjecencyList.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }


}
