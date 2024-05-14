import java.util.LinkedList;

public class Graph {
    private Edge[] graph; // adjacency list for this graph


    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }


    /**
     * Run recursive DFS from the given vertex, and if the target vertex is reachable,
     * add vertices on the path from the vertex to the target vertex to the given linked list called "path"
     * @param vertex starting vertex (will change with each recursive call)
     * @param target target vertex we want to reach
     * @param visited for each vertex id stores a boolean flag: true if the vertex has been visited, false otherwise
     * @param path linked list that contains vertices on the path from the vertex to the target vertex
     * @return true if found a path to target, false otherwise
     */
    public boolean dfs(int vertex, int target, boolean[] visited, LinkedList<Integer> path) {
        // FILL IN CODE: need  to add a base case, and  to mark vertex as visited
        // Currently, code has bug(s) and missing code
        if(vertex == target){
            return true;
        }
        Edge curr = graph[vertex];
        while(curr != null) {
           // FILL IN CODE to make it run recursive DFS to reach  target,
            // and add vertices on the path to target to the given LinkedList
            if(!visited[curr.neighbor]){
                visited[curr.neighbor] = true;
                path.add(curr.neighbor);
                return dfs(curr.neighbor, target, visited, path);
            }
            curr = curr.next;
        }
        return false;
    }


    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        boolean[] visited = new boolean[8];
        LinkedList<Integer> path1 = new LinkedList<>();
        System.out.println(g.dfs(0, 7, visited, path1)); // compute vertices on the path from 0 to 7 using dfs
        path1.addFirst(0);
        System.out.println(path1); // adding the start vertex (0) manually
        // [0, 5, 6 ,7]   - this is the correct path from 0 to 7

        visited = new boolean[8];
        LinkedList<Integer> path2 = new LinkedList<>();
        System.out.println(g.dfs(2, 4, visited, path2)); // compute vertices on the path from 2 to 4 using dfs
        path2.addFirst(2); // adding the start vertex (2) manually
        System.out.println(path2); // [2, 6, 7, 5, 4]



    }
}

