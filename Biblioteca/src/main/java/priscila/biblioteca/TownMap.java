
package priscila.biblioteca;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class TownMap extends javax.swing.JPanel {
    private final Connection connectDB;
    ArrayList<Node> graph = new ArrayList<>();
    private Node library = null;
    private Node destination = null;
    private final String idLibrary = "library"; 
    private MainFrame mainFrame;
  
    public TownMap(MainFrame mainFrame, Connection connectDB) {
        this.connectDB = connectDB;
        this.mainFrame = mainFrame;
        initComponents();    
        buildGraph();
        showMap();
    }
    
    private void buildGraph(){
        try {
            Statement st =  connectDB.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, posX, posY, color FROM map_houses");
            while(rs.next()){
                Node node = new Node(rs.getString("id"), rs.getInt("posX"), rs.getInt("posY"), rs.getString("color"));
                graph.add(node);
            }
            for(Node node: graph){
                rs = st.executeQuery("SELECT idNeighbor, goX FROM map_neighbors WHERE idHouse = '" + node.getData() + "'");
                ArrayList<Edge> edges = new ArrayList<>();
                while(rs.next()){
                    Node neighbor = getNode(rs.getString("idNeighbor"));
                    int weight = Math.abs(node.getPosX() - neighbor.getPosX() + Math.abs(node.getPosY() - neighbor.getPosY()));
                    Edge edge = new Edge(neighbor, weight, rs.getInt("goX") == 1);
                    edges.add(edge);
                }
                node.setEdges(edges);
            }
            rs.close();
            st.close();
            // Aqui se ejecuta Dijkstra 
            library = getNode(idLibrary);
            Dijkstra(library);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TownMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Node getNode(String data){
         for(Node node: graph){
             if(node.getData().compareTo(data) == 0)
                 return node;
         }
         return null;
    }
    
    private void Dijkstra(Node startNode) {
        startNode.setDistance(0);
        PriorityQueue<Node> nodesDistances = new PriorityQueue<>();
        nodesDistances.add(startNode);
        while(!nodesDistances.isEmpty()) {
            Node nodoActual = nodesDistances.poll();
            if(!nodoActual.isVisited()) {
                nodoActual.setVisited(true);
                for(Edge arco : nodoActual.getEdges()) {
                    Node adyacente = arco.getDestination();
                    int pesoTemporal = nodoActual.getDistance() + arco.getWeight(); 
                    if(pesoTemporal < adyacente.getDistance()) {
                        adyacente.setDistance(pesoTemporal);
                        adyacente.setPrevious(nodoActual);
                        nodesDistances.add(adyacente);
                    }
                }
            }
        }
    }
    
    private void showMap(){
         for(Node node: graph){
             JButton house = new JButton();
             house.setBorderPainted(false);
             house.setContentAreaFilled(false);
             house.setBounds(node.getPosX()*40, node.getPosY()*40, 40, 40);
             house.setToolTipText(node.getData());
             BufferedImage image = tinyHouseImage(node.getColor());
             ImageIcon icon = new ImageIcon(image);
             if(node.getData().compareTo(idLibrary) == 0){
                 house.setBounds(node.getPosX()*40-40, node.getPosY()*40-40, 120, 120);
                 image = tinyLibraryImage(node.getColor());
                 icon = new ImageIcon(image);
             }
             house.setIcon(icon); 
             house.addActionListener((ActionEvent e) -> {
                JButton srcButton = (JButton) e.getSource();
                destination = getNode(srcButton.getToolTipText());
                //lDestino.setText("Destino: " + srcButton.getToolTipText() + " a una distancia de: " + destination.getDistancia());
                this.repaint();
            });
             this.add(house);
         }
         this.revalidate();
    }
    
    public BufferedImage tinyHouseImage(String color) {
        BufferedImage img = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Color colorRGB = Color.decode("#" + color);
        int[] xPoints = {0, 20, 40, 36, 36, 25, 25, 15, 15, 4, 4};
        int[] yPoints = {20, 0, 20, 20, 40, 40, 26, 26, 40, 40, 20};
        g2d.setColor(colorRGB);
        g2d.fillPolygon(xPoints, yPoints, 11);
        g2d.setColor(colorRGB.darker());
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xPoints, yPoints, 11);
        g2d.dispose();        
        return img;
    }
    
    public BufferedImage tinyLibraryImage(String color) {
        BufferedImage img = new BufferedImage(120, 120, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Color colorRGB = Color.decode("#" + color);
        int[] xPoints = {25, 25, 12, 65, 120, 107, 107, 78, 78, 54, 54};
        int[] yPoints = {120,60, 60, 5, 60, 60, 120, 120, 80, 80, 120};
        g2d.setColor(colorRGB.darker());
        g2d.fillPolygon(xPoints, yPoints, 11);
        g2d.setColor(colorRGB);
        for(int i = 0; i < xPoints.length; i++){
            xPoints[i]-= 12;
            yPoints[i]-=5;
        }
        g2d.fillPolygon(xPoints, yPoints, 11);
        g2d.dispose();        
        return img;
    }    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(Node node: graph){
            for(Edge edge: node.getEdges()){
                if(edge.getGoX()){
                    g2d.drawLine(node.getPosX()*40 + 20, node.getPosY()*40 + 20, edge.getDestination().getPosX()*40 + 20, node.getPosY()*40 + 20);
                    g2d.drawLine(edge.getDestination().getPosX()*40 + 20, node.getPosY()*40 + 20,edge.getDestination().getPosX()*40 + 20 , edge.getDestination().getPosY()*40 + 20);
                }
                else{
                     g2d.drawLine(node.getPosX()*40 + 20, node.getPosY()*40 + 20, node.getPosX()*40 + 20, edge.getDestination().getPosY()*40 + 20);
                     g2d.drawLine( node.getPosX()*40 + 20, edge.getDestination().getPosY()*40 + 20, edge.getDestination().getPosX()*40 + 20, edge.getDestination().getPosY()*40 + 20 );
                }
            }
        }
        if(library != null && destination != null){
            Node route = destination;
            g2d.setStroke(new BasicStroke(5));
            while(route.getPrevious() != null){
                Edge correctEdge = null;
                for(Edge edge: route.getEdges()){
                    if(route.getPrevious().getData().compareTo(edge.getDestination().getData()) == 0){
                        correctEdge = edge;
                    }
                }
                if(correctEdge.getGoX()){
                    g2d.drawLine(route.getPosX()*40 + 20, route.getPosY()*40 + 20, correctEdge.getDestination().getPosX()*40 + 20, route.getPosY()*40 + 20);
                    g2d.drawLine(correctEdge.getDestination().getPosX()*40 + 20, route.getPosY()*40 + 20,correctEdge.getDestination().getPosX()*40 + 20 , correctEdge.getDestination().getPosY()*40 + 20);
                }
                else{
                     g2d.drawLine(route.getPosX()*40 + 20, route.getPosY()*40 + 20, route.getPosX()*40 + 20, correctEdge.getDestination().getPosY()*40 + 20);
                     g2d.drawLine( route.getPosX()*40 + 20, correctEdge.getDestination().getPosY()*40 + 20, correctEdge.getDestination().getPosX()*40 + 20, correctEdge.getDestination().getPosY()*40 + 20 );
                }
                route = route.getPrevious();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(157, 114, 0));
        jButton1.setFont(new java.awt.Font("Arimo", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(644, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(561, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(destination != null){
            mainFrame.setDestinationToLendingManagment(destination.getData());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
