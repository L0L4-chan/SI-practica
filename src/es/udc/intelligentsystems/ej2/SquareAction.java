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
        //int for_row = 0, for_col = 0;
        //boolean readyr  = false, readyc = false;

        if (sq.getPosition(this.empty.x, this.empty.y)==0) {
            for (int i = 0; i < n; i++) {
                //int a = sq.getPosition(empty.x, i);
               // if (i != this.empty.y && a == 0) for_row++;
                row = row + sq.getPosition(empty.x, i);
                //int b = sq.getPosition(i, empty.y);
               // if (i != this.empty.x && b == 0) for_col++;
                column = column + sq.getPosition(i, empty.y);
            }
            //if (for_col == 0) {
             //   if (column + possible != obj) {
              //      return false;
            //    }
            //    readyc = true;
           // }
           // if (for_row == 0) {
           //     if (row + possible != obj) {
            //        return false;
            //    }
           //     readyr = true;
           // }
           // if (readyr && readyc){
           //     return true;
        //}
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
        toReturn.setPosition(empty, possible);
        return toReturn;
    }


}
