package graph;

import java.util.Random;
import java.util.Scanner;

public class ShortestPath {

//    static final int Vertex = 9;

    Random rand = new Random();
    int Vertex = rand.nextInt(20);
    int minDistance(int distance[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int i = 0; i < Vertex; i++) {
            if (sptSet[i] == false && distance[i] <= min) {
                min = distance[i];
                min_index = i;
            }
        }

        return min_index;
    }

    void printSolution(int dist[], int n) {
        System.out.println("Vertex     Distance from Source");
        for (int i = 0; i < Vertex; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    void dijkstra(int graph[][], int src) {
        int distance[] = new int[Vertex];

        Boolean sptSet[] = new Boolean[Vertex];

        for (int i = 0; i < Vertex; i++) {
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        distance[src] = 0;

        for (int i = 0; i < Vertex - 1; i++) {
            int m = minDistance(distance, sptSet);

            sptSet[m] = true;

            for (int j = 0; j < Vertex; j++) {
                if (!sptSet[j] && graph[m][j] != 0
                        && distance[m] != Integer.MAX_VALUE
                        && distance[m] + graph[m][j] < distance[j]) {
                    distance[j] = distance[m] + graph[m][j];
                }
            }
        }

        printSolution(distance, Vertex);
    }

    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();

        Random rand = new Random();
        int selected = rand.nextInt(20);
        int[][] graph = new int[selected][selected];
        int low = 1;
        int high = 10;
        for (int k = 0; k < graph.length; k++) {

            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    graph[i][j] = rand.nextInt(high-low)+low;
//                    System.out.println(graph[i][j]);
                }
            }
        }
        shortestPath.dijkstra(graph, 0);
    }

}
