/**
 * Represents a move the player can use during combat.
 * Teacher Solution (Identical to Starter).
 */
public class ActionCard {
    private String name;
    private int damage;
    private int block;
    private int heal;

    public ActionCard(String name, int damage, int block, int heal) {
        this.name = name;
        this.damage = damage;
        this.block = block;
        this.heal = heal;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getBlock() {
        return block;
    }

    public int getHeal() {
        return heal;
    }

    public String toString() {
        return name + " [DMG: " + damage + " | BLK: " + block + " | HEAL: " + heal + "]";
    }
}