public abstract class Piece implements Comparable<Piece> {
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
    public abstract void speak();
    public abstract Piece spawn();
    public abstract boolean canSpawn();
    public abstract boolean validMovePath(int fromSquareRow,
                                          int fromSquareCol, int toSquareRow, int toSquareCol);
    public abstract boolean validSpawnPath(int fromSquareRow,
                                          int fromSquareCol, int toSquareRow, int toSquareCol);
    public char getSymbol() {
        return this.symbol;
    }
    public String getTeamColor() {
        return this.teamColor;
    }
    public boolean isHidden() {
        return this.hidden;
    }
    public boolean isOriginal() {
        return this.original;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }
    @Override
    public String toString() {
        return(this.getTeamColor() + " " + this.getSymbol());
    }
    @Override
    public int compareTo(Piece thePiece) {
        return Character.toString(symbol).compareTo(Character.toString(thePiece.symbol));
    }
}
