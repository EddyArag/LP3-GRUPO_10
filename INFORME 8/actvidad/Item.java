public class Item {
    private int id;
    private String name;
    private String effect; // Ejemplo: 'Heals', 'Boosts Stamina'

    public Item(int id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", effect='" + effect + '\'' + '}';
    }
}
