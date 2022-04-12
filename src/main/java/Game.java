import java.util.Collections;
import java.util.Objects;

public class Game {
    private GameBoard board;
    private Team team1;
    private Team team2;
    private String turn;
    private void initializeGameBoard(int row, int col) {
        board = new GameBoard(row, col);
        for (Piece piece : team1.getTeamPieces()) {
            BoardSquare space = board.findRandomEmptySpace();
            space.setPiece(piece);
        }
        for (Piece piece : team2.getTeamPieces()) {
            BoardSquare space = board.findRandomEmptySpace();
            space.setPiece(piece);
        }
    }
    public Game (int row, int col, Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        turn = team1.getTeamColor();
        initializeGameBoard(row, col);
    }
    public GameBoard getGameBoard() {
        return this.board;
    }
    public Team getCurrentTeam() {
        if (Objects.equals(turn, team1.getTeamColor())) {
            return this.team1;
        }
        else {
            return this.team2;
        }
    }
    public Team getOpponentTeam() {
        if (Objects.equals(turn, team1.getTeamColor())) {
            return this.team2;
        }
        else {
            return this.team1;
        }
    }
    public boolean isTurn(Team team) {
        if (team == getCurrentTeam()) {
            return true;
        }
        else {
            return false;
        }
    }
    public BoardSquare[][] getBoardSquares() {
        return board.getSquares();
    }
    public void changeTurn() {
        this.turn = getOpponentTeam().getTeamColor();
    }
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }
}
