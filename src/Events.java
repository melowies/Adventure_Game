import java.util.Random;
import java.util.Scanner;

public class Events {

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void marketEvent(Heroes hero) {
        System.out.println("Welcome to the market! You have " + hero.getCoin() + " coins.");
        System.out.println("1) ATK Potion (10 coins, +5 ATK)");
        System.out.println("2) HP Potion (10 coins, +20 HP)");
        System.out.println("3) Respawn Scroll (30 coins)");
        System.out.println("4) Mana Potion (10 coins, +10 Mana)");
        System.out.println("5) Pet Whisperer (50 coins)");
        System.out.println("6) Ability Summoner (40 coins)");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (hero.getCoin() >= 10) {
                    hero.setAtk(hero.getAtk() + 5);
                    hero.setCoin(hero.getCoin() - 10);
                    System.out.println("You bought an ATK Potion! Your ATK is now " + hero.getAtk());
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            case 2:
                if (hero.getCoin() >= 10) {
                    hero.setHp(hero.getHp() + 20);
                    hero.setCoin(hero.getCoin() - 10);
                    System.out.println("You bought an HP Potion! Your HP is now " + hero.getHp());
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            case 3:
                if (hero.getCoin() >= 30) {
                    hero.setRespawnScroll(true);
                    hero.setCoin(hero.getCoin() - 30);
                    System.out.println("You bought a Respawn Scroll!");
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            case 4:
                if (hero.getCoin() >= 10) {
                    hero.setMana(hero.getMana() + 10);
                    hero.setCoin(hero.getCoin() - 10);
                    System.out.println("You bought a Mana Potion! Your Mana is now " + hero.getMana());
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            case 5:
                if (hero.getCoin() >= 50) {
                    hero.setPetWhisperer(true);
                    hero.setCoin(hero.getCoin() - 50);
                    System.out.println("You bought a Pet Whisperer!");
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            case 6:
                if (hero.getCoin() >= 40) {
                    hero.setAbilitySummoner(true);
                    hero.setCoin(hero.getCoin() - 40);
                    System.out.println("You bought an Ability Summoner!");
                } else {
                    System.out.println("You don't have enough coins.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public Pets encounterPet(int petType) {
        switch (petType) {
            case 0:
                return new Fox();
            case 1:
                return new Snake();
            case 2:
                return new Wolf();
            case 3:
                return new Turtle();
            default:
                return new Fox();
        }
    }

    public Monsters spawnMonster(int monsterType) {
        Monsters monster;
        switch (monsterType) {
            case 0:
                monster = new Zombie();
                break;
            case 1:
                monster = new Skeleton();
                break;
            case 2:
                monster = new Slime();
                break;
            case 3:
                monster = new Vampire();
                break;
            default:
                monster = new Zombie();
                break;
        }
        monster.setDropsPetWhisperer(new Random().nextInt(100) < 20); // 20% chance to drop Pet Whisperer
        return monster;
    }

    public void randomAbilityEvent(Heroes hero) {
        Random random = new Random();
        Ability randomAbility = hero.getAbilities()[random.nextInt(hero.getAbilities().length)];
        System.out.println("Before the final battle, you find a scroll that grants you the ability to use " + randomAbility.getName() + "!");
    }
}