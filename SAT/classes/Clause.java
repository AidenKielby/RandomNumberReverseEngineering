package SAT.classes;

import java.util.List;

public class Clause {
    List<Literal> lits;
    public Clause(List<Literal> lits){
        this.lits = lits;
    }
    public List<Literal> getLiterals(){return this.lits;}
    
}
