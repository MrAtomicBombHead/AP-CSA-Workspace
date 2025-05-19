package graphingcalculator;

public class Factor implements Expression {

    private Expression expression;

    public Factor(String strFactor) {
        System.out.println("Factor created: " + strFactor);

        //just a number
        if (canParse(strFactor)) {
            expression = (x) -> Double.valueOf(strFactor);

            return;
        }

        //just an x
        if (strFactor.equals("x")) {
            expression = (x) -> x;
            return;
        }

        //parenthesis
        if (strFactor.charAt(0) == '(') {
            expression = new Equation(strFactor.substring(1, strFactor.length()-1));
            return;
        }

        //a power
        if (strFactor.contains("^")) {
            String[] parts = strFactor.split("\\^"); //parts[0] is base, parts[1] is exponent
            
            Expression base = new Factor(parts[0]);
            Expression exponent = new Factor(parts[1]);
            expression = (x) -> Math.pow(base.evaluate(x), exponent.evaluate(x));

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
    
    @Override
    public double evaluate(double x) {
        return expression.evaluate(x); 
    }
}
