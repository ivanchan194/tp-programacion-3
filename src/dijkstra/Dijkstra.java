package dijkstra;

import grafo.*;

public class Dijkstra {
    public static GrafosTDA dijkstra(ImplemEstatica grafo, int inicio) {
        int cantVertices = grafo.vertices().length;
        int[][] matrizAdy = grafo.matrizAdy;
        int[] distancia = new int[cantVertices];
        boolean[] visto = new boolean[cantVertices];

        for(int i = 0; i < cantVertices; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visto[i] = false;
        }

        distancia[inicio-1] = 0;

        for(int i = 0; i < cantVertices; i++) {
            int u = minDistancia(distancia, visto, cantVertices);

            visto[u] = true;

            for(int j = 0; j < cantVertices; j++) {
                int aux = matrizAdy[u][j];
                if(!visto[j] && matrizAdy[u][j] != 0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + matrizAdy[u][j] < distancia[j]) {
                    distancia[j] = distancia[u] + matrizAdy[u][j];
                }
            }
        }

        printSolution(distancia, cantVertices);

        return new GrafoDinamic();
    }

    static int minDistancia(int[] distancia, boolean[] visto, int cantVertices) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < cantVertices; i++) {
            if(!visto[i] && distancia[i] <= min) {
                min = distancia[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printSolution(int[] distancia, int cantVertices) {
        System.out.println("Vertex \t\t Distance from Source");
        for(int i = 0; i < cantVertices; i++) {
            System.out.println((i+1) + " \t\t " + distancia[i]);
        }
    }

    public static void main(String[] args) {
        ImplemEstatica grafo = new ImplemEstatica();
        grafo.inicializarGrafo(10);

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArista(1 , 2 , 3);
        grafo.agregarArista(1 , 3 , 9);
        grafo.agregarArista(1 , 5 , 99);
        grafo.agregarArista(2 , 3 , 5);
        grafo.agregarArista(4 , 1 , 8);
        grafo.agregarArista(1 , 4 , 200);
        grafo.agregarArista(5 , 4 , 24);
        Dijkstra.dijkstra(grafo, 1);
    }

}
