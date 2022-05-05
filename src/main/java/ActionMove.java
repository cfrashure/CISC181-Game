public class ActionMove extends Action{
    public ActionMove(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }
    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        thePiece.speak();
        this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
        this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(thePiece);

        /**this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece().speak();
         this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
         this.Game22.getGameBoard().getSquares()[toRow][toCol].getPiece().setSquares()[][];
         this.Game22.changeTurn();
         *
         */
    }
}