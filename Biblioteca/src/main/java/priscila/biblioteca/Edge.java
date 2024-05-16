/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priscila.biblioteca;

public class Edge {
    private final Node destination;
    private final boolean goX;
    private final int weight;

    public Edge(Node destination, int weight, boolean goX) {
        this.destination = destination;
        this.weight = weight;
        this.goX = goX;
    }
    public Node getDestination() {
        return destination;
    }
    public int getWeight() {
        return weight;
    }
    public boolean getGoX() {
        return goX;
    }
}
