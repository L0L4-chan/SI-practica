package es.udc.intelligentsystems.example;

import es.udc.intelligentsystems.*;

import java.util.ArrayList;
import java.util.Stack;

public class GraphSearchStrategy implements SearchStrategy {
    public GraphSearchStrategy() {
    }

    @Override
    public ArrayList<Node> solve(SearchProblem p) throws Exception{
        ArrayList<State> explored = new ArrayList<>();
        Stack<Node> border = new Stack<>();
        State currentState = p.getInitialState();
        Node nd = new Node(currentState);
        explored.add(currentState);

        int i = 1;

        System.out.println((i++) + " - Starting search at " + currentState);

        while (!p.isGoal(currentState)){
            System.out.println((i++) + " - " + currentState + " is not a goal");
            Action[] availableActions = p.actions(currentState);
            boolean modified = false;
            for (Action acc: availableActions) {
                State s = p.result(currentState, acc);
                if (!explored.contains(s)) {
                    Node sc = new Node(nd,s);
                    System.out.println((i++) + " - RESULT(" + currentState + ","+ acc + ")=" + s);
                    nd = sc;
                    currentState = sc.getState();
                    System.out.println((i++) + " - " + sc + " NOT explored");
                    explored.add(s);
                    modified = true;
                    System.out.println((i++) + " - Current state changed to " + currentState);
                    break;
                }
                else
                    System.out.println((i++) + " - " + s + " already explored");
                border.add(new Node(nd,s));
            }
            if (!modified) {
                nd = border.pop();
            }
        }
        System.out.println((i++) + " - END - " + currentState);
        return solution(nd);
    }

    private ArrayList<Node> solution(Node currentState) {
        ArrayList<Node> solution = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node aux = currentState.getFather();
        stack.add(currentState);
        while (aux!=null) {
            stack.add(aux);
            aux = aux.getFather();
        }

        while(!stack.empty()){
            solution.add(stack.pop());
        }
        return solution;
    }
}

