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

        //a power
        if (strFactor.contains("^")) {
            String[] parts = strFactor.split("\\^"); //parts[0] is base, parts[1] is exponent
            
            Expression base = (x) -> parts[0].equals("x") ? x : Double.valueOf(parts[0]);
            Expression exponent = (x) -> parts[1].equals("x") ? x : Double.valueOf(parts[1]);
            expression = (x) -> Math.pow(base.evaluate(x), exponent.evaluate(x));

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
