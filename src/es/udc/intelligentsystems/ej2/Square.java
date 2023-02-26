package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.State;

public class Square extends State {
    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public int getPosition(int i, int j){
        return matrix[i][j];
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
