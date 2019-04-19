package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphBFS
{

    int vertices;
    private LinkedList<Integer> adajacentVertices[];
    Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();

    public GraphBFS(int v)
    {
        this.vertices = v;
        adajacentVertices = new LinkedList[v];
        for (int i = 0; i < adajacentVertices.length; i++)
        {
            adajacentVertices[i] = new LinkedList<Integer>();
        }
    }

    private void addEdge(int currentVertex, int adjacentVertex)
    {
        adajacentVertices[currentVertex].add(adjacentVertex);
    }

    private void BFS(int vertex)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(vertex);
        visitedMap.put(vertex, true);

        while (!queue.isEmpty())
        {
            int currentVertex = queue.poll();
            LinkedList<Integer> list = adajacentVertices[currentVertex];

            System.out.println(currentVertex);
            for (Integer v : list)
            {
                if (!visitedMap.containsKey(v))
                {
                    visitedMap.put(v, true);
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(0);
    }
}
