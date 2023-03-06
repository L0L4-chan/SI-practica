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
        System.out.print( "Se han creado: " + solve.getCountCreated() + " nodos.");
        System.out.print( "Se han expandido: " + solve.getCountExpanded() + " nodos.");

        MagicSquareProblem mp2 = new MagicSquareProblem(initial2, 3);

        SolveSquare solve2 = new SolveSquare();
        System.out.print( solve2.solve(mp2));
        System.out.print( "Se han creado: " + solve2.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve2.getCountExpanded() + "nodos.");

        MagicSquareProblem mp3 = new MagicSquareProblem(initial, 3);

        InformedSolveSquare solve3 = new InformedSolveSquare();
        System.out.print( solve3.solve(mp3, new Node_plus.Square_H()));
        System.out.print( "Se han creado: " + solve3.getCountCreated() + " nodos.");
        System.out.print( "Se han expandido: " + solve3.getCountExpanded() + " nodos.");

        MagicSquareProblem mp4 = new MagicSquareProblem(initial2, 3);

        InformedSolveSquare solve4 = new InformedSolveSquare();
        System.out.print( solve4.solve(mp4, new Node_plus.Square_H()));
        System.out.print( "Se han creado: " + solve4.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve4.getCountExpanded() + "nodos.");

        MagicSquareProblem mp5 = new MagicSquareProblem(initial, 3);

        Backtracking solve5 = new Backtracking();
        System.out.print( solve5.solve(mp5));
        System.out.print( "Se han creado: " + solve5.getCountCreated() + " nodos.");
        System.out.print( "Se han expandido: " + solve5.getCountExpanded() + " nodos.");

        MagicSquareProblem mp6 = new MagicSquareProblem(initial2, 3);

        Backtracking solve6 = new Backtracking();
        System.out.print( solve6.solve(mp6));
        System.out.print( "Se han creado: " + solve6.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve6.getCountExpanded() + "nodos.");





       /*
        MagicSquareProblem mp3 = new MagicSquareProblem(initial3, 4);

        InformedSolveSquare solve3 = new InformedSolveSquare();
        System.out.print( solve3.solve(mp3, new Node_plus.Square_H()));
        System.out.print( "Se han creado: " + solve3.getCountCreated() + "nodos.");
        System.out.print( "Se han expandido: " + solve3.getCountExpanded() + "nodos.");
*/





    }
}
