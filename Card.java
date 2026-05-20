public abstract class Card {
    private String name;
    private String description;

    /**
     * Constructor for a Card.
     * @param name The name of the card.
     * @param description The text description of the card.
     */
    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Abstract method that all subclasses must implement to define what
     * happens when the player encounters this card.
     * @param p The Player object.
     */
    public abstract void applyEffect(Player p);
}