package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class BFS {

    public static ArrayList<Integer> bfsAlg(NodoGrafo origen) {
        ArrayList<Integer> vertices = new ArrayList<>();
        irAVertice(origen, vertices);
        return vertices;
    }

    public static void irAVertice(NodoGrafo origen, ArrayList<Integer> vertices) {
        NodoArista aux = origen.lista;
        if (!origen.Visitado) {
            origen.Visitado = true;
            vertices.add(origen.valor);
        }
        while (aux != null) {
            if (!aux.apunta.Visitado) {
                aux.apunta.Visitado = true;
                vertices.add(aux.apunta.valor);
            }
            aux = aux.sig;
        }
        aux = origen.lista;
        while (aux != null) {
            if (!aux.Visitado) {
                aux.Visitado = true;
                irAVertice(aux.apunta, vertices);
            }
            aux = aux.sig;
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

}
