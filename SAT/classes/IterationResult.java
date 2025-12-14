package SAT.classes;

import java.util.ArrayList;

public class IterationResult {
    private boolean found;
    private CNF cnf;

    public IterationResult(CNF cnf, boolean found){
        this.found = found;
        this.cnf = cnf;
    }

    public boolean wasFound(){return this.found;}

    public CNF getVariables(){return this.cnf;}
}
