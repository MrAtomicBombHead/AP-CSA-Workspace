import java.awt.*;
import java.util.*;
import javax.swing.JFrame;

public class Window extends Canvas {
   
   private int width, height;  
   private ArrayList<Equation> eq;
   private JFrame frame;
   
   private double xWindow, yWindow;

   public Window(int width, int height, double xWindow, double yWindow, ArrayList<Equation> eq) {
      //initialization
      frame = new JFrame("My Drawing");
      this.width = width;
      this.height = height;
      this.xWindow = xWindow;
      this.yWindow = yWindow;
      this.eq = eq;
      this.setSize(width, height);
      frame.add(this);
      frame.pack();
      frame.setVisible(true);
   }

   public void paint(Graphics g) {
      g.fillRect(0, height/2, width, 4);//X-axis
      g.fillRect(width/2, 0, 4, height);//Y-axis
      for (int i = 0; i < eq.size(); i++) { //for each equation
         g.setColor(eq.get(i).getColor()); //set color to chosen line color
      
         for (int ii = 0; ii < this.width; ii++) { //for each x-value (pixels)
            double X = ii-width/2; //transform to math coordinates
            X /= width/xWindow; //apply window
            double Y = -eq.get(i).getPolyY(X)*(height/yWindow) + height/2; //apply window and transform to math coordinates
            
            g.fillRect(ii, (int)Y, 2, 2); //make a 1x1 rectangle at the point
         }
      }
   }
    
   public void kill() {
      frame.dispose();
   }
   
   //getters
   public double getXWindow() { return this.xWindow; }
   public double getYWindow() { return this.yWindow; }
    
}