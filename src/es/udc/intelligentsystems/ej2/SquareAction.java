package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Action;
import es.udc.intelligentsystems.State;


public class SquareAction extends Action {

    int toFill;

    public SquareAction(int toFill) {
        this.toFill= toFill;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean isApplicable(State st) {
        Square sq = (Square) st;
        return sq.getEmptyPosition() != null;
    }

    @Override
    public State applyTo(State st) {
        Square sp = (Square) st;
        Position p = sp.getEmptyPosition();
        sp.setPosition(p,toFill);
        return sp;
    }

}
