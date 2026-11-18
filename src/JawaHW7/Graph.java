package JawaHW7;

import java.util.*;

public class Graph {
    private int n;
    private HashSet<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int n) {
        this.n = n;
        adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void removeEdge(int u, int v) {
        adj[u].remove(v);
        adj[v].remove(u);
    }

    public boolean hasEdge(int u, int v) {
        return adj[u].contains(v);
    }

    public int degree(int v) {
        return adj[v].size();
    }

    public HashSet<Integer> neighbors(int v) {
        return adj[v];
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Ребро 1-2: " + g.hasEdge(1, 2));
        System.out.println("Ребро 2-1: " + g.hasEdge(2, 1));
        System.out.println("Сусіди 2: " + g.neighbors(2));
        g.removeEdge(1, 2);
        System.out.println("Після видалення 1-2: " + g.hasEdge(1, 2));
        System.out.println("Степінь вершини 2: " + g.degree(2));
    }
}