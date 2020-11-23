package edu.upc.dsa.models;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class Persona {
    String idPersona;
    String nombre;
    String apellidos;
    int edad;
    String nivelSalud;
    //Lista de muestras completadas
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    LinkedList<Muestra> muestraList;

    //Constructor usuario
    public Persona(String idPersona, String name, String apellidos, int edad, String nivelSalud){
        this.idPersona =idPersona;
        this.nombre =name;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nivelSalud = nivelSalud;
        this.muestraList= new LinkedList<>(); //Inicialitzar llista encadenada muestras
    }
    public Persona(){ }

    //GETS: Lectura y escritura de NIF y Name
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }

    public void setApellidos(String apellidos) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
    public String getIdPersona() { return idPersona; }

    public void setEdad(int edad) { this.edad = edad; }
    public int getEdad() { return edad; }

    public void setNivelSalud(String nivelSalud) { this.nivelSalud = nivelSalud; }

    public String getNivelSalud() { return nivelSalud; }

    public LinkedList<Muestra> getMuestraList() {
        return this.muestraList;
    }
    public void setMuestraList(LinkedList<Muestra> orderList) {
        this.muestraList = orderList;
    }

    //Añadimos addOrder en User para saberlo para el getOrder
    public void addMuestra(Muestra muestraList){
        this.muestraList.add(muestraList);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona='" + idPersona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", nivelSalud='" + nivelSalud + '\'' +
                '}';
    }


//    @Override
//    public String toString() {
//        String s= "User[ID= " + idPersona + ", Name= " + nombre + "]" ;
//        for(int i=0; i < this.orderList.size();i++)
//            s= "orderList [Name = " + orderList.get(0).productos.get(i).producto+ ", Cantidad = " + orderList.get(0).productos.get(i).cantidad + "]";
//        return s;
//    }
}
