package Unit0.Feb10;

public class FRQPracticeRandom {
    
    public static void main(String[] args) {

        int num1 = (int)(Math.random()*40);
        int num2 = (int)(Math.random()*40);
        int num3 = (int)(Math.random()*40);

        int numberOfCombos = (int)Math.pow(40, 3);

        System.out.println(5/2.5);
        System.out.println("Combo is " + num1 + " " + num2 + " " + num3);

        System.out.println(numberOfCombos + " combos");
    }
}
