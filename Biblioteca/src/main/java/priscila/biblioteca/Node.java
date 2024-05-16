package priscila.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private String data;
    private boolean visited;
    private List<Edge> edges = new ArrayList<>();
    private int distance = Integer.MAX_VALUE;
    private Node previous = null;
    private final int posX, posY;
    private final String color;

    public Node(String data, int posX, int posY, String color) {
        this.data = data;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }
    public String getData() {
        return data;
    }
    public void setData(String dato) {
        this.data = dato;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public List<Edge> getEdges() {
        return edges;
    }
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public String getColor() {
        return color;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}