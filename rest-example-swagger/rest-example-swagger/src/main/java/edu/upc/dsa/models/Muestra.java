package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Muestra {
    //Atributos
    private Persona persona;
    String idMuestra;
    String idMedico;
    String idLaboratorio;
    String fechaMuestra;

    public Muestra(String idMuestra, String idMedico, String idLaboratorio, String fechaMuestra){
        this.idMuestra = idMuestra;
        this.idMedico = idMedico;
        this.idLaboratorio = idLaboratorio;
        this.fechaMuestra = fechaMuestra;
    }
    //Constructor vacio json
    public Muestra(){ }

    public void setPersona(Persona theUser) {
        this.persona = theUser;
    }
    public Persona getPersona() {
        return persona;
    }

    public String getIdMuestra() { return idMuestra; }
    public void setIdMuestra(String idMuestra) { this.idMuestra = idMuestra; }

    public String getIdMedico() { return idMedico; }
    public void setIdMedico(String idMedico) { this.idMedico = idMedico; }

    public String getIdLaboratorio() { return idLaboratorio; }
    public void setIdLaboratorio(String idLaboratorio) { this.idLaboratorio = idLaboratorio; }

    public String getFechaMuestra() { return fechaMuestra; }
    public void setFechaMuestra(String fechaMuestra) { this.fechaMuestra = fechaMuestra; }

    @Override
    public String toString() {
        return "Muestra{" +
                "persona=" + persona +
                ", idMuestra='" + idMuestra + '\'' +
                ", idMedico='" + idMedico + '\'' +
                ", idLaboratorio='" + idLaboratorio + '\'' +
                ", fechaMuestra='" + fechaMuestra + '\'' +
                '}';
    }
}
