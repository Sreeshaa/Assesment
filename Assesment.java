import java.util.Random;

// Define a Player class to represent players in the Magical Arena
class Player {
    // Player attributes
    private int health;
    private int strength;
    private int attack;

    // Constructor to initialize Player attributes
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // Getter method for health attribute
    public int getHealth() {
        return health;
    }

    // Getter method for strength attribute
    public int getStrength() {
        return strength;
    }

    // Getter method for attack attribute
    public int getAttack() {
        return attack;
    }

    // Method to reduce player's health by given damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) { // Ensure health doesn't go below 0
            health = 0;
        }
    }

    // Method to check if player is alive
    public boolean isAlive() {
        return health > 0;
    }

    // Method to simulate rolling a six-sided die
    public int rollDice() {
        Random rand = new Random(); // Initialize random number generator
        return rand.nextInt(6) + 1; // Generate a random number between 1 and 6
    }
}

// Main class for the Magical Arena game
public class MagicalArena {
    public static void main(String[] args) {
        // Create two players with specified attributes
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        // Main game loop: continue until one of the players is defeated
        while (playerA.isAlive() && playerB.isAlive()) {
            // Player A attacks
            int attackerDamage = playerA.getAttack() * playerA.rollDice(); // Calculate attacker's damage
            int defenderStrength = playerB.getStrength() * playerB.rollDice(); // Calculate defender's strength
            int damageDealt = Math.max(attackerDamage - defenderStrength, 0); // Calculate damage dealt after defending
            playerB.takeDamage(damageDealt); // Reduce defender's health

            // Check if player B is defeated
            if (!playerB.isAlive()) {
                System.out.println("Player A won the match!"); // Print winner
                break; // Exit loop
            }

            // Player B attacks
            int attackerDamage2 = playerB.getAttack() * playerB.rollDice(); // Calculate attacker's damage
            int defenderStrength2 = playerA.getStrength() * playerA.rollDice(); // Calculate defender's strength
            int damageDealt2 = Math.max(attackerDamage2 - defenderStrength2, 0); // Calculate damage dealt after defending
            playerA.takeDamage(damageDealt2); // Reduce defender's health

            // Check if player A is defeated
            if (!playerA.isAlive()) {
                System.out.println("Player B won the match!"); // Print winner
                break; // Exit loop
            }
        }
    }
}