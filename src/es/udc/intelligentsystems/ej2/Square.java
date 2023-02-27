package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.State;

public class Square extends State {
    private int[][] matrix;
    private int n ;

    public Square(int n) {
        this.n = n;
        matrix= new int[n][n];
    }

    public Square(Square toCopy) {
        this.n = toCopy.getN();
        matrix= toCopy.getMatrix();
    }
    public int[][] getMatrix() {
        return matrix;
    }

    public int getPosition(int i, int j){
        return matrix[i][j];
    }

    public int getN() {
        return n;
    }

    public void setPosition(int x, int y, int n) {
        this.matrix[x][y] = n;
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
