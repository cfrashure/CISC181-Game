public abstract class Action{
    protected GameS22 Game22;
    protected int fromRow;
    protected int fromCol;
    protected int toRow;
    protected int toCol;

    public Action(GameS22 Game22, int fromRow, int fromCol, int toRow, int toCol){
        this.Game22 = Game22;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public abstract void performAction();



}
