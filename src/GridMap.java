import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class GridMap extends JFrame {
    private int height;
    private int width;
    private ArrayList<Node> unvisitedNodes = new ArrayList<Node>();
    private ArrayList<Node> visitedNodes = new ArrayList<Node>();
    private int totalDistance = 0;


    public GridMap(int height, int width, ArrayList<Node> nodes) {
        this.height = height;
        this.width = width;
        this.unvisitedNodes = nodes;
        this.calculateSolution();
    }

    public void calculateSolution() {
        Node currentNode = unvisitedNodes.get(0);
        int id = 0;
        for (int i = 0; i < unvisitedNodes.size(); i++) {
            if ((currentNode.getLocationX() + currentNode.getLocationY()) > (unvisitedNodes.get(i).getLocationX() + unvisitedNodes.get(i).getLocationY())){
                currentNode = unvisitedNodes.get(i);
                id = i;
            }
        }
        Node closestNode;
        unvisitedNodes.remove(id);
        visitedNodes.add(currentNode);

        while (unvisitedNodes.size() >= 1) {
            closestNode = currentNode.getClosestNode(unvisitedNodes);
            closestNode.setLastVisited(currentNode);
            totalDistance = totalDistance + calculateDistanceBetweenNodes(currentNode, closestNode);
            System.out.println(totalDistance);
            currentNode = closestNode;
            visitedNodes.add(currentNode);

            for (int j = 0; j < unvisitedNodes.size(); j++) {
                if (unvisitedNodes.get(j) == currentNode) {
                    unvisitedNodes.remove(j);
                    break;
                }
            }

        }


    }

    public void printSolution() {
        for (int i = 0; i < visitedNodes.size(); i++) {
            System.out.println(" X: " + visitedNodes.get(i).getLocationX() + " Y: " + visitedNodes.get(i).getLocationY() );
        }
    }

    public void drawSolution() {
        setTitle("POC TSP");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Node currentNode;
                Node lastNode;
                //drawing grid
                width++;
                height++;
                for (int i = 1; i <= height ; i++) {
                    g.drawLine(75 - 34,  75 * i - 34  , 75 * width - 34,  75 * i - 34);
                    System.out.println("height" + i);
                }
                for (int i = 1; i <= width ; i++) {
                    g.drawLine(75 * i - 34,  75 - 34, 75 * i - 34,  75 * height - 34);
                    System.out.println("width" + i);

                }


                for (int i = 0; i < visitedNodes.size(); i++) {
                    currentNode = visitedNodes.get(i);
                    if (i == 0) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(Color.RED);
                    }
                    g.fillOval(((currentNode.getLocationX() * 75) - 5), ((currentNode.getLocationY() * 75) - 5), 10, 10);
                    g.setColor(Color.BLACK);
                    g.drawString(" X: " + visitedNodes.get(i).getLocationX() + " Y: " + visitedNodes.get(i).getLocationY() , width * 75, i * 30 + 80);
                    if (i > 0) {
                        lastNode = visitedNodes.get(i - 1);
                        g.setColor(Color.BLACK);
                        g.drawLine(lastNode.getLocationX() * 75, lastNode.getLocationY() * 75, currentNode.getLocationX() * 75, currentNode.getLocationY() * 75);
                    }
                }
            }
        };

        getContentPane().add(panel);
    }
    public static int calculateDistanceBetweenNodes(Node n1, Node n2) {
        return Math.abs((n1.getLocationY() + n1.getLocationX()) - (n2.getLocationX() + n2.getLocationY()));
    }
}
