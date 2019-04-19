package graphs;

import java.util.LinkedList;

public class GraphMotherVertex
{
    static int lastVertex;
    boolean visited[];
    LinkedList<Integer> adjacentVertexListArray[];

    public GraphMotherVertex(int v)
    {
        adjacentVertexListArray = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++)
        {
            adjacentVertexListArray[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int source, int destination)
    {
        adjacentVertexListArray[source].add(destination);
    }

    private void DFS(int v)
    {
        visited[v] = true;

        LinkedList<Integer> vertices = adjacentVertexListArray[v];
        for (Integer i : vertices)
        {
            if (visited[i] != true)
            {
                DFS(i);
            }
        }
    }

    private void findMotherVertex(int v)
    {
        lastVertex = 0;

        for (int i = 0; i < v; i++)
        {
            if (visited[i] != true)
            {
                DFS(i);
                lastVertex = i;
            }
        }
    }

    public static void main(String[] args)
    {
        GraphMotherVertex g = new GraphMotherVertex(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        g.findMotherVertex(7);

        System.out.println(lastVertex);
    }
}
