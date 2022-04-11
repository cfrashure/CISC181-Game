public class GameBoard {
    private int row;
    private int col;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.row = numRows;
        this.col = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        this.setUpEmptyBoard();
    }
    public int getNumRows() {
        return this.row;
    }
    public int getNumColumns() {
        return this.col;
    }
    public BoardSquare[][] getSquares() {
        return this.squares;
    }
    public boolean inBounds(int row, int col) {
        return(squares[row][col] != null);
    }
    private void setUpEmptyBoard() {
        int count = 1;
        for (BoardSquare[] squareRow : squares) {
            for (BoardSquare square : squareRow) {
                if (count%2==0) {
                    square = new BoardSquare("Black");
                }
                else {
                    square = new BoardSquare("White");
                }
                count++;
            }
        }
    }
    public BoardSquare findRandomEmptySpace() {
        boolean found = false;
        BoardSquare randomSquare = null;
        while (!found) {
            randomSquare = squares[(int) (Math.random() * row)]
                    [(int) (Math.random() * col)];
            if(randomSquare.isEmpty()) {
                found = true;
            }
        }
        return randomSquare;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
