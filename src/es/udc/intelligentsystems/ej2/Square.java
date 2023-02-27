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

    public Position getEmptyPosition(){
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.getPosition(i, j) != 0) {
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
        return null;
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj.getClass()== this.getClass()){
           Square o = (Square)obj;
           if (o.getN()==this.getN()&& o.getMatrix()==this.getMatrix()) return true;
       }
       return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
