package es.udc.intelligentsystems;

import es.udc.intelligentsystems.ej2.Node_plus;

import java.util.ArrayList;

public interface InformedSearchStrategy {
    /**
     * Solves a search problem, obtaining a goal state or throwing an exception if none is found
     *
     * @param p Problem to solve
     * @param h Heuristic that assigns a utility value to each state
     * @return Goal state found
     */
    public abstract ArrayList<Node_plus> solve(SearchProblem p, Heuristic h) throws Exception;
}
