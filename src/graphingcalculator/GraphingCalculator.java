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

        ArrayList<Equation> equations = new ArrayList<>(Arrays.asList(equation));

        Window window = new Window(500, 500, 20, 20, equations);
    }
}
