public class ActionMove extends Action{
    public ActionMove(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }
    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        boolean isSpecial = Game22.getGameBoard().getSquares()[toRow][toCol].getIsUFO();

        if (isSpecial){
            System.out.println("You landed on the UFO square!");
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setIsUFO(false);
            this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            this.Game22.getGameBoard().findRandomEmptySpace().setPiece(thePiece);
        }
        else {
            thePiece.speak();
            this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(thePiece);
        }
        this.Game22.changeTurn();
    }

}