package Resources;

import Algorithms.*;

import java.util.ArrayList;
import java.util.Scanner;

import static Algorithms.BFS.bfsAlg;
import static Algorithms.DFS.dfsAlg;

public class Ejemplos {

    public static void BFS() {
        GrafoDinamic grafo = new GrafoDinamic();

        //Agregar vertices
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        //Agregar aristas
        grafo.agregarArista(0, 1, 0);
        grafo.agregarArista(0, 2, 0);
        grafo.agregarArista(1, 2, 0);
        grafo.agregarArista(2, 0, 0);
        grafo.agregarArista(2, 3, 0);
        grafo.agregarArista(3, 3, 0);

        System.out.println("Se aplicará el algoritmo de BFS en el siguiente grafo:");
        grafo.mostrarMatriz();

        System.out.println("Ingrese un número del 0 al 3 para elegir el origen del grafo.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int number = (isNumeric(str)) ? (Integer.parseInt(str)) : (-1);
        if(number >= 0 && number <=3 && number == Math.abs(number)) {
            System.out.println("Algoritmo BFS, con origen " + number);
            NodoGrafo origen = grafo.encontrarNodo(number);
            ArrayList<Integer> lista = bfsAlg(origen);
            imprimirResultado(lista);
        } else {
            System.out.println("Numero incorrecto. Pruebe nuevamente.");
        }
    }

    public static void DFS(){

        //Inicializar el grafo
        GrafoDinamic grafo = new GrafoDinamic();

        //Agregar vertices
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        //Agregar aristas
        grafo.agregarArista(0, 1, 0);
        grafo.agregarArista(0, 2, 0);
        grafo.agregarArista(1, 2, 0);
        grafo.agregarArista(2, 0, 0);
        grafo.agregarArista(2, 3, 0);
        grafo.agregarArista(3, 3, 0);
        System.out.println("Se aplicará el algoritmo de DFS en el siguiente grafo:");
        grafo.mostrarMatriz();

        System.out.println("Ingrese un número del 0 al 3 para elegir el origen del grafo.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int number = (isNumeric(str)) ? (Integer.parseInt(str)) : (-1);
        if(number >= 0 && number <=3 && number == Math.abs(number)) {
            System.out.println("Algoritmo DFS, con origen " + number);
            NodoGrafo origen = grafo.encontrarNodo(number);
            ArrayList<Integer> lista = dfsAlg(origen);
            imprimirResultado(lista);
        } else {
            System.out.println("Numero incorrecto. Pruebe nuevamente.");
        }
    }

    public static void Dijkstra() {
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

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void imprimirResultado (ArrayList<Integer> lista) {
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(lista.get(i) + " ");
            } else {
                System.out.print(lista.get(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Elija el numero del algoritmo que desea probar:");
        System.out.println("1 - Dijkstra");
        System.out.println("2 - BFS");
        System.out.println("3 - DFS");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int number = (isNumeric(str)) ? (Integer.parseInt(str)) : (-1);
        if (number == 1) {
            Dijkstra();
        } else if (number == 2) {
            BFS();
        } else if (number == 3) {
            DFS();
        } else {
            System.out.println("Numero incorrecto. Pruebe nuevamente.");
        }
    }



}
