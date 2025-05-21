package graphingcalculator;

import java.awt.Color;
import java.util.ArrayList;

public class Equation implements Expression{
    private Color color;
    private final ArrayList<Term> terms = new ArrayList<>();

    public Equation(String strEquation) {
        System.out.println("Equation created: " + strEquation);

        //strEquation = strEquation.replace("-", "+-1*"); //redo this to only affect subtraction not negation
        strEquation = strEquation.replace(" ", "");

        

        ArrayList<String> strTerms = splitIgnoringParenthesis(strEquation);
        

        for (String strTerm : strTerms) {
            terms.add(new Term(strTerm));
        }
    }

    public static ArrayList<String> splitIgnoringParenthesis(String equation) {
        ArrayList<String> strTerms = new ArrayList<>();
        int previousSplit = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') { //skips through parenthesis
                while (true) {
                    i++;
                    if (equation.charAt(i) == ')') break;
                }
            } else {
                if (equation.charAt(i) == '-' && i != 0 && equation.charAt(i-1) != '+') {
                    equation = insert(equation, "+", i);
                    System.out.println("Equation updated: " + equation);
                }
                if (equation.charAt(i) == '+') {
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

    public static String insert(String string, String insert, int index) {
        String bagBegin = string.substring(0,index);
        String bagEnd = string.substring(index);
        return bagBegin + insert + bagEnd;
    }
}
