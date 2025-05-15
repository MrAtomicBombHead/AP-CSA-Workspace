package graphingcalculator;

public class GraphingCalculator {
    
    public static void main(String[] args) {
        Equation equation = new Equation("2*x^2+4*x+-1");

        System.out.println(equation.evaluate(1));
    }
}
