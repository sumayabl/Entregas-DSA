package edu.upc.eetac.dsa.OO.figuras;

public class Cercle extends Figura {

    private double r;

    public Cercle(double r){
        this.r = r;
    }

    public double area() { //mètode de area implementa el metode especificat a la clase abstacte figura
        return Math.PI * Math.pow(this.r, 2) ;
    }



    @Override       //reimplementa un métode que ja existia a la clase objecte(superclase)
    public String toString(){
        return "Cercle r:" + this.r + "area: [{"+this.area()+")}";}     //Cercla: radi: area

}
