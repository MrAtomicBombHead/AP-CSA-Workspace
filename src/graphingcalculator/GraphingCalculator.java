package graphingcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GraphingCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter equation");
        String input = scanner.nextLine();

        Equation equation = new Equation(input);

        while(true) {
            System.out.println("Enter an X value to solve for, or cancel to exit");
            input = scanner.nextLine();
            if (input.equals("cancel")) break;
            System.out.println("Value is " + equation.evaluate(Double.parseDouble(input)));
        }
    }
}
