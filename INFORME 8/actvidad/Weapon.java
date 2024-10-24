public class Weapon {
    private int id;
    private String name;
    private String type; // Ejemplo: 'Rifle', 'Shotgun', 'Melee'
    private int damage;

    public Weapon(int id, String name, String type, int damage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Weapon{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + ", damage=" + damage + '}';
    }
}
