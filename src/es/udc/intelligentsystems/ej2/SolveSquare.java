package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.Node;
import es.udc.intelligentsystems.State;
import es.udc.intelligentsystems.example.GraphSearchStrategy;

import java.util.ArrayList;
import java.util.Stack;

public class SolveSquare extends GraphSearchStrategy {

    private int countCreated;
    private int countExpanded;

    public ArrayList<Node> solve(MagicSquareProblem p) throws Exception{
    ArrayList<Node> explored = new ArrayList<>();
    Stack<Node> border = new Stack<>();
    State currentState = p.getInitialState();
    Node nd = new Node(currentState);
    countCreated ++;
    explored.add(nd);


    int i = 1;

        System.out.println((i++) + " - Starting search at " + currentState);

        while (!p.isGoal(nd.getState())){

            System.out.println((i++) + " - " + nd.getState() + " is not a goal");
            Action[] availableActions;
            availableActions = p.actions(nd.getState());
            boolean modified = false;

            for (Action acc: availableActions) {
                State s = p.result(nd.getState(), acc);
                Node sc = new Node(nd, s);

                if (s != null) {
                    if (!explored.contains(sc)) {
                        border.add(sc);
                        countCreated++;
                        System.out.println((i++) + " - RESULT(" + nd.getState() + "," + acc + ")=" + s);
                        nd = sc;
                        System.out.println((i++) + " - " + sc + " NOT explored");
                        explored.add(sc);
                        countExpanded++;
                        modified = true;
                        System.out.println((i++) + " - Current state changed to " + currentState);
                    } else {
                        System.out.println((i++) + " - " + s + " already explored");

                    }
                }
            }if (!modified) {
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

    public int getCountCreated() {
        return countCreated;
    }

    public int getCountExpanded() {
        return countExpanded;
    }
}

