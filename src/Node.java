import java.util.ArrayList;

public class Node {
    private int id;
    private int locationY;
    private int locationX;
    private Node lastVisited;

    private static int idIteration = 1;

    public Node(int locationY, int locationX) {
        this.locationY = locationY;
        this.locationX = locationX;
        this.id = idIteration;
        idIteration++;
    }

    public Node getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(Node lastVisited) {
        this.lastVisited = lastVisited;
    }

    public Node getClosestNode(ArrayList<Node> nodes){

        if (nodes.size() == 0) {
            return null;
        }

        if (nodes.size() == 1) {
            return nodes.get(0);
        }

        Node closestNode = nodes.get(0);
        Node currentNode;

        for (int i = 1; i < nodes.size(); i++) {
            currentNode = nodes.get(i);
//            if (Math.abs((this.locationY + this.locationX) - (currentNode.locationX + currentNode.locationY)) < Math.abs((this.locationY + this.locationX) - (closestNode.locationX + closestNode.locationY))) {
            if (Math.sqrt(Math.pow(currentNode.locationX - this.locationX, 2) + Math.pow(currentNode.locationY - this.locationY, 2)) < Math.sqrt(Math.pow(closestNode.locationX - this.locationX, 2) + Math.pow(closestNode.locationY - this.locationY, 2))) {
                closestNode = currentNode;
            }
        }

        return  closestNode;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationX() {
        return locationX;
    }
}
