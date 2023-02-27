package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.State;

import java.util.ArrayList;

public class MagicSquareProblem extends SearchProblem {
    private final int n;
    private Square initialSquare;
    ArrayList<Integer> notUsed;
    public MagicSquareProblem(State initialState, int n) {
        super(initialState);
        this.n = n;
        initialSquare= (Square)this.getInitialState();
        for (int i = 1; i<=n; i++){
            notUsed.add(i);
        }
        for (int i = 0; i< n; i++){
            for (int j = 0; j< initialSquare.getN(); j++){
                if(initialSquare.getPosition(i,j) != 0){
                    notUsed.remove(initialSquare.getPosition(i,j));
                }
            }
        }
    }

    @Override
    public State getInitialState(){
        return initialSquare;
    }
    @Override
    public boolean isGoal(State st) {
        Square sq = (Square) st;
        int sumC = 0, sumF=0, sumD=0;
        int valor = (n*(n^2 +1))/2;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                sumF = sumF + sq.getPosition(i, j);
                sumC = sumC + sq.getPosition(j, i);
                if (i == j) {
                    sumD = sumD + sq.getPosition(i, j);
                }
                if (j == n - 1) {
                    if (sumC != valor && sumF != valor) {
                        return false;
                    } else if (i == n - 1 && sumD != valor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public Action[] actions(State st) {
        Action[] act= null;
        for (int i = 0; i< notUsed.size(); i++){
            act[i] = new SquareAction(notUsed.get(i));
                    }
        return new Action[0];
    }
}
