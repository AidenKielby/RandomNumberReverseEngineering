package SAT.classes;

public class Literal {
    private int var;        // variable ID
    private boolean neg; 

    public Literal(int var, boolean neg){
        this.var = var;
        this.neg = neg;
    }

    public int getVar(){return this.var;}
    public boolean isNegated(){return this.neg;}
    
    public void setNegated(boolean negated){this.neg = negated;}
}
