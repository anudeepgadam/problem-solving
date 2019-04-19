package graphs;

import java.util.LinkedList;

public class GraphDFS
{
    LinkedList<Integer> adjacentListArray[];
    boolean visited[];
    public GraphDFS(int numberOfVertices)
    {
        adjacentListArray = new LinkedList[numberOfVertices];
        visited = new boolean[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++)
        {
            adjacentListArray[i] = new LinkedList<Integer>();
        }
    }
    
    private void addEdge(int source, int destination)
    {
        adjacentListArray[source].add(destination);
    }
    
    private void DFS(int vertex)
    {
        System.out.println(vertex);
        visited[vertex] = true;
        LinkedList<Integer> list = adjacentListArray[vertex];
        for(Integer v : list)
        {
            if(visited[v] != true)
            {
                DFS(v);
            }
        }
    }
    
    public static void main(String[] args)
    {
        GraphDFS g = new GraphDFS(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.DFS(2);
    }
}