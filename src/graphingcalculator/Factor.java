package graphingcalculator;

import java.util.ArrayList;

public class Factor implements Expression {

    private Expression expression;

    public Factor(final String strFactor) {
        System.out.println("Factor created: " + strFactor);

        //just a number
        if (canParse(strFactor)) {
            expression = (x) -> Double.valueOf(strFactor);

            return;
        }

        if (strFactor.charAt(0) == '-') {
            expression = new Term("-1*" + strFactor.substring(1));
            return;
        }

        //just an x
        if (strFactor.equals("x")) {
            expression = (x) -> x;
            return;
        }

        //a power
        if (strFactor.contains("^")) {
            ArrayList<String> parts = splitIgnoringParenthesis(strFactor, '^'); //parts[0] is base, parts[1] is exponent
            
            Expression base = new Factor(parts.get(0));
            Expression exponent = new Factor(parts.get(1));
            expression = (x) -> Math.pow(base.evaluate(x), exponent.evaluate(x));

            return;
        }

        //parenthesis
        if (strFactor.charAt(0) == '(') {
            expression = new Equation(strFactor.substring(1, strFactor.length()-1));
            return;
        }

        //sine
        if (strFactor.contains("sin")) {
            Expression contents = new Factor(strFactor.substring(3));
            expression = (x) -> Math.sin(contents.evaluate(x));

            return;
        }

        //cosine
        if (strFactor.contains("cos")) {
            Expression contents = new Factor(strFactor.substring(3));
            expression = (x) -> Math.cos(contents.evaluate(x));

            return;
        }

        //tangent
        if (strFactor.contains("tan")) {
            Expression contents = new Factor(strFactor.substring(3));
            expression = (x) -> Math.tan(contents.evaluate(x));

            return;
        }

        //log
        if (strFactor.contains("log")) {
            Expression contents = new Factor(strFactor.substring(3));
            expression = (x) -> Math.log10(x);

            return;
        }
    }

    private boolean canParse(String number) {
        try {
            double num = Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 

    public static ArrayList<String> splitIgnoringParenthesis(String equation, char splitter) {
        ArrayList<String> strTerms = new ArrayList<>();
        int previousSplit = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') { //skips through parenthesis
                while (true) {
                    i++;
                    if (equation.charAt(i) == ')') break;
                }
            } else {
                if (equation.charAt(i) == splitter) {
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
        return expression.evaluate(x); 
    }
}
