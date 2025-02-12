package Unit0.Feb6;

/**
 * Connor Mulligan
 * 
 * This program will demonstrate how to use String class methods
 */
public class StringClassStuff {

    public static void main(String[] args) {
        System.out.println(repeatFront("Connor", 3));
        System.out.println(repeatFront("AP CSA", 6));
        System.out.println(repeatFront("Hello", 4));
    }

    private static String repeatFront(String string, int n) {
        if (n > string.length() || n < 0) 
            throw new RuntimeException("Parameter n must be between 0 and the string's length");
            
        String output = "";
        for (int i = n; i > 0; i--) {
            output += string.substring(0, i);
        }
        return output;
    }
}
