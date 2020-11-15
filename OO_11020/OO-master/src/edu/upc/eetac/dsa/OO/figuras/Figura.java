package edu.upc.eetac.dsa.OO.figuras;

public abstract class Figura implements Comparable<Figura>{      //MAI podem crear instancies de figura

    public abstract double area();

    public int compareTo(Figura f) {
        return (int)(f.area()-this.area());
    }
}

