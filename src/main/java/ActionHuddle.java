// New Action Modification

public class ActionHuddle extends Action {
    public ActionHuddle(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        super(Game22, fromRow, fromCol, toRow, toCol);
    }

    @Override
    public void performAction(){
        System.out.println("!");
        int upOne = fromRow - 1;
        int downOne = fromRow + 1;
        int leftOne = fromCol - 1;
        int rightOne = fromCol + 1;

        //create piece for from square piece
        Piece thePiece = this.Game22.getGameBoard().getSquares()[fromRow][fromCol].getPiece();
        thePiece.speak();

        //recruit upOne piece
        if(!this.Game22.getGameBoard().getSquares()[upOne][fromCol].isEmpty()){
            Piece recruited1 = this.Game22.getGameBoard().getSquares()[upOne][fromCol].getPiece();
            this.Game22.getOpponentTeam().removePieceFromTeam(recruited1);
            this.Game22.getCurrentTeam().addPieceToTeam(recruited1);
        }

        //recruit downOne piece
        if(!this.Game22.getGameBoard().getSquares()[downOne][fromCol].isEmpty()){
            Piece recruited2 = this.Game22.getGameBoard().getSquares()[downOne][fromCol].getPiece();
            this.Game22.getOpponentTeam().removePieceFromTeam(recruited2);
            this.Game22.getCurrentTeam().addPieceToTeam(recruited2);
        }

        //recruit leftOne piece
        if(!this.Game22.getGameBoard().getSquares()[fromRow][leftOne].isEmpty()){
            Piece recruited3 = this.Game22.getGameBoard().getSquares()[fromRow][leftOne].getPiece();
            this.Game22.getOpponentTeam().removePieceFromTeam(recruited3);
            this.Game22.getCurrentTeam().addPieceToTeam(recruited3);
        }

        //recruit rightOne piece
        if(!this.Game22.getGameBoard().getSquares()[fromRow][rightOne].isEmpty()){
            Piece recruited4 = this.Game22.getGameBoard().getSquares()[fromRow][rightOne].getPiece();
            this.Game22.getOpponentTeam().removePieceFromTeam(recruited4);
            this.Game22.getCurrentTeam().addPieceToTeam(recruited4);
        }

        //change turn
        this.Game22.changeTurn();
    }
}
