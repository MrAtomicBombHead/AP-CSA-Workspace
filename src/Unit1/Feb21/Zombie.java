package Unit1.Feb21;

public class Zombie {

    private final String name;
    private final int maxHealth;
    private int health;
    private final int damage;
    private final double movementSpeed;
    private boolean isAlive;

    public Zombie(String name, int maxHealth, int damage, double movementSpeed) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
        this.movementSpeed = movementSpeed;

        isAlive = true;
    }


    public void death() {
        System.out.println(name + " the zombie died.");
        isAlive = false;
    }

    public void hurt(int damage) {
        if (!isAlive) return;
        health -= damage;
        if (health <= 0) death();
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public double getMovementSpeed() {
        return movementSpeed;
    }
    public boolean isAlive() {
        return isAlive;
    }
}