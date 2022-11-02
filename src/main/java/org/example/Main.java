package org.example;

import static org.example.BoundedWildcard.*;

//Bounded Wildcard arguments.

//Two-dimensional coordinates.
class TwoD{
    int x, y;

    public TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//Three-dimensional coordinates.
class ThreeD extends TwoD{
    int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

//Four-dimensional coordinates.
class FourD extends ThreeD{
    int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

//This class holds an array of coordinate objects.
class Coords<T extends TwoD>{
    T[] coords;

    Coords(T[] o){
        coords = o;
    }
}

//Demonstrate a bounded wildcard.
class BoundedWildcard{
    static void showXY(Coords<?> c){
        System.out.println("X Y Coordinates: ");
        for(int i=0; i<c.coords.length; i++){
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c){
        System.out.println("X Y Z Coordinates: ");
        for(int i=0; i<c.coords.length; i++){
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z);
        }
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c){
        System.out.println("X Y Z T Coordinates: ");
        for(int i=0; i<c.coords.length; i++){
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z + " " +
                    c.coords[i].t);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        TwoD td[] = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23),
        };

        Coords<TwoD> tdlocs = new Coords<TwoD>(td);

        System.out.println("Contents of tdlocs.");
        showXY(tdlocs);

        FourD fd[] = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 7, 8, 9),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17),
        };

        Coords<FourD> fdlocs = new Coords<FourD>(fd);

        System.out.println("Contents of tdlocs.");
        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);
    }
}