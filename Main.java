import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //system objects
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        //game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assasin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 10;

        //player variables
        int health = 100;
        int attackDamage = 15;
        int numHealthPots = 3;
        int healthPotionHealAmmount = 30;
        int healthPotionDropChance = 50; // percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeons !");

        GAME:
        while (running) {
            System.out.println("--------------------------------------");
            int enemyHealth = random.nextInt(maxEnemyHealth);
            String enemy = enemies[random.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " #\n");

            while (enemyHealth > 0) {
                System.out.println("\t Your HP: " + health);
                System.out.println("\t " + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\t What would you like to do ?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");

                String input = sc.nextLine();
                if (input.equals("1")) {
                    int damageDealt = random.nextInt(attackDamage);
                    int damageTaken = random.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to continue");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPots > 0) {
                        health += healthPotionHealAmmount;
                        numHealthPots--;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmmount + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numHealthPots + " heal potions left. \n");
                    } else {
                        System.out.println("\t> You have no health potions left.");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t You run away from " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("Invalid command.");
                }
            }
            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("--------------------------------------");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + health + " HP left. #");
            if (random.nextInt(100) < healthPotionDropChance) {
                numHealthPots++;
                System.out.println(" # The " + enemy + " dropped a health potion. # ");
                System.out.println(" # You now have " + numHealthPots + " health potion's. # ");
            }
            System.out.println("--------------------------------------");
            System.out.println("What would you like to do now ?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit the dungeon");

            String input = sc.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = sc.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            }
            else if (input.equals("2")) {
                System.out.println("You exit the dungeons.");
                break;
            }
        }
        System.out.println("###########################");
        System.out.println("###########################");
        System.out.println("THANKS FOR PLAYING.");
        System.out.println("###########################");
        System.out.println("###########################");
    }
}
