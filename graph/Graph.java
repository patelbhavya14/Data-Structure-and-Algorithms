package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v1, int v2) {
        adj[v1].add(v2);
    }

    void BFS(int start) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0) {
            start = queue.poll();
            System.out.print(start+" ");

            Iterator<Integer> i = adj[start].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int start) {
        boolean visited[] = new boolean[V];
        DFSUtils(start, visited);
    }

    void DFSUtils(int start, boolean visited[]) {
        visited[start] = true;
        System.out.print(start+" ");

        Iterator<Integer> i = adj[start].listIterator();

        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n])
                DFSUtils(n, visited);
        }
    }

}
