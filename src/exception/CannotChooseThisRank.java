package exception;

public class CannotChooseThisRank extends Exception {
    
    private int rank;

    public CannotChooseThisRank(int rank){
        this.rank = rank;
    }
}
