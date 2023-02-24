package es.udc.intelligentsystems.example;

import es.udc.intelligentsystems.*;

import java.util.ArrayList;
import java.util.Stack;

public class Strategy4 implements SearchStrategy {

    public Strategy4() {
    }

    @Override
    public ArrayList<Node> solve(SearchProblem p) throws Exception{
        ArrayList<State> explored = new ArrayList<>();
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
            }
            if (!modified) throw new Exception("No solution could be found");
        }
        System.out.println((i++) + " - END - " + currentState);
        return solucion(nd);
    }

    private ArrayList<Node> solucion(Node currentState) {
        ArrayList<Node> solucion = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node aux = currentState.getFather();
        stack.add(currentState);
        while (aux!=null) {
            stack.add(aux);
            aux = aux.getFather();
        }

        while(!stack.empty()){
            solucion.add(stack.pop());
        }
        return solucion;
    }
}
