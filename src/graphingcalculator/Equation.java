package graphingcalculator;

import java.awt.Color;
import java.util.ArrayList;

public class Equation implements Expression{
    private Color color;
    private final ArrayList<Term> terms = new ArrayList<>();

    public Equation(String strEquation) {
        String[] strTerms = strEquation.split("\\+");

        for (String strTerm : strTerms) {
            terms.add(new Term(strTerm));
        }
    }

    @Override
    public double evaluate(double x) {
        double total = 0;

        for (Term term : terms) {
            total += term.evaluate(x);
        }
        
        return total;
    }

    public Color getColor() {
        return color;
    }
}
