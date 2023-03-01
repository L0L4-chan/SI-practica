package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Heuristic;
import es.udc.intelligentsystems.Node;
import es.udc.intelligentsystems.State;

public class Node_plus extends Node {

    float valor = 0;
    Square_H h = new Square_H();
    public Node_plus(Node nd) {
        super(nd);
    }

    public Node_plus(Node father, State state) {
        super(father, state);
    }

    public Node_plus(Node father, State state, float valor) {
        super(father, state);
        this.valor = this.valor + valor;
    }

    public float getValor() {
        valor = h.evaluate(this.getState());
        return valor;
    }

    public class Square_H extends Heuristic {


        @Override
        public float evaluate(State e) {

         return 0;

        }
    }

}
