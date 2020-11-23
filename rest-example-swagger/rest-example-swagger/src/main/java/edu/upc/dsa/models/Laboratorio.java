package edu.upc.dsa.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Laboratorio {
    public String nombreLab;
    String idLab;

    @JsonIgnore
    private int numLabs = 0;

    //Guardar les dades dels productes afegits
    public Laboratorio(String nombreLab, String idLab) {
        this.nombreLab = nombreLab;
        this.idLab = idLab;
    }
    public Laboratorio(){}

    //Crear SET/GET de name, description, prize y num vendas
    public String getNombreLab() { return nombreLab; }

    public void setNombreLab(String nombreLab) { this.nombreLab = nombreLab; }

    public String getIdLab() { return idLab; }

    public void setIdLab(String idLab) { this.idLab = idLab; }

    public int getNumLabs() { return numLabs; }

    public void setNumLabs(int numLabs) {
        this.numLabs = numLabs;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "nombreLab='" + nombreLab + '\'' +
                ", idLab='" + idLab + '\'' +
                ", numLabs=" + numLabs +
                '}';
    }
}
