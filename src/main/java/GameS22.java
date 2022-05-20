public class GameS22 extends Game {
    public GameS22(int row, int col, Team team1, Team team2) {
        super(row, col, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        // New Objective Modification
        int numBuzz = 0;
        for (Piece piece : getCurrentTeam().getTeamPieces()){
            if (piece instanceof PieceBuzz){
                numBuzz++;
            }
        }
        //returns true(there is a winner) if team has no Buzz or no pieces
        if (this.getCurrentTeam().getTeamPieces().size() <= 0 && this.getCurrentTeam().getTeamPieces().size() > 0) {
            return true;
        }
        else if (numBuzz <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Team getWinner() {
        if (this.isAWinner()) {
            return getOpponentTeam();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isGameEnded() {
        return ((getCurrentTeam().getTeamPieces().size() == 0) ||
                (getOpponentTeam().getTeamPieces().size() == 0));
    }
}