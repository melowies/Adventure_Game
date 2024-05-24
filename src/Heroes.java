public abstract class Heroes {
    protected int hp;
    protected int atk;
    protected int coin;
    protected int exp;
    protected int distanceWalked;
    protected int strideLength;
    protected Pets pet;
    protected boolean hasPetWhisperer;
    protected boolean hasRespawnScroll;
    protected boolean hasAbilitySummoner;
    protected int mana;
    protected Ability[] abilities;
    protected int level;

    public Heroes(int hp, int atk, int strideLength, int mana) {
        this.hp = hp;
        this.atk = atk;
        this.coin = 0;
        this.exp = 0;
        this.distanceWalked = 0;
        this.strideLength = strideLength;
        this.pet = null;
        this.hasPetWhisperer = false;
        this.hasRespawnScroll = false;
        this.hasAbilitySummoner = false;
        this.mana = mana;
        this.level = 1;
        this.abilities = new Ability[2]; 
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getDistanceWalked() {
        return distanceWalked;
    }

    public void setDistanceWalked(int distanceWalked) {
        this.distanceWalked = distanceWalked;
    }

    public int getStrideLength() {
        return strideLength;
    }

    public boolean hasPetWhisperer() {
        return hasPetWhisperer;
    }

    public void setPetWhisperer(boolean hasPetWhisperer) {
        this.hasPetWhisperer = hasPetWhisperer;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public boolean hasRespawnScroll() {
        return hasRespawnScroll;
    }

    public void setRespawnScroll(boolean hasRespawnScroll) {
        this.hasRespawnScroll = hasRespawnScroll;
    }

    public boolean hasAbilitySummoner() {
        return hasAbilitySummoner;
    }

    public void setAbilitySummoner(boolean hasAbilitySummoner) {
        this.hasAbilitySummoner = hasAbilitySummoner;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Ability[] getAbilities() {
        return abilities;
    }

    public Ability getRandomAbility() {
        int randomIndex = (int) (Math.random() * abilities.length);
        return abilities[randomIndex];
    }

    public void addReward(int hp, int atk, int coin) {
        this.hp += hp;
        this.atk += atk;
        this.coin += coin;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

class Archer extends Heroes {
    public Archer() {
        super(70, 15, 5, 50);
    }

    @Override
    protected void initAbilities() {
        abilities[0] = new Ability("Arrow Rain", 25, 15);
        abilities[1] = new Ability("Power Shot", 35, 20);
    }
}

class Wizard extends Heroes {
    public Wizard() {
        super(50, 20, 4, 100);
    }

    @Override
    protected void initAbilities() {
        abilities[0] = new Ability("Fireball", 30, 20);
        abilities[1] = new Ability("Lightning Strike", 40, 25);
    }
}

class Warrior extends Heroes {
    public Warrior() {
        super(100, 10, 6, 30);
    }

    @Override
    protected void initAbilities() {
        abilities[0] = new Ability("Shield Bash", 20, 10);
        abilities[1] = new Ability("Sword Slash", 25, 15);
    }
}

class Assassin extends Heroes {
    public Assassin() {
        super(60, 25, 7, 50);
    }

    @Override
    protected void initAbilities() {
        abilities[0] = new Ability("Backstab", 40, 20);
        abilities[1] = new Ability("Shadow Strike", 35, 15);
    }
}