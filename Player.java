import java.util.ArrayList;

/**
 * Represents the adventurer playing the game.
 * Student Starter Code.
 */
public class Player {
    private int hp;
    private int maxHp;
    private int gold;
    private ArrayList<ActionCard> hand;

    /**
     * Constructor for Player. Initializes stats and empty hand.
     */
    public Player() {
        this.maxHp = 30;
        this.hp = this.maxHp;
        this.gold = 0;
        this.hand = new ArrayList<ActionCard>();
    }

    public int getHp() { return hp; }
    public int getGold() { return gold; }

    /**
     * Increases the player's gold.
     * @param amount The amount of gold to add.
     */
    public void addGold(int amount) {
        // TODO: Implement logic to increase gold
        gold += amount;
    }

    /**
     * Heals the player, ensuring HP does not exceed maxHp.
     * @param amount The amount to heal.
     */
    public void heal(int amount) {
        // TODO: Implement healing logic
        hp += amount;
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    /**
     * Reduces player HP by the damage amount. Prevents HP from dropping below 0.
     * @param amount The damage taken.
     */
    public void takeDamage(int amount) {
        // TODO: Implement damage logic
        hp -= amount;
        if(hp < 0){
            hp = 0;;
        }
    }

    /**
     * Adds an ActionCard to the player's hand.
     * @param a The ActionCard to add.
     */
    public void addCardToHand(ActionCard a) {
        // TODO: Implement ArrayList add logic
        hand.add(a);
    }

    /**
     * Removes an ActionCard from the player's hand by index.
     * @param index The index of the card to remove.
     */
    public void removeCardFromHand(int index) {
        // TODO: Implement ArrayList remove logic
        if(!(index >= hand.size())){
            hand.remove(index);
        }
    }

    /**
     * Returns an ActionCard from the hand based on index.
     * Fully provided. Required for interactive combat.
     */
    public ActionCard getCard(int index) {
        if (index >= 0 && index < hand.size()) {
            return hand.get(index);
        }
        return null;
    }

    /**
     * Builds and returns a formatted String of all cards currently in the hand.
     * @return A formatted String list of ActionCards.
     */
    public String getHandAsString() {
        // TODO: Implement ArrayList traversal and String formatting.
        // Example output format: "0: Strike [DMG: 6 | BLK: 0 | HEAL: 0]\n"
        String thingy = "";
        for(int i=0; i < hand.size(); i++){
            ActionCard temp = hand.get(i);
            thingy += i + ": " + temp.getName() + " " + "[DMG: " + temp.getDamage() + " | BLK: " + temp.getBlock() + " | HEAL: " + temp.getHeal() + " ] \n";
        }
        return thingy;
    }
}