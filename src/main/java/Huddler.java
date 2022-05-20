public interface Huddler {
    public abstract int getNumHuddle();
    public abstract void setNumHuddle(int newNum);
    public abstract boolean validHuddlePath(int rowDo, int columnDo,
                                            int rowBe, int columnBe);
}