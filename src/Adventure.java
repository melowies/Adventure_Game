import java.util.Random;
import java.util.Scanner;

public class Adventure {
    private Heroes hero;
    private int monstersEncountered = 0;
    private Events events = new Events();

    public void chooseHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your hero: 1) Archer 2) Wizard 3) Warrior 4) Assassin");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                hero = new Archer();
                break;
            case 2:
                hero = new Wizard();
                break;
            case 3:
                hero = new Warrior();
                break;
            case 4:
                hero = new Assassin();
                break;
            default:
                System.out.println("Invalid choice. Choosing Archer by default.");
                hero = new Archer();
                break;
        }

        System.out.println("You have chosen: " + hero.getClass().getSimpleName());
    }

    public void startJourney() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int distance = 100;

        while (hero.getDistanceWalked() < distance) {
            displayHeroStats();
            System.out.println("Press Enter to move forward.");
            scanner.nextLine();
            hero.setDistanceWalked(hero.getDistanceWalked() + hero.getStrideLength());
            System.out.println("You have walked " + hero.getDistanceWalked() + " meters.");

            if (hero.getDistanceWalked() % 25 == 0) {
                if (hero.getDistanceWalked() == 25 || hero.getDistanceWalked() == 75) {
                    System.out.println("You have encountered a market.");
                    events.marketEvent(hero);
                } else if (hero.getDistanceWalked() == 50) {
                    System.out.println("You have found a pet.");
                    if (hero.hasPetWhisperer()) {
                        Pets pet = events.encounterPet(random.nextInt(4));
                        hero.setPet(pet);
                        System.out.println("You have tamed a " + pet.getClass().getSimpleName() + "!");
                    } else {
                        System.out.println("You need a Pet Whisperer to tame the pet.");
                    }
                }
            } else if (random.nextInt(3) < 2) { 
                Monsters monster = events.spawnMonster(random.nextInt(4));
                monstersEncountered++;
                monster.setHp(monster.getHp() + (monstersEncountered * 5));
                monster.setAtk(monster.getAtk() + (monstersEncountered * 1));
                System.out.println("A wild " + monster.getClass().getSimpleName() + " appeared!");
                displayMonsterStats(monster);
                if (!battle(hero, monster)) {
                    if (hero.hasRespawnScroll()) {
                        System.out.println("You used a Respawn Scroll and revived!");
                        hero.setHp(hero.getHp() + 50);
                        hero.setRespawnScroll(false);
                    } else {
                        System.out.println("You have been defeated. Game over.");
                        return;
                    }
                } else {
                    hero.addExp(10); 
                    levelUp(hero); 
                }
            }
        }

        System.out.println("You have reached 100 meters and encounter the Dragon Boss!");
        Monsters dragon = new Dragon();
        if (battle(hero, dragon)) {
            System.out.println("Congratulations! You have defeated the Dragon Boss and completed the game.");
            System.out.println("1) Play again 2) Quit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                restartGame();
            } else {
                System.out.println("Thank you for playing!");
            }
        } else {
            System.out.println("You have been defeated by the Dragon Boss. Game over.");
        }
    }

    private boolean battle(Heroes hero, Monsters monster) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (hero.isAlive() && monster.isAlive()) {
            System.out.println("Choose your action: 1) Fight 2) Flee");
            int action = scanner.nextInt();

            if (action == 2) {
                if (random.nextBoolean()) {
                    System.out.println("You fled from the battle successfully!");
                    return true;
                } else {
                    System.out.println("You tried to hide in the bushes, but the " + monster.getClass().getSimpleName() + " found you and attacked!");
                    hero.setHp(hero.getHp() - monster.getAtk());
                    System.out.println("The " + monster.getClass().getSimpleName() + " attacked you for " + monster.getAtk() + " damage. Your HP is now " + hero.getHp());
                    if (!hero.isAlive()) {
                        return false;
                    }
                }
            } else {
                int totalAtk = hero.getAtk();
                if (hero.getPet() != null) {
                    totalAtk += hero.getPet().getAtk();
                    System.out.println("Your pet " + hero.getPet().getClass().getSimpleName() + " attacks the " + monster.getClass().getSimpleName() + " for " + hero.getPet().getAtk() + " damage!");
                }

                monster.setHp(monster.getHp() - totalAtk);
                System.out.println("You attacked the " + monster.getClass().getSimpleName() + " for " + totalAtk + " damage. Its HP is now " + monster.getHp());

                if (!monster.isAlive()) {
                    hero.addReward(10, 1, monster.getCoin());
                    System.out.println("You defeated the " + monster.getClass().getSimpleName() + " and gained 10 HP, 1 ATK, and " + monster.getCoin() + " coins.");
                    if (monster.dropsPetWhisperer()) {
                        hero.setPetWhisperer(true);
                        System.out.println("The " + monster.getClass().getSimpleName() + " dropped a Pet Whisperer!");
                    }
                    return true;
                }

                // Monster uses ability
                Ability ability = monster.getAbilities().get(random.nextInt(monster.getAbilities().size()));
                hero.setHp(hero.getHp() - ability.getDamage());
                System.out.println("The " + monster.getClass().getSimpleName() + " uses " + ability.getName() + " and deals " + ability.getDamage() + " damage. Your HP is now " + hero.getHp());
            }
        }

        return hero.isAlive();
    }

    private void displayHeroStats() {
        System.out.println("Hero HP: " + hero.getHp() + ", ATK: " + hero.getAtk() + ", Coins: " + hero.getCoin() + ", Mana: " + hero.getMana() + ", EXP: " + hero.getExp() + ", Level: " + hero.getLevel());
    }

    private void displayMonsterStats(Monsters monster) {
        System.out.println("Monster HP: " + monster.getHp() + ", ATK: " + monster.getAtk());
    }

    private void levelUp(Heroes hero) {
        int exp = hero.getExp();
        int level = hero.getLevel();
        int requiredExp = level * 100; // Example formula for required experience

        while (exp >= requiredExp) {
            hero.setLevel(level + 1);
            hero.setHp(hero.getHp() + 20); // Increase HP by 20 on level up
            hero.setAtk(hero.getAtk() + 5); // Increase ATK by 5 on level up
            exp -= requiredExp;
            requiredExp = hero.getLevel() * 100;
            System.out.println("Congratulations! You have leveled up to level " + hero.getLevel() + ". Your HP is now " + hero.getHp() + " and ATK is now " + hero.getAtk());
        }

        hero.setExp(exp);
    }

    private void restartGame() {
        hero.setDistanceWalked(0);
        monstersEncountered = 0;
        chooseHero();
        startJourney();
    }
}
