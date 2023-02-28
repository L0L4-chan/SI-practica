package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.State;

public class SquareAction extends Action {

    Position empty;
    int possible;
    public SquareAction(Square sq, int po){
        empty = sq.getEmptyPosition();
        possible = po;

    }

    @Override
    public String toString() {
        return  "possible";
    }

    @Override
    public boolean isApplicable(State st) {
        Square sq = (Square) st;
        int column=0, row= 0, n = sq.getN(), obj;
        obj = (n * (n * n +1))/2;
        if (sq.getPosition(this.empty.x, this.empty.y)==0) {
            for (int i = 0; i < n; i++) {
                row = row + sq.getPosition(empty.x, i);
                column = column + sq.getPosition(i, empty.y);
            }

            return (row + possible <= obj) && (column + possible <= obj);
        }
        return false;
    }

    @Override
    public State applyTo(State st) {

        Square sq = (Square) st;
        int n = sq.getN();
        Square toReturn = new Square(n);
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                toReturn.setPosition( new Position(i,j), sq.getPosition(i,j)) ;
            }
        }
        if (sq.getPosition(this.empty.x, this.empty.y)==0){
            toReturn.setPosition(empty, possible);
            return toReturn;
        }
        return null;
    }


}
