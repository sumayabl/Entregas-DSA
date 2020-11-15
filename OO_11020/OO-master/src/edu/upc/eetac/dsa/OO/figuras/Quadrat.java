package edu.upc.eetac.dsa.OO.figuras;

public class Quadrat extends Rectangle{

    public Quadrat(double l) {
        super(l,l);            //invocar constructor del rectangle
    }

    @Override
    public String toString() { return "Quadrat l:" +this.getL1() + "area:" +super.area(); }
    //public Quadrat(int i) {super(i,i);
}

