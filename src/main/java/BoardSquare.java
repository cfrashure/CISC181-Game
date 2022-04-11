public class BoardSquare {
    private boolean empty;
    private Piece onSquare;
    private String color;

    public BoardSquare(String color) {
        this.color = color;
        this.empty = true;
    }
    public Piece getPiece() {
        return this.onSquare;
    }
    public boolean isEmpty() {
        return this.empty;
    }
    public String getSquareColor() {
        return this.color;
    }
    public void setPiece(Piece newPiece) {
        this.onSquare = newPiece;
        this.empty = false;
    }
    public Piece removePiece() {
        Piece type = this.onSquare;
        this.onSquare = null;
        this.empty = true;
        return type;
    }

    @Override
    public String toString() {
        if (this.empty) {
            return "-------";
        }
        else {
            return "-" + onSquare.toString() + "-";
        }
    }
}
