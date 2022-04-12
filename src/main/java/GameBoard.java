public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    protected GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows(){
        return numRows;
    }

    public int getNumColumns(){
        return numColumns;
    }

    public BoardSquare[][] getSquares(){
        return squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex){
        if ((rowIndex >= 0) && (columnIndex >= 0)) {
            if ((rowIndex < this.numRows) && (columnIndex < this.numColumns)) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    private void setUpEmptyBoard() {
        int count = 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (count%2==0) {
                    squares[i][j] = new BoardSquare("White");
                }
                else {
                    squares[i][j] = new BoardSquare("Black");
                }
                count++;
            }
        }
    }

    public BoardSquare findRandomEmptySpace() {
        boolean found = false;
        BoardSquare randomSquare = null;
        while (!found) {
            randomSquare = squares[(int) (Math.random() * numRows)]
                    [(int) (Math.random() * numColumns)];
            if(randomSquare.isEmpty()) {
                found = true;
            }
        }
        return randomSquare;
    }

    public String toString(){
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