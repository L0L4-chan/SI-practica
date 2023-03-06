package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.Node;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.SearchStrategy;

import java.util.ArrayList;
import java.util.Stack;

public class Backtracking  implements SearchStrategy {

    int countCreated = 0;
    int countExpanded = 0;


    @Override
    public ArrayList<Node> solve(SearchProblem p) throws Exception {
        ArrayList<Node> explorados = new ArrayList<>();
        Node currentState = new Node(p.getInitialState());
        countCreated++;
        Node nd;

        Stack<Node> frontera = new Stack<>();
        frontera.add(currentState);
        int i = 1;

        System.out.println((i++) + " - Starting search at " + currentState);

        while (true) {
            if (frontera.isEmpty()) {
                throw new Exception("There not solution");
            }

            currentState = frontera.pop();

            if (p.isGoal(currentState.getState())) {
                break;
            }

            System.out.println((i++) + " - " + currentState.getState() + " is not a goal");

            explorados.add(currentState);

            for (Action act : p.actions(currentState.getState())) {
                nd = new Node(currentState, p.result(currentState.getState(),act) );
                countCreated++;
                if (!frontera.contains(nd) && !explorados.contains(nd)) {
                    frontera.add(nd);
                    countExpanded++;
                }
            }
        }

        System.out.println((i) + " - End - " + currentState.getState());

        return solution(currentState);
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

    public int getCountCreated() {

        return countCreated;
    }

    public int getCountExpanded() {
        return countExpanded;
    }
}


