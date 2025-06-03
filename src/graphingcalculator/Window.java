package graphingcalculator;

import java.awt.*;
import java.util.*;
import javax.swing.JFrame;

public class Window extends Canvas {
   
   private final boolean exactDrawMode = false;
   private final int drawAmount = 50;

   private int width, height;  
   private ArrayList<Function> equations;
   private JFrame frame;
   
   private double xWindow, yWindow;

   public Window(int width, int height, double xWindow, double yWindow, ArrayList<Function> equations) {
      //initialization
      frame = new JFrame("My Drawing");
      this.width = width;
      this.height = height;
      this.xWindow = xWindow;
      this.yWindow = yWindow;
      this.equations = equations;
      this.setSize(width, height);
      frame.add(this);
      frame.pack();
      frame.setVisible(true);
   }

   public void paint(Graphics g) {
      g.fillRect(0, height/2, width, 4);//X-axis
      g.fillRect(width/2, 0, 4, height);//Y-axis
      for (int i = 0; i < equations.size(); i++) { //for each equation
         g.setColor(equations.get(i).getColor()); //set color to chosen line color
         if (exactDrawMode) {
            for (int ii = 0; ii < this.width; ii++) { //for each x-value (pixels)
               double X = ii-width/2; //transform to math coordinates
               X /= width/xWindow; //apply window
               double xValue = equations.get(i).calculate(X);
               if (Double.isNaN(xValue)) continue;
               double Y = -xValue*(height/yWindow) + height/2; //apply window and transform to math coordinates
               
               g.fillRect(ii, (int)Y, 2, 2); //make a 1x1 rectangle at the point
            }
         } else {
            for (int ii = 0; ii < this.width * drawAmount; ii++) {
               double X = ii-width/2*drawAmount; //transform to math coordinates
               X /= width/xWindow*drawAmount; //apply window
               double xValue = equations.get(i).calculate(X);
               if (Double.isNaN(xValue)) continue;
               double Y = -xValue * (height/yWindow) + height/2; //apply window and transform to math coordinates

               g.fillRect(Math.round(ii/(float)drawAmount), (int)Y, 2, 2); //make a 1x1 rectangle at the point
            }
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