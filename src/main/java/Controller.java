import java.util.ArrayList;

public class Controller {
    private GameS22 game;
    private TextView viewer;

    //This method sets up our game with two teams that each have one piece of each type randomly placed on the board.
    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public Controller (){
        this.game = setUpGameModel();
        this.viewer = new TextView();
        TextView.updateView(game);
    }

    public void carryOutAction (int fromRow, int fromColumn, int toRow, int toColumn, char actionType){
        if (actionType == 'A'){
            ActionAttack actAttack = new ActionAttack(game, viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn());
            actAttack.performAction();
        }
        else if (actionType == 'S'){
            ActionSpawn actSpawn = new ActionSpawn(game, viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn());
            actSpawn.performAction();
        }
        else if (actionType == 'M'){
            ActionMove actMove = new ActionMove(game, viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn());
            actMove.performAction();
        }
        else if (actionType == 'R'){
            ActionRecruit actRecruit = new ActionRecruit(game, viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn());
            actRecruit.performAction();
        }
    }

    public void playGame (){
        boolean isGameOver = false;
        while(!isGameOver) {
            boolean isActionValid = false;
            while (!isActionValid) {
                viewer.getNextPlayersAction(game);
                if (Rules.checkValidAction(game, viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn(), viewer.getactionType())) {
                    isActionValid = true;
                }
            }
            carryOutAction(viewer.getfromRow(), viewer.getfromColumn(), viewer.gettoRow(), viewer.gettoColumn(), viewer.getactionType());
            TextView.updateView(game);
            if(game.isAWinner()){
                isGameOver = true;
            }
        }
        viewer.printEndOfGameMessage(game);
    }


    public static void main (String args[]){
        Controller ultimateControl = new Controller();
        ultimateControl.playGame();
    }
}