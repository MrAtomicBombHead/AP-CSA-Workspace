package graphingcalculator;

import java.util.ArrayList;

public class Term implements Expression {
    private final ArrayList<Factor> factors = new ArrayList<>();

    public Term(String strTerm) {
        System.out.println("Term created: " + strTerm);

        ArrayList<String> strFactors = splitIgnoringParenthesis(strTerm);

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

    public ArrayList<String> splitIgnoringParenthesis(String equation) {
        ArrayList<String> strTerms = new ArrayList<>();
        int previousSplit = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') { //skips through parenthesis
                i = Factor.skipParenthesis(equation, i);
            } else {
                if (equation.charAt(i) == '/') {
                    equation = equation.substring(0, i) + "*(" + equation.substring(i+1) + ")^(-1)";
                }
                if (equation.charAt(i) == '*') {
                    String term = equation.substring(previousSplit, i);
                    strTerms.add(term);
                    previousSplit = i+1;
                }
            }
        }
        String term = equation.substring(previousSplit);
        strTerms.add(term);

        return strTerms;
    }
}