
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.Timer;
 
  
public class Test extends Canvas{  

    private Timer timer;
    public Test() {   }
    public void paint(Graphics g) { 
        
        
        Image[] image = create();
        for (int i = 0; i < image.length; i++)  {
            try {
                Thread.sleep(500);
            } catch ( Exception e) {
                System.out.println("faileds");
            }
            g.clearRect(0, 0, 1200, 800);
            g.drawImage(image[i], 200, 200, this);
        } 
          
    }  
    public static Image[] create() {
        
        BufferedImage image = new BufferedImage(800, 800,BufferedImage.TYPE_INT_RGB);
        try {
            image = ImageIO.read(new File("R.png"));
            System.out.println(image.getWidth()); 
        } catch (Exception e) {
            System.out.println("Failed");
        }
        // The above line throws an checked IOException which must be caught.
        final int width = 78;
        final int height = 108;
        final int rows = 8;
        final int cols = 4;
        BufferedImage[] sprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                sprites[(i * cols) + j] = image.getSubimage(
                    j * width,
                    i * height,
                    width,
                    height
                );
            }
        }
        return sprites;
    }
    
        public static void main(String[] args) { 
        
        Test m = new Test();  
        JFrame f = new JFrame();  
         
        f.setSize(1200,800);  
        //f.setLayout(null);  
        f.setVisible(true);  
        
        f.add(m); 
    } 
}
