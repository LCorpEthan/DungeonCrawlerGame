import java.util.ArrayList;

/**
 * Manages the dungeon deck of Room Cards.
 * Student Starter Code.
 */
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    /**
     * Populates the deck with initial cards. Fully provided.
     */
    public void buildDeck() {
        cards.add(new RestCard(10));
        cards.add(new RestCard(15));
        
        // Note: You must write TreasureCard and TrapCard before these lines compile!
        cards.add(new TreasureCard(50, new ActionCard("Fireball", 8, 0, 0)));
        cards.add(new TreasureCard(25, new ActionCard("Heavy Shield", 0, 8, 0)));
        cards.add(new TreasureCard(50, new ActionCard("Thunderbolt", 10, 0, 0)));
        cards.add(new TreasureCard(25, new ActionCard("Bloodletting", 20, 0, -5)));
        cards.add(new TreasureCard(25, new ActionCard("Blessing", 0, 6, 15)));
        cards.add(new TreasureCard(0, new ActionCard("Caliburn", 14, 3, 2)));
        cards.add(new TreasureCard(50, new ActionCard("Broadsword", 6, 5, 0)));
        cards.add(new TreasureCard(0, new ActionCard("Aegis", 0, 12, 0)));
        
        
        
        
        cards.add(new TrapCard("Poison Dart", "A hidden dart shoots from the wall.", 5));
        cards.add(new TrapCard("Quicksand pit", "The floor sinks in.", 3));
        
        cards.add(new MonsterCard("Skeleton", "A boney enemy.", 7, 5));
        cards.add(new MonsterCard("Goblin", "A sneaky green menace.", 8, 3));
        cards.add(new MonsterCard("Zombie", "An undead walking.", 7, 4));
        cards.add(new MonsterCard("Skeleton", "A boney enemy.", 7, 5));
        cards.add(new MonsterCard("Goblin", "A sneaky green menace.", 8, 3));
        cards.add(new MonsterCard("Zombie", "An undead walking.", 7, 4));
        cards.add(new MonsterCard("Skeleton", "A boney enemy.", 7, 5));
        cards.add(new MonsterCard("Goblin", "A sneaky green menace.", 8, 3));
        cards.add(new MonsterCard("Zombie", "An undead walking.", 7, 4));
        cards.add(new MonsterCard("Skeleton", "A boney enemy.", 7, 5));
        cards.add(new MonsterCard("Goblin", "A sneaky green menace.", 8, 3));
        cards.add(new MonsterCard("Zombie", "An undead walking.", 7, 4));
    }

    /**
     * Randomizes the order of the cards in the ArrayList.
     */
    public void shuffle() {
        // TODO: Implement shuffling logic using Math.random() or java.util.Collections
        for(int i=0; i<cards.size(); i++){
            int random = (int)(cards.size()*Math.random());
            cards.add(random, cards.remove(i));
        }
    }

    /**
     * Removes and returns the top card from the deck.
     */
    public Card drawCard() {
        // TODO: Remove and return the card at index 0. Return null if empty.
        if(cards.size() <= 0){
            return null;
        }else{
            return cards.remove(0);
        }
    }

    /**
     * Checks if the deck is empty.
     */
    public boolean isEmpty() {
        // TODO: Return true if the deck size is 0, false otherwise.
        if(cards.size()==0){
            return true;
        }
        return false;
    }

    /**
     * Returns the current number of cards in the deck.
     */
    public int size() {
        // TODO: Return the size of the ArrayList.
        return cards.size();
    }
}