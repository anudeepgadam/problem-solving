package graphs;

import java.util.ArrayList;
import java.util.List;

public class PathsForTwoVertex
{
    static List<String> allPaths = new ArrayList<String>();
    static int destinationVertex;
    private void DFS(Graph g, int currentVertex, String path)
    {
        if(path.contains(String.valueOf(destinationVertex)))
        {
            allPaths.add(path);
            return;
        }
        
        for(int i : g.adjacentVertexArray[currentVertex])
        {
            if(g.visited[i] != true)
            {
                g.visited[i] = true;
                DFS(g, i, path+i+"->");
                g.visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args)
    {
        Graph g = new Graph(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 0); 
        g.addEdge(2, 1); 
        g.addEdge(1, 3); 
        
        destinationVertex = 3;
        new PathsForTwoVertex().DFS(g, 2, "2 ->");
        
        System.out.println(allPaths);
    }
}
