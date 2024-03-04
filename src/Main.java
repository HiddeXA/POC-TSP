import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < 10; i++) {
            nodes.add(new Node( (int)(Math.random()*(600-1))+1, (int)(Math.random()*(1000-1))+1));
        }
        GridMap map = new GridMap(600, 1000, nodes);

        map.printSolution();

        map.drawSolution();
    }
}