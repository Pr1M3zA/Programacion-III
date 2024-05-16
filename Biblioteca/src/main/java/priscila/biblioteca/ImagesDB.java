package priscila.biblioteca;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;

public final class ImagesDB {
     private Connection connectDB;  
     private BufferedImage img;
     
     public ImagesDB(Connection connectDB, String idImage){
         this.connectDB = connectDB;
         this.img = this.GetImage(idImage);
     }
     
     public ImagesDB(Connection connectDB){
         this.connectDB = connectDB;
     }
     
     public BufferedImage GetImage(String IdImg) {
        try {
            Statement stm = connectDB.createStatement();
            try (ResultSet rs = stm.executeQuery("SELECT Img FROM imgresources WHERE Id='" + IdImg + "'")) {
                if(rs.next()) {
                    Blob blob = rs.getBlob("Img");
                    byte[] imgBuffer = blob.getBytes(1, (int)blob.length());
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBuffer));
                    rs.close();
                    return img;
                }
                rs.close();
            }
            return null;
        } catch (SQLException | IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return null;
        }    
    }
    
    public void UploadResourceImage(String Id, String fileImagePath) {
        try {
            PreparedStatement pst = connectDB.prepareStatement("INSERT INTO imgresources (id, img) VALUES ('" + Id + "', ?)");
            //File imgFile = new File("d://login.png");
            File imgFile = new File(fileImagePath);
            FileInputStream filestream = new FileInputStream(imgFile);
            pst.setBinaryStream(1, filestream, imgFile.length());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("MySQL ERROR: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("IO error: " + ex.getMessage());
        }
    }
    
    public BufferedImage MirrorVertical(BufferedImage img) {
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -img.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        img = op.filter(img, null);  
        return img;
    }

    public BufferedImage MirrorHorizontal(BufferedImage img) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-img.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        img = op.filter(img, null);        
        return img;
    }
    
    public BufferedImage Rotate(BufferedImage img, int angle){
        double rotationRequired = Math.toRadians (angle);
        double locationX = img.getWidth() / 2;
        double locationY = img.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(img, null);
    }
    
     public BufferedImage Rotate(int angle){
         return Rotate(img, angle);
     }
     
     public BufferedImage GetImage() {
         return img;
     }
     
     public BufferedImage MirrorHorizontal(){
        return MirrorHorizontal(img);
     }
     
     public BufferedImage MirrorVertical(){
        return MirrorVertical(img);
     }    
}
