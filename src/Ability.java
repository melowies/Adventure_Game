public class Ability {
    private String name;
    private int damage;
    private int manaCost;

    public Ability(String name, int damage, int manaCost) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public boolean canUse(int currentMana) {
        return currentMana >= manaCost;
    }
}