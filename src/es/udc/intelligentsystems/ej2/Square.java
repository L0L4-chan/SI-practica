package es.udc.intelligentsystems.ej2;

import es.udc.intelligentsystems.State;

import java.util.ArrayList;

public class Square extends State {
    private int[][] matrix;
    private final int n;

    public Square(int n) {
        this.n = n;
        matrix = new int[n][n];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getPosition(int i, int j) {
        return matrix[i][j];
    }

    public int getN() {
        return n;
    }

    public Position getEmptyPosition() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.getPosition(i, j) == 0) {
                    return new Position(i, j);

                }
            }
        }
        return null;
    }

    public void setPosition(Position p, int n) {
        this.matrix[p.x][p.y] = n;
    }


    @Override
    public String toString() {

    StringBuilder s = new StringBuilder();
    String toReturn;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               s.append("|" + getPosition(i, j));
                if (j == (n - 1)) {
                    s.append("|");
                }
            }
            s.append("\n");
        }
        toReturn = s.toString();
        return toReturn ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj.getClass() == this.getClass()) {
            Square o = (Square) obj;
            return o.getN() == this.getN() && o.getMatrix() == this.getMatrix();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public ArrayList<Integer> getNotUsed() {
        ArrayList<Integer> toReturn = new ArrayList<>();
        for (int i = 1; i <= (n * n); i++) {
            toReturn.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (getPosition(i, j) != 0) {
                    toReturn.remove((Integer) getPosition(i, j));
                }
            }
        }
        return toReturn;
    }
}
