
public class TrapCard extends Card
{
    private int damageAmount;
    public TrapCard(String name, String description, int damageAmount)
    {
        super(name, description);
        this.damageAmount = damageAmount;
    }

    public void applyEffect(Player P)
    {
        P.takeDamage(damageAmount);
    }
}
