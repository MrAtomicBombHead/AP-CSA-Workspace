package graphingcalculator;

@FunctionalInterface
public interface Expression {
    double evaluate(double x);
}