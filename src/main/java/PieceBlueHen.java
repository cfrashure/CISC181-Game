public class PieceBlueHen extends Piece implements Attacker, Recruiter {
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen(char symbol,
                        String teamColor,
                        int numAttacks, int numRecruits,
                        boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen() {
        this('H', "NON",
                0, 0,
                false, true);
    }


    public int getNumAttacks() {
        return this.numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    public boolean canFly() {
        return this.flies;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int rowDo, int columnDo, int rowBe, int columnBe) {
        int upOne = rowDo - 1;
        int downOne = rowDo + 1;

        //if can't fly, will move one space left or right
        if (!canFly()) {
            if (rowBe == upOne && columnBe == columnDo) {
                return true;
            }
            if (rowBe == downOne && columnBe == columnDo) {
                return true;
            } else {
                return false;
            }
        }
        //if can fly
        else {
            return true;
        }
    }


    @Override
    public boolean validAttackPath(int rowDo, int columnDo, int rowBe, int columnBe) {
        int leftOne = columnDo - 1;
        int rightOne = columnDo + 1;

        //if can't fly, will move one space left or right
        if (!canFly()) {
            if (columnBe == leftOne && rowBe == rowDo) {
                return true;
            }
            if (columnBe == rightOne && rowBe == rowDo) {
                return true;
            } else {
                return false;
            }
        }
        //if can fly
        else {
            return true;
        }
    }

    @Override
    public boolean validSpawnPath(int fromSquareRow, int fromSquareCol,
                                  int toSquareRow, int toSquareCol) {
        int upOne = fromSquareRow - 1;
        int downOne = fromSquareRow + 1;
        int leftOne = fromSquareCol - 1;
        int rightOne = fromSquareCol + 1;

        if (!canFly()) {
            if (toSquareCol == leftOne) {
                if (toSquareRow == upOne || toSquareRow == downOne) {
                    return true;
                }
            }
            if (toSquareCol == rightOne) {
                if (toSquareRow == upOne || toSquareRow == downOne) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        //if can fly
        else {
            return true;
        }
        return true;
    }


    private void updateFly()    {
        if (this.numAttacks < MAX_NUM_ATTACKS){
            this.flies = true;
        }
        else {
            this.flies = false;
        }
    }
    public void speak(){
        System.out.println("Go UD!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // if can fly: anywhere on board
        // if can’t fly: one space in any direction including diagonally
        int upOne = fromSquareRow - 1;
        int downOne = fromSquareRow + 1;
        int leftOne = fromSquareCol - 1;
        int rightOne = fromSquareCol + 1;

        if(!canFly()){
            if(toSquareCol == leftOne){
                if(toSquareRow == upOne || toSquareRow == downOne){
                    return true;
                }
                return true;
            }
            if(toSquareCol == rightOne){
                if(toSquareRow == upOne || toSquareRow == downOne){
                    return true;
                }
                return true;
            }
            if(toSquareRow == upOne || toSquareRow == downOne){
                return true;
            }
            else{
                return false;
            }
        }
        //if can fly
        else {
            return true;
        }
    }

    public PieceBlueHen spawn() {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    public boolean canSpawn(){
        return true;
    }
}