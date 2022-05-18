public class PieceSpanishBuzz extends PieceBuzz {
    public PieceSpanishBuzz(char symbol, String teamColor, int numAttacks,
                            int numTimesBeenAttacked, boolean workingLaser,
                            boolean hidden, boolean original) {
        super(symbol, teamColor, numAttacks, numTimesBeenAttacked, workingLaser,
                hidden, original);
    }
    public PieceSpanishBuzz(){
        super('S',"- -",
                0,0,
                true, false, true);
    }
    @Override
    public void speak() {
        System.out.println("¡Al infinito y más allá!");
    }
    // New Extended Piece modification
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        float slope;
        if (toSquareCol > fromSquareCol) {
            slope = ((float)(toSquareRow - fromSquareRow))/((float)(toSquareCol - fromSquareCol));
        }
        else {
            slope = ((float)(fromSquareRow - toSquareRow))/((float)(fromSquareCol - toSquareCol));
        }
        return (slope == 1.0 || slope ==  -1.0);
    }
}
