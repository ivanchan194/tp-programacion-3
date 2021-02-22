package Algorithms;

import java.util.Scanner;

public class Dijkstra {
    public static int[] dijkstra(ImplemEstatica grafo, int inicio) {
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
            int j = minDistancia(distancia, visto, cantVertices);

            visto[j] = true;

            for(int k = 0; k < cantVertices; k++) {
                int aux = matrizAdy[j][k];
                if(!visto[k] &&
                        matrizAdy[j][k] != 0 &&
                        distancia[j] != Integer.MAX_VALUE &&
                        distancia[j] + matrizAdy[j][k] < distancia[k]) {
                    distancia[k] = distancia[j] + matrizAdy[j][k];
                }
            }
        }

        return distancia;
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

    public static void imprimirResultado(int[] distancia) {
        System.out.println("Vertice\t\tDistancia desde origen");
        for(int i = 0; i < distancia.length; i++) {
            if(distancia[i] == Integer.MAX_VALUE) {
                System.out.println((i+1) + "\t\t\t-");
            } else {
                System.out.println((i+1) + "\t\t\t" + distancia[i]);
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
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

        System.out.println("Se aplicará el algoritmo de Dijkstra en el siguiente grafo:");
        grafo.mostrarMatriz();

        System.out.println("Ingrese un número del 1 al 5 para elegir el origen del grafo.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int number = (isNumeric(str)) ? (Integer.parseInt(str)) : (-1);
        if(number > 0 && number <= 5) {
            System.out.println("Algoritmo de Dijkstra con origen en " + number);
            int[] resultadoDijkstra = Dijkstra.dijkstra(grafo, number);
            imprimirResultado(resultadoDijkstra);
        } else {
            System.out.println("Numbero incorrecto");
        }

    }

}
