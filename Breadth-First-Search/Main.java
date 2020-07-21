import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

//EKİN NOHUTÇU 150116067

public class Main {

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {

        String path = args[0];

        File file = new File(path);
        String filename = "output" + path;

        PrintWriter writer = new PrintWriter(filename, "UTF-8");

        Scanner sc = new Scanner(file);
        int i = 0;

        ArrayList<Node> nodeList = new ArrayList<>();

        //read file put into arraylist
        while (sc.hasNext()) {

            String line = sc.nextLine();
            if (line.contains("##")) {
            } else {
                String[] line1 = line.split("\t");
                if (line1.length == 1) {
                } else {
                    i++;
                    nodeList.add(new Node(i, Double.parseDouble(line1[0]), Double.parseDouble(line1[1]), Double.parseDouble(line1[2])));
                }
            }
        }

        Graph g = new Graph(nodeList.size());

        for (int a = 0; a < nodeList.size(); a++) {

            double x1 = nodeList.get(a).getX();
            double y1 = nodeList.get(a).getY();
            double r = nodeList.get(a).getR();
            int a1 = nodeList.get(a).getI();


            for (int k = 1; k < nodeList.size(); k++) {


                if (a == k) continue;

                double x2 = nodeList.get(k).getX();
                double y2 = nodeList.get(k).getY();
                double r2 = nodeList.get(k).getR();
                int a2 = nodeList.get(k).getI();


                double distance = calculateDistance(x1, x2, y1, y2);

                if ((r + r2) >= distance) {
                    double m = r + r2;
                    g.addEdge(a1 - 1, a2 - 1, distance);
                }
            }
        }

        // g.print();

        double matrix[][] = g.getAdjMatrix();
        System.out.println();

        for (int b = 0; b < matrix.length; b++) {
            ArrayList<Integer> arrlist = BFS(matrix, 0, b);
            int hop = arrlist.size() - 1;
            writer.print("From 0. laptop to " + b + ". laptop ==> ");
            writer.println(" Hop distance is: " + hop);
            for (int a = 0; a < arrlist.size(); a++) {
                if (a == arrlist.size() - 1)
                    writer.print(arrlist.get(a));
                else
                    writer.print(arrlist.get(a) + "-->");
            }


            writer.println();
        }
        writer.close();

    }


    public static double calculateDistance(double x1, double x2, double y1, double y2) {

        double a = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        double distance = Math.sqrt(a);
        return distance;
    }


    public static ArrayList<Integer> BFS(double[][] matrix, int source, int destination) {

        ArrayList<Integer> bfs = new ArrayList<>();
        LinkedList<ArrayList<Integer>> list = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        bfs.add(source);
        list.add(bfs);
        visited[source] = true;

        int b = bfs.size() - 1;

        while (list.size() != 0) {

            bfs = list.remove();
            int a = bfs.size() - 1;
            int current = bfs.get(a);

            if (current == destination) {
                return bfs;
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    if ((matrix[current][i] > 0) && (visited[i] == false)) {
                        ArrayList<Integer> np = new ArrayList<>(bfs);
                        np.add(i);
                        list.add(np);
                        visited[i] = true;
                    }
                }
            }
        }
        int size = bfs.size() - 1;


        if (bfs.get(size) != destination) {
            bfs.clear();
            bfs.add(source);
        }
        return bfs;
    }


}
