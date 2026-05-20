/**
 * Runner class to test and launch the Dungeon Crawler game.
 * Student Starter Code.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Initializing Dungeon Crawler...");
        
        // Instantiate a new Player
        Player player = new Player();
        
        // Create 3 ActionCards and add them to the Player's hand
        ActionCard strike = new ActionCard("Strike", 6, 0, 0);
        ActionCard shield = new ActionCard("Shield Up", 0, 8, 0);
        ActionCard heal = new ActionCard("Minor Heal", 0, 0, 5);
        
        player.addCardToHand(strike);
        player.addCardToHand(shield);
        player.addCardToHand(heal);
        
        // Instantiate the Deck and call buildDeck()
        Deck deck = new Deck();

        deck.buildDeck();
        // TODO: Call deck.shuffle() here once you have implemented it in Day 4

        deck.shuffle();
        // Instantiate the DungeonMap (5 rows, 5 columns)
        DungeonMap map = new DungeonMap(5, 5);
        
        // Instantiate the boss separately so it can be tied to a specific map location
        // Note: You will need to write the BossCard class on Day 4!
        BossCard boss = new BossCard("Dragon", "A massive fire-breathing beast.", 30, 8);
        
        // Launch the GUI GamePanel
        // NOTE: On Day 4, uncomment the boss instantiation above and replace 'null' with 'boss' below.
        GamePanel panel = new GamePanel(player, deck, map, boss);
        panel.showWindow();
        
        System.out.println("Setup complete. Ready to launch.");
    }
}