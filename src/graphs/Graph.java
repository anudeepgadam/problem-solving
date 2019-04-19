package graphs;

import java.util.LinkedList;

public class Graph
{
    LinkedList<Integer> adjacentVertexArray[];
    boolean visited[];
    int noOfadjacentNodes[];
    
    public Graph(int v)
    {
        adjacentVertexArray = new LinkedList[v];
        visited = new boolean[v];
        noOfadjacentNodes = new int[v];
        
        for(int i = 0; i < v; i++)
        {
            adjacentVertexArray[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int source, int destination)
    {
        adjacentVertexArray[source].add(destination);
    }
    
    public void addUndirectedEdge(int source, int destination)
    {
        adjacentVertexArray[source].add(destination);
        adjacentVertexArray[destination].add(source);
    }
}
