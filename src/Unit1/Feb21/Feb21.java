package Unit1.Feb21;

import java.util.Random;

public class Feb21 {
    
    public static void main(String[] args) {
        Zombie zombie = new Zombie("Bob", 20, 5, 2);

        Random random = new Random();
        zombie.hurt(random.nextInt(5,10));
        zombie.hurt(random.nextInt(5,10));
        zombie.hurt(random.nextInt(5,10));
        if (!zombie.isAlive()) System.out.println("You won!");
        else System.out.println("You lost :(");
    }
}
