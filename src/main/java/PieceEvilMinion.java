import static java.lang.Character.toLowerCase;

public class PieceEvilMinion extends PieceMinion{
    private int numAttacks;
    private boolean hungry;
    public static int MAX_NUM_SPAWNED = 3;
    public static int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits,
                           int numAttacks, int numTimesSpawned, boolean hidden,
                           boolean original) {
        super(symbol, teamColor, numRecruits, numTimesSpawned, hidden, original);
        this.numAttacks = numAttacks;
        updateHungry();
    }
    public PieceEvilMinion() {
        super('E', "NON", 0, 0,
                false ,true );
        this.numAttacks = 0;
    }
    public boolean canAttack() {
        return (this.hungry && this.numAttacks < MAX_NUM_ATTACKS);
    }
    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }
    public void setNumTimesSpawned(int newNum) {
        super.numTimesSpawned = newNum;
    }
    public void updateHungry() {
       if(this.numAttacks < MAX_NUM_ATTACKS) {
           this.hungry = true;
       }
    }
    @Override
    public void speak() {
        System.out.println("Roar!");
    }
    public boolean validMovePath() {
        return true;
    }
    @Override
    public PieceEvilMinion spawn() {
        PieceEvilMinion evilMinion = new PieceEvilMinion();
        evilMinion.symbol = toLowerCase(this.symbol);
        evilMinion.teamColor = this.getTeamColor();
        evilMinion.numRecruits = 1;
        evilMinion.numAttacks = 0;
        evilMinion.numTimesSpawned = 0;
        evilMinion.hidden = false;
        evilMinion.original = true;
        evilMinion.hungry = true;
        this.setNumTimesSpawned(this.numTimesSpawned+1);
        return evilMinion;
    }
}
