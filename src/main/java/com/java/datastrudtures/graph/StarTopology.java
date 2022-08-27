package com.java.datastrudtures.graph;

import java.util.ArrayList;

public class StarTopology {
    // A utility function to add an edge in an
// undirected graph.
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
// representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj, int V)
    {
        for (int v = 0; v < V; ++v)
        {
            System.out.print("\n Adjacency list of vertex " +
                    v + "\n head ");
            for (int x : adj.get(v))
            {
                System.out.print( "-> " + x);
            }
            System.out.println();
        }
    }

    /* Function to return true if the graph represented
        by the adjacency list represents a Star topology
        else return false */
    static boolean checkStarTopologyUtil(ArrayList<ArrayList<Integer>> adj, int V, int E)
    {
        // Number of edges should be equal
        // to (Number of vertices - 1)
        if (E != (V - 1))
        {
            return false;
        }

        // a single node is termed as a star topology
        // having only a central node
        if (V == 1)
        {
            return true;
        }
        int[] vertexDegree = new int[V + 1];

        // calculate the degree of each vertex
        for (int i = 1; i <= V; i++)
        {
            for (int v : adj.get(i))
            {
                vertexDegree[v]++;
            }
        }

        // countCentralNodes stores the count of nodes
        // with degree V - 1, which should be equal to 1
        // in case of star topology
        int countCentralNodes = 0, centralNode = 0;
        for (int i = 1; i <= V; i++)
        {
            if (vertexDegree[i] == (V - 1))
            {
                countCentralNodes++;

                // Store the index of the central node
                centralNode = i;
            }
        }

        // there should be only one central node
        // in the star topology
        if (countCentralNodes != 1)
            return false;
        for (int i = 1; i <= V; i++)
        {

            // except for the central node
            // check if all other nodes have
            // degree 1, if not return false
            if (i == centralNode)
                continue;
            if (vertexDegree[i] != 1)
            {
                return false;
            }
        }

        // if all three necessary
        // conditions as discussed,
        // satisfy return true
        return true;
    }

    // Function to check if the graph
// represents a Star topology
    static void checkStarTopology(ArrayList<ArrayList<Integer>> adj, int V, int E)
    {
        boolean isStar = checkStarTopologyUtil(adj, V, E);
        if (isStar)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }

    // Driver code
    public static void main (String[] args)
    {

        // Graph 1
        int V = 5, E = 4;
        ArrayList<ArrayList<Integer>> adj1 =
                new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V + 1; i++)
        {
            adj1.add(new ArrayList<Integer>());
        }
        // creating an undirected graph
        addEdge(adj1, 1, 2);
        addEdge(adj1, 1, 3);
        addEdge(adj1, 1, 4);
        addEdge(adj1, 1, 5);

        checkStarTopology(adj1, V, E);

        // Graph 2
        V = 5;
        E = 4;
        ArrayList<ArrayList<Integer>> adj2 =
                new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < (V + 1); i++)
        {
            adj2.add(new ArrayList<Integer>());
        }
        addEdge(adj2, 1, 2);
        addEdge(adj2, 1, 3);
        addEdge(adj2, 3, 4);
        addEdge(adj2, 4, 5);
        checkStarTopology(adj2, V, E);


        printGraph(adj1, 5);
    }
}

// This code is contributed by rag2127
