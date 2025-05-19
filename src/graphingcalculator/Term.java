package graphingcalculator;

import java.util.ArrayList;

public class Term implements Expression {
    private final ArrayList<Factor> factors = new ArrayList<>();

    public Term(String strTerm) {
        System.out.println("Term created: " + strTerm);

        ArrayList<String> strFactors = Equation.splitIgnoringParenthesis(strTerm, '*');

        for (String strFactor : strFactors) {
            factors.add(new Factor(strFactor));
        }
    }

    @Override
    public double evaluate(double x) {
        double total = 1;

        for (Factor factor : factors) {
            total *= factor.evaluate(x);
        }

        return total;
    }
}