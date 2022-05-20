public class BoardSquare {
    private boolean empty;
    private Piece onSquare;
    private String color;
    private boolean isUFO;

    public BoardSquare(String color) {
        this.color = color;
        this.empty = true;
        this.isUFO = false;
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
    public boolean getIsUFO(){ return this.isUFO; }
    public void setPiece(Piece newPiece) {
        this.onSquare = newPiece;
        this.empty = false;
    }

    // Board Square Modification
    public void setIsUFO(boolean isUFO){ this.isUFO = isUFO; }

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
