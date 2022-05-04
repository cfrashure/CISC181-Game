public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int newNum);
    public abstract boolean validAttackPath(int rowDo, int columnDo,
                                             int rowBe, int columnBe);
}
