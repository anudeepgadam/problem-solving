package graphs;

import java.util.LinkedList;

public class GraphImplementationLinkedList
{
    static class Graph
    {
        private int vertex;
        private LinkedList<Integer> adjacentVertices[];
        
        public Graph(int vertex)
        {
            this.vertex = vertex;
            adjacentVertices = new LinkedList[vertex];
            
            for(int i = 0; i < vertex; i++)
            {
                adjacentVertices[i] = new LinkedList<Integer>();
            }
        }
    }
    
    private static void addEdge(Graph graph, int currentVertex, int adjacentVertex)
    {
        graph.adjacentVertices[currentVertex].add(adjacentVertex);
        graph.adjacentVertices[adjacentVertex].add(currentVertex);
    }
    
    private static void printGraph(Graph graph)
    {
        for(int i = 0; i < graph.adjacentVertices.length; i++)
        {
            LinkedList<Integer> adjacentVertex = graph.adjacentVertices[i];
            System.out.println("Adjacent nodes of vertex "+ i);
            for(Integer vertex : adjacentVertex)
            {
                System.out.print(vertex +",");
            }
            System.out.println("\n");
        }
    }
    
    public static void main(String[] args)
    {
        int V = 5; 
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
        
        printGraph(graph);
    }
    
}
