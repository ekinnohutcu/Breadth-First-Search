import java.util.*;
//EKİN NOHUTÇU 150116067

public class Graph {
    private double adjMatrix[][];
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new double[numVertices][numVertices];
    }

    public void addEdge(int i, int j, double distance) {
        adjMatrix[i][j] = distance;
        adjMatrix[j][i] = distance;
    }



    public void print() {
        // Loop through all rows
        for (int i = 0; i < adjMatrix.length; i++){
            System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < adjMatrix[i].length; j++)
                System.out.print(adjMatrix[i][j] + " ");
        }
    }

    public double[][] getAdjMatrix() {
        return adjMatrix;
    }
}