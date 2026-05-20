
/**
 * Write a description of class TreasureCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TreasureCard extends Card
{
    private int goldAmount;
    private ActionCard rewardCard;
    public TreasureCard(int goldAmount, ActionCard rewardCard)
    {
        super("Treasure Chest", "A treasure chest with some rewards.");
        this.goldAmount = goldAmount;
        this.rewardCard = rewardCard;
    }

    public void applyEffect(Player P){
        P.addGold(goldAmount);
        if(rewardCard!=null){
            P.addCardToHand(rewardCard);
        }
    }

}
