public class Player extends GameObject {
    private String name;
    private int health;

    public Player(String name, int x, int y, Collidable collider, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String n = name == null ? "" : name.trim();
        if (n.isEmpty()) {
            throw new IllegalArgumentException("Ime igrača je obavezno.");
        }
        String first = n.substring(0, 1).toUpperCase();
        String rest = n.length() > 1 ? n.substring(1) : "";
        this.name = first + rest;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti u opsegu 0-100.");
        }
        this.health = health;
    }

    public void applyDamage(int amount) {
        if (amount < 0) {
            return;
        }
        int newHealth = this.health - amount;
        if (newHealth < 0) {
            newHealth = 0;
        }
        this.health = newHealth;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player[name=" + name + ", health=" + health + ", x=" + getX() + ", y=" + getY() + ", collider=" + getCollider() + "]";
    }
}

