package es.udc.intelligentsystems.ej2;

public class Main {

    public static void main(String[] args) throws Exception {

        Square initial = new Square(3);
        initial.setPosition(new Position(0,0),4);
        initial.setPosition(new Position(0,1),9);
        initial.setPosition(new Position(0,2),2);
        initial.setPosition(new Position(1,0),3);
        initial.setPosition(new Position(1,1),5);
        initial.setPosition(new Position(2,1),1);

        MagicSquareProblem mp = new MagicSquareProblem(initial, 3);

        SolveSquare solve = new SolveSquare();
        System.out.print( solve.solve(mp));
        System.out.print( "Se han creado: " + solve.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve.getCountExpanded() + "nodos.");



    }
}
