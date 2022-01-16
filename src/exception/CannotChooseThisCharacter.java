package exception;

public class CannotChooseThisCharacter extends Exception{

    private String raison = "";

    public CannotChooseThisCharacter(String raison){
        this.raison = raison;
    }

    public String getRaison(){
        return raison;
    }
    
}
