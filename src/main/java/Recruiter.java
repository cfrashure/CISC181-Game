public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int newNum);
    public abstract boolean validRecruitPath(int rowDo, int columnDo,
                                             int rowBe, int columnBe);
}
