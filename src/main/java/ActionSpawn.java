public class ActionSpawn extends Action{
    public ActionSpawn(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        thePiece.speak();
        Piece spawned = thePiece.spawn(); //not sure why get current team not working
        this.Game22.getCurrentTeam().addPieceToTeam(spawned);
        this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(spawned);
    }
}