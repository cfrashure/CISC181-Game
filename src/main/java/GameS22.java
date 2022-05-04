public class GameS22 extends Game {
    public GameS22(int row, int col, Team team1, Team team2) {
        super(row, col, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        if (this.getCurrentTeam().getTeamPieces().size() == 0 &&
                this.getOpponentTeam().getTeamPieces().size() >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Team getWinner() {
        if (this.isAWinner()) {
            return getCurrentTeam();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isGameEnded() {
        return (getCurrentTeam().getTeamPieces().size() == 0 ||
                getOpponentTeam().getTeamPieces().size() == 0);
        }
}
