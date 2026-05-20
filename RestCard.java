/**
 * Subclass of Card representing a safe room that heals the player.
 * Teacher Solution (Identical to Starter).
 */
public class RestCard extends Card {
    private int healAmount;

    /**
     * Constructor for a RestCard.
     * @param healAmount The amount of HP to restore.
     */
    public RestCard(int healAmount) {
        super("Rest Site", "A quiet room with a campfire. Heal for " + healAmount + " HP.");
        this.healAmount = healAmount;
    }

    /**
     * Heals the player by the healAmount.
     * @param p The Player object.
     */
    @Override
    public void applyEffect(Player p) {
        System.out.println("You rest at the campfire.");
        p.heal(healAmount);
    }
}