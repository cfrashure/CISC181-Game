import java.util.Scanner;

public class TextView {
    //member fields
    private int fromRow;
    private int fromColumn;
    private int toRow;
    private int toColumn;
    private char actionType;

    //getters
    public int getfromRow(){
        return fromRow;
    }
    public int getfromColumn(){
        return fromColumn;
    }
    public int gettoRow(){
        return toRow;
    }
    public int gettoColumn(){
        return toColumn;
    }

    //methods named getUsersNextActionType and getValidInt from Lab 2
    //methods named getUsersNextActionType and getValidInt from Lab 2
    public static char getUserNextActionType (Scanner scr){
        /**
         *This method will use a while loop to repeatedly ask the user to enter
         * one the following character values: ASMR to either attack, spawn, move,
         * or recruit.
         *
         *@param Scanner takes the users input
         *
         *@return myChar returns the character input by the user, if valid
         */
        boolean validChar = false;
        System.out.println("Would you like to Attack, Move, Recruit, Huddle, or Spawn?");
        char myChar = scr.next().charAt(0);
        while (!validChar){
            myChar = Character.toUpperCase(myChar);
            System.out.println("Would you like to Attack, Move, Recruit, Spawn, or Huddle?");
            if (myChar == 'A' || myChar == 'S' || myChar == 'M' || myChar == 'R' || myChar == 'H'){
                validChar = true;
            }
            else{
                myChar = scr.next().charAt(0);
            }
        }
        return myChar;
    }

    public static int getValidInt (int min, int max, Scanner scr){
        /**
         *This method uses a while loop to repeatedly ask the user to enter an integer in
         * the range indicated by the arguments passed to the method until the user enters
         * an integer in that range.
         *
         *@param min lower bound of the range
         *@param max upper bound of the range
         *@param Scanner takes input from the user
         *
         *@return userInput returns the users input if it is within the range
         */
        boolean validNum = false;
        System.out.println("Enter an integer between " + min + " and " + max);
        int userInput = scr.nextInt();

        while(!validNum){
            System.out.println("Enter an integer between " + min + " and " + max);
            if (userInput >= min && userInput < max){
                validNum = true;
            }
            else{
                userInput = scr.nextInt();
            }
        }
        return userInput;
    }

    public void getNextPlayersAction(GameS22 game){
        System.out.println("What action would you like your piece to perform?");
        Scanner scr0 = new Scanner(System.in);
        actionType = getUserNextActionType(scr0);

        //FROM
        System.out.println("What is the current row of your piece?");
        int maxRow = game.getGameBoard().getNumRows();
        Scanner scr1 = new Scanner(System.in);
        fromRow = getValidInt(0, maxRow, scr1);

        System.out.println("What is the current column of your piece?");
        int maxColumn = game.getGameBoard().getNumColumns();
        Scanner scr2 = new Scanner(System.in);
        fromColumn = getValidInt(0, maxColumn, scr2);

        //TO
        System.out.println("What row would you like to move your piece to?");
        Scanner scr3 = new Scanner(System.in);
        toRow = getValidInt(0, maxRow, scr3);

        System.out.println("What column would you like to move your piece to?");
        Scanner scr4 = new Scanner(System.in);
        toColumn = getValidInt(0, maxColumn, scr4);
    }

    public static void updateView (GameS22 game){
        System.out.println(game.toString());
    }

    public void printEndOfGameMessage (GameS22 game){
        System.out.println("Game Over...");
        System.out.println("The Winner is " + game.getWinner().getTeamColor() + " Team!");

    }
    public char getactionType(){
        return actionType;
    }
}