public class ActionSpawn extends Action{
    public ActionSpawn(GameS22 game, int fromRow, int fromCol, int toRow, int toCol){
        super(game, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction(){
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        boolean isSpecial = Game22.getGameBoard().getSquares()[toRow][toCol].getIsUFO();
        thePiece.speak();

        if (isSpecial){
            System.out.println("You landed on the UFO square!");
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setIsUFO(false);
            this.Game22.getGameBoard().getSquares()[fromRow][fromCol].removePiece();
            this.Game22.getGameBoard().findRandomEmptySpace().setPiece(thePiece);
        }
        else {
            Piece spawned = thePiece.spawn(); //not sure why get current team not working
            this.Game22.getCurrentTeam().addPieceToTeam(spawned);
            this.Game22.getGameBoard().getSquares()[toRow][toCol].setPiece(spawned);
        }
    }
    // New Rule Modification (the lack of the changeTeam call is the new rule)
}