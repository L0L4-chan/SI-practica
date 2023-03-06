package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.State;
import java.util.Stack;

public class MagicSquareProblem extends SearchProblem {
    private final int n;
    private final Square initialSquare;
    public MagicSquareProblem(State initialState, int n) {
        super(initialState);
        this.n = n;
        initialSquare= (Square)initialState;


    }

    @Override
    public State getInitialState(){
        return initialSquare;
    }
    @Override
    public boolean isGoal(State st) {
        Square sq = (Square) st;
        int sumD1 = 0;
        int sumD2 = 0;int[] sumF = new int[n];
        int[] sumC = new int[n];
        int valor = (n*(n*n +1))/2;

        if (sq.getEmptyPosition() != null) return false;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                sumF[i] = sumF[i] + sq.getPosition(i, j);
                sumC[i] = sumC[i] + sq.getPosition(j, i);
                if (i == j) {
                    sumD1 = sumD1 + sq.getPosition(i, j);
                }
                if (i+j == n-1){
                    sumD2 = sumD2 + sq.getPosition(i,j);

                }
                if (j == n - 1 && i == n-1) {
                    for (int k = 0; k < n ; k++){
                        if (sumF[k]!= valor || sumC[k] != valor) return false;
                    }

                    if (sumD2 != valor || sumD1 != valor)return false;

                }
            }
        }
        return true;
    }

    @Override
    public Action[] actions(State st) {
        Square sq = (Square) st;
        SquareAction squareAction;
        Stack<SquareAction> act = new Stack<>();
        int count = 0;
        for(int i : sq.getNotUsed()){
          squareAction = new SquareAction(sq, i);
            if (squareAction.isApplicable(st)){
                act.add(squareAction);
                count++;
            }
        }
        Action[] toReturn = new Action[count];
        for (int j = 0; j<count; j++){
            toReturn[j] = act.pop();
        }

        return toReturn;
    }

    public State result(State st, Action act){
        SquareAction squareAction = (SquareAction) act;
        if (act==null){
            return null;
        }
        return squareAction.applyTo(st);
    }

}
