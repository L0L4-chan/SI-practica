package es.udc.intelligentsystems;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface SearchStrategy {

    /**
     * Solves a search problem, obtaining a goal state or throwing an exception if none is found
     * @param p Problem to solve
     * @return Goal state found
     */
    public abstract ArrayList<Node> solve(SearchProblem p) throws Exception;


}
