import javax.swing.JOptionPane;

public class Tools {

    public static double getDoubleFromJOptionPane(String message, String title, int messageType) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, title, messageType);
            try {
                return Double.parseDouble(input);
            } catch (Exception e) {}
        }
    }
}