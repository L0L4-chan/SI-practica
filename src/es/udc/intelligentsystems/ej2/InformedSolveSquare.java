package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class InformedSolveSquare implements InformedSearchStrategy {
    Stack<Node_plus> border = new Stack<>();
    PriorityQueue<Node_plus> explored = new PriorityQueue<>(new Compare());
    int countCreated = 0;
    int countExpanded = 0;


    @Override
    public ArrayList<Node_plus> solve(SearchProblem p, Heuristic h) throws Exception {
            State currentState = p.getInitialState();
            Node_plus nd = new Node_plus(currentState);
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
                    Node_plus sc = new Node_plus(nd, s);

                    if (s != null) {
                        if (!explored.contains(sc)&& !border.contains(sc)) {
                            border.add(sc);
                            countCreated++;
                            System.out.println((i++) + " - RESULT(" + nd.getState() + "," + acc + ")=" + s);
                            nd = sc;
                            System.out.println((i++) + " - \n" + sc + "\n NOT explored");
                            explored.add(sc);
                            countExpanded++;
                            modified = true;
                            System.out.println((i++) + " - Current state changed to \n" + sc);
                        } else {
                            System.out.println((i++) + " - \n" + s + "\n already explored");

                        }
                    }
                }if (!modified) {
                    nd = border.pop();
                }
            }

            System.out.println((i++) + " - END - " + currentState);
            return solution(nd);
        }

        private ArrayList<Node_plus> solution(Node_plus currentState) {
            ArrayList<Node_plus> solution = new ArrayList<>();
            Stack<Node_plus> stack = new Stack<>();
            Node_plus aux = (Node_plus)currentState.getFather();
            stack.add(currentState);
            while (aux!=null) {
                stack.add(aux);
                aux = (Node_plus)aux.getFather();
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

    private class Compare implements Comparator<Node_plus> {


        @Override
        public int compare(Node_plus o1, Node_plus o2) {
            if(o1.getHValor()>=o2.getHValor()) return 1;
            else return -1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

}
