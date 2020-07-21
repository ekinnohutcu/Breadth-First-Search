//EKİN NOHUTÇU 150116067
public class Node {

    private int i;
    private double x;
    private double y;
    private double r;
    private boolean visited;

    public Node(int i, double x, double y, double r){
        this.i = i;
        this.x = x;
        this.y = y;
        this.r = r;
        this.visited = false;

    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getI() {
        return i;
    }

    public boolean getVisited(){
        return visited;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
