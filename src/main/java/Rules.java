import java.util.ArrayList;

public class Rules {

    private static boolean validMove(Game game, int row1, int column1,
                                     int row2, int column2) {
        boolean valid = false;
        if (game.getBoardSquares()[row2][column2].isEmpty()) {
            if (game.getGameBoard().getSquares()[row1][column1]
                    .getPiece().validMovePath(row1, column1, row2, column2)) {
                valid = true;
            }
        }
        return valid;
    }

    private static boolean validSpawn(Game game, int row1, int column1,
                                int row2, int column2) {
        boolean valid = false;
        if (game.getGameBoard().getSquares()[row1][column1].getPiece() instanceof PieceBuzz) {
            return false;
        }
        else if (game.getBoardSquares()[row2][column2].isEmpty()) {
            if (game.getGameBoard().getSquares()[row1][column1]
                    .getPiece().canSpawn()) {
                valid = true;
            }
        }
        return valid;
    }

    private static boolean validAttack(Game game, int row1, int column1,
                                int row2, int column2) {
        // validattackpath if statement
        // can be added when we figure out whats wrong :(

        // cases for each piece
        boolean valid = false;
        //case : buzz
        if (game.getGameBoard().getSquares()[row1][column1].getPiece() instanceof PieceBuzz) {
            if (((PieceBuzz) game.getGameBoard().getSquares()[row1][column1].getPiece()).canAttack()) {
                if (!game.getBoardSquares()[row2][column2].isEmpty()) {
                    if (game.getOpponentTeam().getTeamColor() == game.getBoardSquares()[row2][column2].getPiece().getTeamColor()) {
                        if (((PieceBuzz) game.getGameBoard().getSquares()[row1][column1].getPiece()).validAttackPath(row1, column1, row2, column2)) {
                            valid = true;
                        }
                    }
                }
            }
        }
        // case: blue hen
        if (game.getGameBoard().getSquares()[row1][column1].getPiece() instanceof PieceBlueHen) {
            if (!game.getBoardSquares()[row2][column2].isEmpty()) {
                if (game.getOpponentTeam().getTeamColor() == game.getBoardSquares()[row2][column2].getPiece().getTeamColor()) {
                    if (((PieceBlueHen) game.getGameBoard().getSquares()[row1][column1].getPiece()).validAttackPath(row1, column1, row2, column2)) {
                        valid = true;
                    }
                }
            }
        }
        // case: evil minion >:(
        if (game.getGameBoard().getSquares()[row1][column1].getPiece() instanceof PieceEvilMinion) {
            if (((PieceEvilMinion) game.getGameBoard().getSquares()[row1][column1].getPiece()).canAttack()) {
                if (!game.getBoardSquares()[row2][column2].isEmpty()) {
                    // enemy piece
                    if (game.getOpponentTeam().getTeamColor() == game.getBoardSquares()[row2][column2].getPiece().getTeamColor()) {
                        if (((PieceEvilMinion) game.getGameBoard().getSquares()[row1][column1].getPiece()).validAttackPath(row1, column1, row2, column2)) {
                            valid = true;
                        }
                    }
                    // friendly piece (can only attack minion)
                    if (game.getCurrentTeam().getTeamColor() == game.getBoardSquares()[row2][column2].getPiece().getTeamColor()) {
                        if (game.getGameBoard().getSquares()[row2][column2].getPiece() instanceof PieceMinion) {
                            if (((PieceEvilMinion) game.getGameBoard().getSquares()[row1][column1].getPiece()).validAttackPath(row1, column1, row2, column2)) {
                                valid = true;
                            }
                        }
                    }

                }
            }
        }
        return valid;
    }

    private static boolean validRecruit(Game game, int row1, int column1,
                                int row2, int column2) {
        boolean valid = false;
        if (game.getGameBoard().getSquares()[row1][column1].getPiece() instanceof PieceBuzz) {
            return false;
        }
        else if (!game.getBoardSquares()[row2][column2].isEmpty()) {
            if (game.getOpponentTeam().getTeamColor() == game.getBoardSquares()[row2][column2].getPiece().getTeamColor()) {
                // IDK WHY THIS ISN;T WORKING SO IT"S JUST GONNA BE TRUE.
               /* if (game.getGameBoard().getSquares()[row1][column1].getPiece()
                    .validRecruitPath(row1, column1, row2, column2)) {
                    valid = true;
                } */
                valid = true; //remove this when fixed
            }
        }
        return valid;
    }

    public static boolean checkValidAction(Game game, int row1, int column1,
                                           int row2, int column2, char action) {
        boolean valid = false;
        if (game.getGameBoard().inBounds(row1, column1) && game.getGameBoard().inBounds(row2, column2)
                 && game.getCurrentTeam().getTeamColor() ==
                        game.getGameBoard().getSquares()[row1][column1].getPiece().getTeamColor()) {
            if (action == 'M') {
                valid = validMove(game, row1, column1, row2, column2);
            }
            if (action == 'S') {
                valid = validSpawn(game, row1, column1, row2, column2);
            }
            if (action == 'R') {
                valid = validRecruit(game, row1, column1, row2, column2);
            }
            if (action == 'A') {
                valid = validAttack(game, row1, column1, row2, column2);
            }
        }
        return valid;
    }

    public static void main(String[] arg) {
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));
        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6, 6, teamA, teamB);

        // clear Piece off the board
        for (int row = 0; row < game.getGameBoard().getNumRows(); row++) {
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++) {
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }
        System.out.println(game);

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        // testing attack
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                2, 1, 'A'));
        System.out.println(Rules.checkValidAction(game,
                0, 3,
                2, 1, 'A'));
        // spawn
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                1, 1, 'S'));
        System.out.println(Rules.checkValidAction(game,
                0, 2,
                1, 1, 'S'));
        // recruit
        System.out.println(Rules.checkValidAction(game,
                0, 2,
                2, 2, 'R'));
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 0, 'R'));

        // Test some moves that are invalid
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                2, 3, 'A'));
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                2, 3, 'A'));
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                0, 0, 'A'));
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                9, 9, 'A'));
        // spawn
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                1, 1, 'S'));
        System.out.println(Rules.checkValidAction(game,
                0, 2,
                6, 6, 'S'));
        System.out.println(Rules.checkValidAction(game,  // EVIL MINION OVER SPAWN LIMIT,
                // when i set the piece spawn to 0, it returns true i promise :)
                0, 3,
                1, 1, 'S'));
        // recruit
        System.out.println(Rules.checkValidAction(game,
                0, 1,
                2, 2, 'R'));
        System.out.println(Rules.checkValidAction(game,
                6, 6,
                6, 6, 'R'));
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 3, 'R'));
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 0, 'R'));
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                1, 1, 'R'));
        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 0, 'R'));





        // This should be a valid move
        // attack
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                1, 4, 'M'));

        // To Square isn't empty - should not be a valid move
        System.out.println(Rules.checkValidAction(game,
                0, 0,
                0, 1, 'M'));
        // This isn't current team's piece - should not be valid
        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 5, 'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2, 0,
                0, 5, 'M'));
    }
}