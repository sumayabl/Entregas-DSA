package edu.upc.eetac.dsa.OO;

import edu.upc.eetac.dsa.OO.figuras.Cercle;
import edu.upc.eetac.dsa.OO.figuras.Figura;
import edu.upc.eetac.dsa.OO.figuras.Quadrat;
import edu.upc.eetac.dsa.OO.figuras.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class GestorClasses {
    //mecanisme per ordenar vector figures
    public static void sort (Figura[] v){
        Arrays.sort(v);                              //Ordenar un array de objectes de area + grande a + peq.

        Arrays.sort(v, new Comparator<Figura>() {    //Comparador de figuras amb clase anonima
            @Override
            public int compare(Figura o1, Figura o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public static double suma (Figura[] v){     //mecanisme per proporcionar suma area total
        double ret = 0;
        //Recorrido a todos los elementos del vector
        for (Figura f: v) {
            //System.out.println(f);
            ret+= f.area();          //Métode polimorfic
        }
        return ret;
    }
    public static void main(String[] args) {       //punt entrada on farem el testing
        Figura[] v =new Figura[3];              //iniciem vector (v) amb 3 posicions
        v[0] = new Cercle(5);                     //posició 0
        v[1] =new Rectangle(2,1);                   //posició 1
        v[2] =new Quadrat(2);                     //posició 2

        double r = GestorClasses.suma(v);     //invoquem el vector v, ens ha de donar el resultat de la suma total

        System.out.println(r);      //r ens envia el valor de la area global a la consola de sortida standard

        System.out.println(Arrays.asList(v));   //Printar vector abans de la ordenació (sort)
        GestorClasses.sort(v);                  //Ordenació
        System.out.println(Arrays.asList(v));   //Printar després de sort

    }


}
