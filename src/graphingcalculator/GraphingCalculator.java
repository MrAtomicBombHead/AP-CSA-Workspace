package graphingcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GraphingCalculator {

    private static ArrayList<Equation> equations = new ArrayList<>();
    
    private static double xWindow = 20;
    private static double yWindow = 20;

    private static Window window = new Window(500, 500, xWindow, yWindow, equations);

    
    public static void main(String[] args) {
        final String[] options = {"Add an equation"};
        while (true) {
            int select = JOptionPane.showOptionDialog(null, "Select an option", "GRAPHING CALCULATOR", 1, 3, null, options, null);

            switch(select) {
                case 0: 
                    addEquation();
                    break;
                default: return;
            }
        }
    }

    private static void addEquation() {
        System.out.println("Adding equation");
        String equationInput = JOptionPane.showInputDialog(null, "Enter an equation", "GRAPHING CALCULATOR");
        Equation equation = new Equation(equationInput);
        try {equation.evaluate(0);}
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Equation");
            return;
        }
        equations.add(equation);
        refreshGraph();
    }

    private static void refreshGraph() {
        window.kill();
        window = new Window(500, 500, xWindow, yWindow, equations);
    }
}
