package graphingcalculator;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GraphingCalculator {

    private static ArrayList<Function> equations = new ArrayList<>();
    
    private static double xWindow = 20;
    private static double yWindow = 20;

    private static Window window = new Window(500, 500, xWindow, yWindow, equations);

    
    public static void main(String[] args) {
        final String[] options = {"Add an equation", "Remove an equation", "Solve for a point", "Change x-window", "Change y-window", "Change equation color", "How to use"};
        while (true) {
            int select = JOptionPane.showOptionDialog(null, "Select an option", "GRAPHING CALCULATOR", 1, 3, null, options, null);

            switch(select) {
                case 0: 
                    addEquation();
                    break;
                case 1:
                    removeEquation();
                    break;
                case 2:
                    solveForAPoint();
                    break;
                case 3:
                    changeXWindow();
                    break;
                case 4:
                    changeYWindow();
                    break;
                case 5:
                    changeEquationColor();
                    break;
                case 6:
                    showUseGuide();
                    break;
                default: return;
            }
        }
    }

    private static void addEquation() {
        System.out.println("Adding equation");
        String equationInput = JOptionPane.showInputDialog(null, "Enter an equation", "GRAPHING CALCULATOR", 1);
        Color color = pickColor();
        Function equation;
        try {            
            equation = new Function(equationInput, color);
            equation.calculate(0);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Equation");
            return;
        }

        equations.add(equation);
        refreshGraph();
    }

    private static void removeEquation() {
        equations.remove(pickEquation());
        refreshGraph();
    }

    private static void solveForAPoint() {
        try {
            Function equation = pickEquation();
            if (equation == null) return;
            double value = equation.calculate(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a value to solve for", "GRAPHING CALCULATOR", 1)));
            JOptionPane.showMessageDialog(null, "Value is: " + value, "GRAPHING CALCULATOR", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not a point", "GRAPHING CALCULATOR", 1);
        }
    }

    private static void changeXWindow() {
        try {
            xWindow = 2*Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a value to change to.\nEx. input 10 means the window goes from x=10 to x=-10", "GRAPHING CALCULATOR", 1));
            refreshGraph();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not a number", "GRAPHING CALCULATOR", 1);
        }
    }

    private static void changeYWindow() {
        try {
            yWindow = 2*Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a value to change to.\nEx. input 10 means the window goes from y=10 to y=-10", "GRAPHING CALCULATOR", 1));
            refreshGraph();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not a number", "GRAPHING CALCULATOR", 1);
        }
    }

    private static void changeEquationColor() {
        Function equation = pickEquation();
        Color newColor = pickColor();

        equation.setColor(newColor);
        refreshGraph();
    }

    private static void showUseGuide() {
        JOptionPane.showMessageDialog(null, USER_GUIDE, "GRAPHING CALCULATOR", 1);
    }

    private static Function pickEquation() {
        Function[] options = equations.toArray(new Function[0]);

        int selection = JOptionPane.showOptionDialog(null, "Select an equation", "GRAPHING CALCULATOR", 1, 1, null, options, null);
        try {
            return options[selection];
        } catch (Exception e) {
            return null;
        }
    }

    private static Color pickColor() {
        Color[] colors = {Color.black, Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.pink};
        String[] strColors = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Pink"};
        
        int selection = JOptionPane.showOptionDialog(null, "Choose a color", "GRAPHING CALCULATOR", 1, 1, null, strColors, strColors[0]);
        
        return colors[selection];
    }

    private static void refreshGraph() {
        window.kill();
        window = new Window(500, 500, xWindow, yWindow, equations);
    }


    private static final String USER_GUIDE = "Enter any equation in any form!\nMultiplication is not implied, so an equation like 2x should be written as 2*x and an equation like (x)(x-2) should be (x)*(x-2).\nPowers should be written as b^e. If either part is more than one thing use parenthesis (b)^(e).\nRoot functions should be written as ert(b). Ex. sqrt(x) is 2rt(x). Square root can be simplified to just rt instead of 2rt.\nLog works the same way as root. 2log(x) is log base 2 of x. base 10 log can be simplified to just log. Other supported functions: sin, cos, tan";
    
}
