package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.Heuristic;
import es.udc.intelligentsystems.Node;
import es.udc.intelligentsystems.State;

public class Node_plus extends Node {

    float valor;
    Square_H h = new Square_H();
    public Node_plus(Node nd) {
        super(nd);
        valor = h.evaluate(nd.getState());
    }

    public Node_plus(State nd) {
        super(nd);
        valor = h.evaluate(getState());
    }
    public Node_plus(Node father, State state) {
        super(father, state);
        valor = h.evaluate(state);
    }

    public Node_plus(Node father, State state, float valor) {
        super(father, state);
        this.valor = valor;
    }

    public float getHValor() {
        valor = h.evaluate(this.getState());
        return valor;
    }

    public float getValor(){
        return valor;
    }

    public static class Square_H extends Heuristic {


        @Override
        public float evaluate(State e) {
          Square sq = (Square) e;
          int n = sq.getN(), toReturn = 0;
          int sumD1 = 0;
          int sumD2 = 0;int[] sumF = new int[n];
          int[] sumC = new int[n];
          int valor = (n*(n*n +1))/2;
          int empties = 0;
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    if(sq.getPosition(i,j)== 0 || sq.getPosition(j,i) == 0 ){
                       empties ++;
                    }

                    sumF[i] = sumF[i] + sq.getPosition(i, j);
                    sumC[i] = sumC[i] + sq.getPosition(j, i);
                    if (i == j) {
                        sumD1 = sumD1 + sq.getPosition(i, j);
                    }
                    if (i+j == n-1){
                        sumD2 = sumD2 + sq.getPosition(i,j);


                    }
                }
            }

            for (int k = 0; k < n ; k++) {
                if (sumF[k] == valor) toReturn = toReturn + 100;
                if (sumF[k] <= valor) toReturn = toReturn - 1000 * (valor-sumF[k]) ;
                if (sumC[k] == valor) toReturn = toReturn + 100;
                if (sumC[k] <= valor) toReturn = toReturn - 1000* (valor-sumC[k]);
                if (sumD2 == valor) toReturn = toReturn + 100;
                if (sumD2 <= valor) toReturn = toReturn - 1000* (valor-sumD2);
                if (sumD1 == valor) toReturn = toReturn + 100;
                if (sumD1 <= valor) toReturn = toReturn - 1000 * (valor-sumD1);
            }

         return toReturn + (5*empties);

        }
    }

}
