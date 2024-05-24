import java.util.ArrayList;
import java.util.List;

public abstract class Monsters {
    protected int atk;
    protected int hp;
    protected int coin;
    protected boolean dropsPetWhisperer;
    protected List<Ability> abilities;

    public Monsters(int hp, int atk, int coin) {
        this.hp = hp;
        this.atk = atk;
        this.coin = coin;
        this.dropsPetWhisperer = false;
        this.abilities = new ArrayList<>();
        initAbilities();
    }

    protected abstract void initAbilities();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public boolean dropsPetWhisperer() {
        return dropsPetWhisperer;
    }

    public void setDropsPetWhisperer(boolean dropsPetWhisperer) {
        this.dropsPetWhisperer = dropsPetWhisperer;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}

class Zombie extends Monsters {
    public Zombie() {
        super(50, 5, 10);
    }

    @Override
    protected void initAbilities() {
        abilities.add(new Ability("Bite", 5, 0));
    }
}

class Skeleton extends Monsters {
    public Skeleton() {
        super(90, 8, 5);
    }

    @Override
    protected void initAbilities() {
        abilities.add(new Ability("Bone Throw", 7, 0));
    }
}

class Slime extends Monsters {
    public Slime() {
        super(80, 7, 2);
    }

    @Override
    protected void initAbilities() {
        abilities.add(new Ability("Slime Splash", 4, 0));
    }
}

class Vampire extends Monsters {
    public Vampire() {
        super(70, 12, 20);
    }

    @Override
    protected void initAbilities() {
        abilities.add(new Ability("Blood Drain", 10, 0));
    }
}

class Dragon extends Monsters {
    public Dragon() {
        super(300, 25, 100);
    }

    @Override
    protected void initAbilities() {
        abilities.add(new Ability("Fire Breath", 30, 0));
    }
}