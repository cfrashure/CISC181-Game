public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;
    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }
}
