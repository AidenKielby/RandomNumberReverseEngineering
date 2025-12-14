package SAT;

import java.util.ArrayList;
import java.util.Objects;

import SAT.classes.CNF;
import SAT.classes.Clause;
import SAT.classes.IterationResult;
import SAT.classes.Literal;
import SAT.classes.Variable;

public class SATSolver {

    public static void solve(String expression){
        boolean result = getResult(expression);
        
        SATSolver solver = new SATSolver();
        IterationResult iterationResult = solver.iterate(null, result, 0);
        if (iterationResult.wasFound()){
            System.out.println("Satisfiable with assignment:");
        }
        else{
            System.out.println("Unsatisfiable");
        }
    }
    


   private IterationResult iterate(CNF cnf, boolean result, int i) {
        if (i < cnf.getClauses().size()) {
            IterationResult iterationResult = new IterationResult(cnf, false);
            Clause clause = cnf.getClauses().get(i);
            for (int literalIndex = 0; literalIndex < clause.getLiterals().size(); literalIndex++){
                Literal literal = clause.getLiterals().get(literalIndex);
                
                boolean p = true;
                for (int possilbilty = 0; possilbilty < 2; possilbilty++){
                    literal.setNegated(p);
                    iterationResult = iterate(cnf, result, i+1);
                    p = !p;
                }

            }
            return iterationResult;
        }
        else {
            Clause clause = cnf.getClauses().get(i);
            IterationResult iterationResult = new IterationResult(cnf, false);
            for (int literalIndex = 0; literalIndex < clause.getLiterals().size(); literalIndex++){
                Literal literal = clause.getLiterals().get(literalIndex);
                
                boolean p = true;
                for (int possilbilty = 0; possilbilty < 2; possilbilty++){
                    literal.setNegated(p);
                    iterationResult = evaluate(cnf, result);
                    p = !p;
                }

            }
            return iterationResult;
        }
    }



   private IterationResult evaluate(CNF cnf, boolean result) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
}



   private static ArrayList<String> getOpperators(String expression) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (String s : expression.split(" ")) {
            if ((Objects.equals(s, "!") || Objects.equals(s, "^") 
            || Objects.equals(s, "&") || Objects.equals(s, "|"))){
                if (Objects.equals(s, "=")){
                    break;
                }
                toReturn.add(s);
            }
       }

       return toReturn;
    }

    private static String numberToBoolean(String s) {
        if (Objects.equals(s, "1")){
            return "true";
        }
        else{
            return "false";
        }
    }

    private static boolean getResult(String expression){
        return Objects.equals(expression.split("=")[1]
        .replaceAll(" ", ""), "1");
    }

    public static void main(String[] args){
        solve("x1 ^ x2 = 1");
        solve("x1 ^ x2 = 0");
        solve("x1 ^ x2 = 1");
        solve("0 ^ x1 = 0");
    }
    
}
