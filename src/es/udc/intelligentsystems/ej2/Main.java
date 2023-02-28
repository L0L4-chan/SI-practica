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

        Square initial2 = new Square(3);
        initial2.setPosition(new Position(0,0),2);

        Square initial3 = new Square(4);
        initial3.setPosition(new Position(0,0),2);
        initial3.setPosition(new Position(3,1),1);


        MagicSquareProblem mp = new MagicSquareProblem(initial, 3);

        SolveSquare solve = new SolveSquare();
        System.out.print( solve.solve(mp));
        System.out.print( "Se han creado: " + solve.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve.getCountExpanded() + "nodos.");
/*
        MagicSquareProblem mp2 = new MagicSquareProblem(initial2, 3);

        SolveSquare solve2 = new SolveSquare();
        System.out.print( solve2.solve(mp2));
        System.out.print( "Se han creado: " + solve2.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve2.getCountExpanded() + "nodos.");


        MagicSquareProblem mp3 = new MagicSquareProblem(initial3, 4);

        SolveSquare solve3 = new SolveSquare();
        System.out.print( solve3.solve(mp));
        System.out.print( "Se han creado: " + solve3.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve3.getCountExpanded() + "nodos.");



*/


    }
}
