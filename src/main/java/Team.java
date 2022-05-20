import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Piece> teamPieces;
    public Team(String teamColor, ArrayList<Piece> teamPieces) {
        this.teamColor = teamColor;
        this.teamPieces = teamPieces;
    }
    public String getTeamColor() {
        return this.teamColor;
    }
    public ArrayList<Piece> getTeamPieces() {
        return this.teamPieces;
    }
    public void removePieceFromTeam(Piece pieceToRemove) {
        teamPieces.remove(pieceToRemove);
    }
    public void addPieceToTeam(Piece pieceToAdd) {
        pieceToAdd.setTeamColor(this.teamColor);
        teamPieces.add(pieceToAdd);
    }
    @Override
    public String toString() {
        StringBuilder total = new StringBuilder(("Team " + teamColor + " Pieces:\n"));
        for(Piece piece : teamPieces) {
            total.append(piece.toString()).append(" ");
        }
    return total.toString();
    }
}
