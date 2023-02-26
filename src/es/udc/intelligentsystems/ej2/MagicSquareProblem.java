package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.SearchProblem;
import es.udc.intelligentsystems.State;

public class MagicSquareProblem extends SearchProblem {
    private int n;
    public MagicSquareProblem(State initialState, int n) {
        super(initialState);
        this.n = n;
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


        return new Action[0];
    }
}
