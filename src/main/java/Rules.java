public class Rules {
    private boolean validAttack(Game game, int row1, int column1,
                                int row2, int column2) {

    }
    public static boolean checkValidAction(Game game, int row1, int column1,
                                           int row2, int column2, char action) {
        if (game.getGameBoard().inBounds()) {
            if (!game.getBoardSquares()[row2][column2].isEmpty()) {

            }
        }
    }
}
