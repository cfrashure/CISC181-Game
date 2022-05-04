public class ActionRecruit extends Action{
    public ActionRecruit(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        thePiece.speak();
        Piece recruited = this.Game22.getGameBoard().getSquares()[toRow][toCol].getPiece();
        this.Game22.getOpponentTeam().removePieceFromTeam(recruited);
        this.Game22.getCurrentTeam().addPieceToTeam(recruited);
        this.Game22.changeTurn();
    }
}