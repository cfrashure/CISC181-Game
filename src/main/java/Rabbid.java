/***
 * The Rabbid Piece represents the Rabbids from the Raving Rabbids franchise! This piece is quite similar to
 * minions and can spawn other rabbids. At any time, there can be up to three rabbids on the game board. Rabbids can
 * also Huddle and recruit up to four pieces that are left, right, above, or below them!
 */
public class Rabbid extends Piece implements Recruiter, Attacker, Huddler {
    protected  int numAttacks;
    protected int numTimesSpawned;
    protected int numRecruits;
    protected int numTimesHuddled;
    protected boolean huddledBefore;

    public static int MAX_NUM_SPAWNED = 3;

    public Rabbid(char symbol, String teamColor,
                  int numRecruits, int numAttacks, int numTimesSpawned, int numTimesHuddled,
                  boolean hidden, boolean original,boolean huddledBefore) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
        this.numTimesHuddled = numTimesHuddled;
        this.huddledBefore = huddledBefore;
    }

    public Rabbid() {
        this('R', "- -",0,
                0, 0, 0,
                false, true, false);
    }

    public int getNumRecruits() {
        return numRecruits;
    }

    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public int getNumTimesHuddled() {
        return numTimesHuddled;
    }

    public void setNumRecruits(int numRecruits) {numRecruits = this.numRecruits;}

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) { numAttacks = this.numAttacks;}

    public int getNumHuddle() {
        return this.numTimesHuddled;
    }

    public void setNumHuddle(int numTimesHuddled) { numTimesHuddled = this.numTimesHuddled;}

    @Override
    public void speak() {
        System.out.println("Bwahhhh!");
    }

    @Override
    public boolean validAttackPath(int rowDo, int columnDo, int rowBe, int columnBe) {
        int leftOne = columnDo - 1;
        int rightOne = columnDo + 1;
        if (columnBe == leftOne && rowDo == rowBe) {
            return true;
        }
        if (columnBe == rightOne && rowDo == rowBe) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean validRecruitPath(int rowDo, int columnDo, int rowBe, int columnBe) {
        //checks if the Rabbid is recruiting a square diagonal to itself
        int upOne = rowDo - 1;
        int downOne = rowDo + 1;
        int leftOne = columnDo - 1;
        int rightOne = columnDo + 1;
        if (columnBe == leftOne) {
            if (rowBe == upOne || rowBe == downOne) {
                return true;
            }
            return false;
        }
        if (columnBe == rightOne) {
            if (rowBe == upOne || rowBe == downOne) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean validMovePath ( int fromSquareRow, int fromSquareCol,int toSquareRow, int toSquareCol){
        int leftOne = fromSquareCol - 1;
        int rightOne = fromSquareCol + 1;
        if (toSquareCol == leftOne && fromSquareRow == toSquareRow) {
            return true;
        }
        if (toSquareCol == rightOne && fromSquareRow == toSquareRow) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        int downOne = fromSquareRow + 1;
        if(toSquareRow == downOne && fromSquareCol == toSquareCol) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean validHuddlePath(int rowDo, int columnDo,
                                            int rowBe, int columnBe){
        if(huddledBefore){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Rabbid spawn() {
        return new Rabbid(Character.toLowerCase(this.symbol),
                this.teamColor, 1,
                0,0, numTimesHuddled,
                false, false, huddledBefore);
    }

    @Override
    public boolean canSpawn () {
            return original && numTimesSpawned < MAX_NUM_SPAWNED;
        }
    }