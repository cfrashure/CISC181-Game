public class ActionAttack extends Action{
    public ActionAttack(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        Piece attacked = this.Game22.getGameBoard().getSquares()[toRow][toCol].getPiece();
        if((thePiece instanceof PieceEvilMinion) && (attacked instanceof PieceMinion)){
            //make a spawnable Minion piece
            Piece spawned = thePiece.spawn();
            thePiece.speak();
            this.Game22.getGameBoard().getSquares()[toRow][toCol].removePiece();
            this.Game22.getCurrentTeam().removePieceFromTeam(attacked);
            this.Game22.getCurrentTeam().addPieceToTeam(spawned);
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(spawned);
            this.Game22.changeTurn();
        }
        else{
            thePiece.speak();
            this.Game22.getGameBoard().getSquares()[toRow][toCol].removePiece();
            this.Game22.getOpponentTeam().removePieceFromTeam(attacked);
            //move the piece on the from square to the to square
            this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(thePiece);
            this.Game22.changeTurn();
        }
    }
}