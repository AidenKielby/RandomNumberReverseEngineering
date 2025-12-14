package SAT.classes;

import java.util.List;

public class CNF {
    private List<Clause> clauses;

    public CNF(List<Clause> clauses){
        this.clauses = clauses;
    }
    public List<Clause> getClauses(){return this.clauses;}

}
