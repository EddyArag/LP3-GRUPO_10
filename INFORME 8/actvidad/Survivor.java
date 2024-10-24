public class Survivor {
    private int id;
    private String name;
    private String role; // Ejemplo: 'Leader', 'Medic', etc.
    private int health;

    public Survivor(int id, String name, String role, int health) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Survivor{" + "id=" + id + ", name='" + name + '\'' + ", role='" + role + '\'' + ", health=" + health + '}';
    }
}
