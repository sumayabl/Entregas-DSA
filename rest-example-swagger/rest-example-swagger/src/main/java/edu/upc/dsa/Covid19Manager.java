package edu.upc.dsa;

import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

import java.util.*;

public interface Covid19Manager {

    void addPersona(String idPersona, String nombre, String apellidos, int edad, String nivelSalud);
    Persona getPersona(String idPersona);

    void addLaboratorio(Laboratorio l);

    void addMuestra(String idPersona, Muestra m) throws PersonaNotFoundException;
    Muestra getMuestra();
    LinkedList<Muestra> getAllMuestrasOfAUser(String user) throws PersonaNotFoundException;

    List<Laboratorio> allLaboratorios();
    HashMap<String, Persona> allPersonas();
    int size();
}
