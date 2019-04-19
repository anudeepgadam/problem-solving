package graphs;

public class DeleteVertex
{
    private void deleteVertex(int degree, Graph graph, int numberOfVertices)
    {
        for (int i = 0; i < numberOfVertices; i++)
        {
            DFS(graph, i, degree);
        }

        for (int i = 0; i < numberOfVertices; i++)
        {
            if (graph.noOfadjacentNodes[i] >= degree)
            {
                System.out.println("Node " + i + ":");
                for (int j : graph.adjacentVertexArray[i])
                {
                    if (graph.noOfadjacentNodes[j] >= degree)
                    {
                        System.out.print(" " + j + " ");
                    }
                }
            }

            System.out.println("");
        }
    }

    private void DFS(Graph graph, int vertex, int degree)
    {
        if (graph.visited[vertex] != true)
        {
            graph.visited[vertex] = true;
            graph.noOfadjacentNodes[vertex] += graph.adjacentVertexArray[vertex].size();
            if (graph.noOfadjacentNodes[vertex] < degree)
            {
                for (int i : graph.adjacentVertexArray[vertex])
                {
                    graph.noOfadjacentNodes[vertex] += -1;
                    graph.noOfadjacentNodes[i] += -1;
                }
            }

            for (int i : graph.adjacentVertexArray[vertex])
            {
                DFS(graph, i, degree);
            }
        }
    }

    public static void main(String[] args)
    {
        Graph g1 = new Graph(9);
        g1.addUndirectedEdge(0, 1);
        g1.addUndirectedEdge(0, 2);
        g1.addUndirectedEdge(1, 2);
        g1.addUndirectedEdge(1, 5);
        g1.addUndirectedEdge(2, 3);
        g1.addUndirectedEdge(2, 4);
        g1.addUndirectedEdge(2, 5);
        g1.addUndirectedEdge(2, 6);
        g1.addUndirectedEdge(3, 4);
        g1.addUndirectedEdge(3, 6);
        g1.addUndirectedEdge(3, 7);
        g1.addUndirectedEdge(4, 6);
        g1.addUndirectedEdge(4, 7);
        g1.addUndirectedEdge(5, 6);
        g1.addUndirectedEdge(5, 8);
        g1.addUndirectedEdge(6, 7);
        g1.addUndirectedEdge(6, 8);

        new DeleteVertex().deleteVertex(3, g1, 9);
    }
}
