package graphingcalculator;

import java.awt.Color;
import java.util.Map;

public class Function {
    private final Map<Color, String> colorNames = Map.of(
        Color.black, "Black",
        Color.red, "Red",
        Color.orange, "Orange",
        Color.yellow, "Yellow",
        Color.green, "Green",
        Color.blue, "Blue",
        Color.pink, "Pink"
    );

    private Color color;
    private final String stringEquation;
    private final Equation equation;

    public Function(String stringEquation, Color color) {
        this.color = color;
        this.stringEquation = stringEquation;
        equation = new Equation(stringEquation);
    }

    public double calculate(double x) {
        return equation.evaluate(x);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return stringEquation + " - " + colorNames.get(color);
    }
}
