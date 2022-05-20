public class PieceMinion extends Piece implements Recruiter {
    protected int numTimesSpawned;
    protected int numRecruits;

    public static int MAX_NUM_SPAWNED = 3;

    public PieceMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }

    public int getNumRecruits() {
        return numRecruits;
    }
    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowDo, int columnDo, int rowBe, int columnBe) {
        // same path as move
        if(columnDo != columnBe){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void speak(){
        System.out.println("Bello!");
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // any number of spaces up and down the column but no spaces across the row
        if (fromSquareCol != toSquareCol){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    @Override
    public PieceMinion spawn(){
        return new PieceMinion(Character.toLowerCase(this.symbol),
                this.teamColor,1,
                0,
                false,
                false);
    }
    @Override
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

}