package Unit0.OracleClassSummative;

import javax.swing.JOptionPane;

public class OracleClassSummative {
    
    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        String[] functions = {"Largest Block", "Circle Area"};
        int choice = JOptionPane.showOptionDialog(null, "Choose a function", "MAIN MENU", 0, JOptionPane.PLAIN_MESSAGE, null, functions, null);
        switch (choice) {
            case 0: 
                String inputString = JOptionPane.showInputDialog(null, "Input a string", "Largest Block", 3);
                int largestBlock = largestBlock(inputString);
                JOptionPane.showMessageDialog(null, "The largest block is " + largestBlock, "Largest Block", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1: 
                try {
                    double radius = Double.parseDouble(JOptionPane.showInputDialog(null, "Input the circle radius", "Circle Area", 3));
                    double circleArea = circleArea(radius);
                    JOptionPane.showMessageDialog(null, "The area of your circle is " + circleArea, "Circle Area", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {}
                break;
        }
        mainMenu();
    }

    private static int largestBlock(String string) {
        char[] characters = string.toCharArray();
        int largestBlock = 0, currentBlock = 0;
        
        for (int i = 0; i < characters.length; i++) {
            if (i == 0 || characters[i] == characters[i-1]) currentBlock++;
            else {
                largestBlock = Math.max(largestBlock, currentBlock);
                currentBlock = 1;
            }
        }
        largestBlock = Math.max(largestBlock, currentBlock);

        return largestBlock;
    }

    private static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}