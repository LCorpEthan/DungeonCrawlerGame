import javax.swing.JOptionPane;

/**
 * Subclass of Card representing a combat encounter.
 * Student Starter Code.
 */
public class MonsterCard extends Card {
    private int hp;
    private int attackDamage;

    public MonsterCard(String name, String description, int hp, int attackDamage) {
        super(name, description);
        this.hp = hp;
        this.attackDamage = attackDamage;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
    
    public void takeDamage(int amount) {
        this.hp -= amount;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    @Override
    public void applyEffect(Player p) {
        JOptionPane.showMessageDialog(null, "Combat initiated with " + getName() + "!");
        
        while (this.hp > 0 && p.getHp() > 0) {
            // 1. Player's Turn
            String prompt = "Enemy: " + getName() + " (" + this.hp + " HP)\n"
                          + "Your HP: " + p.getHp() + "\n\n"
                          + "Your Hand:\n" + p.getHandAsString()
                          + "\nEnter the number of the Action Card you want to play:";
                          
            String input = JOptionPane.showInputDialog(null, prompt);
            
            int cardIndex = -1;
            try {
                cardIndex = Integer.parseInt(input);
            } catch (Exception e) {
                // Caught invalid input.
            }
            
            ActionCard playedCard = p.getCard(cardIndex);
            int block = 0;
            
            if (playedCard != null) {
                JOptionPane.showMessageDialog(null, "You played: " + playedCard.getName() + "!");
                
                // TODO: Apply the playedCard's damage to this monster.
                this.takeDamage(playedCard.getDamage());
                
                // TODO: Apply the playedCard's healing to the player p.
                p.heal(playedCard.getHeal());
                
                // TODO: Set the 'block' variable equal to the playedCard's block value.
                block = playedCard.getBlock();
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. You fumbled and missed your turn!");
            }
            
            // 2. Monster's Turn
            if (this.hp > 0) {
                // TODO: Calculate damageTaken by subtracting 'block' from 'this.attackDamage'.
                // IMPORTANT: Make sure damageTaken does not go below 0.
                int damageTaken = this.attackDamage - block;
                if(damageTaken < 0){
                    damageTaken = 0;
                }
                
                // TODO: Apply the damageTaken to the player p.
                p.takeDamage(damageTaken);
                
                JOptionPane.showMessageDialog(null, getName() + " attacks for " + this.attackDamage + " damage!\n" 
                                                  + "You blocked " + block + ", taking " + damageTaken + " actual damage.");
            }
        }
        
        if (p.getHp() > 0) {
            JOptionPane.showMessageDialog(null, "You defeated the " + getName() + "!");
        } else {
            JOptionPane.showMessageDialog(null, "You were defeated by the " + getName() + "...");
        }
    }

    @Override
    public String toString() {
        // TODO: Use String concatenation to return a formatted string 
        // with the name, hp, attackDamage, and description.
        return getName() + " " + this.hp + " " + this.attackDamage + " " + getDescription();
    }
}