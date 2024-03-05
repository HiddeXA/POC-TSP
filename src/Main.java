import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        int gridHeight = 5;
        int gridWidth = 5;
        int nodeCount = 3;

        for (int i = 0; i < nodeCount; i++) {
            nodes.add(new Node( (int)(Math.random()*(gridHeight-1))+1, (int)(Math.random()*(gridWidth-1))+1));
        }
        GridMap map = new GridMap(gridHeight, gridWidth, nodes);

        map.printSolution();

        map.drawSolution();
    }
}