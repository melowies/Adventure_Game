public abstract class Pets {
    protected int atk;

    public Pets(int atk) {
        this.atk = atk;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}

class Fox extends Pets {
    public Fox() {
        super(5);
    }
}

class Snake extends Pets {
    public Snake() {
        super(7);
    }
}

class Wolf extends Pets {
    public Wolf() {
        super(10);
    }
}

class Turtle extends Pets {
    public Turtle() {
        super(4);
    }
}