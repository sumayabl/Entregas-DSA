package edu.upc.dsa;

import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

import java.util.*;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {

    //We call the log4j properties file
    final static Logger log = Logger.getLogger(Covid19ManagerImpl.class);

    //Inicializar instancia
    private static Covid19Manager instance;

    final List<Laboratorio> laboratorios;
    final LinkedList<Muestra> muestras;
    final HashMap<String, Persona> personas;

    //De la interficie Gestor retorna objeto
    public static Covid19Manager getInstance() {
        if (instance == null) instance = new Covid19ManagerImpl(); //Generamos una nueva instancia(objeto)
        return instance;
    }

    public Covid19ManagerImpl() {                           //Inicialitzar contenidors per evitar errors
        this.personas = new HashMap<>();   //Per buscar personas amb id determinada
        this.laboratorios = new ArrayList<>();
        this.muestras = new LinkedList<>();
    }

    public int size() {
        log.info("Tamaño: " + this.laboratorios.size());
        return this.laboratorios.size();
    }

    @Override                                            //Funció:Afegir new user a la taula
    public void addPersona(String idPersona, String nombre, String apellidos, int edad, String nivelSalud) {
        log.info("New user: " + nombre);
        personas.put(idPersona, new Persona(idPersona, nombre, apellidos, edad, nivelSalud));
        log.info("new user added");
    }


    @Override
    public Persona getPersona(String idPersona) {       //Obtenir user de taula amb id proporcionat
        log.info("getPersona(" + idPersona + ")");
        Persona persona = this.personas.get(idPersona);
        log.info("Persona: " + persona);
        return persona;
    }

    @Override
    public HashMap<String, Persona> allPersonas(){
        for (Map.Entry<String, Persona> stringUserEntry : personas.entrySet()) {
            log.info(((Map.Entry) stringUserEntry).getKey() + " " + ((Map.Entry) stringUserEntry).getValue());
        }
        return null;
    }

    public void addLaboratorio(Laboratorio l) {
        log.info("Producto añadido: " + l);
        this.laboratorios.add(l);
    }

    //Dar info laboratorio respecto a nombre laboratorio
    private Laboratorio getLaboratorio(String laboratorio) {
        log.info("Laboratorio escogido: " + laboratorio);
        //log.degug("I'm in");
        Laboratorio l = null;
        for (Laboratorio laboratory : this.laboratorios) {
            if (laboratorio.equals(laboratory.nombreLab)) {
                l = laboratory;
            }
        }
        log.info("Información de los nombres y cantidad de cada producto: " + l);
        return l;
    }

    @Override
    public List<Laboratorio> allLaboratorios() {
        List<Laboratorio> ret = new ArrayList<>(this.laboratorios);
        log.info("Todos los products: " + ret);
        return ret;
    }

    @Override
    public void addMuestra(String idPersona, Muestra m) throws PersonaNotFoundException {
        //Buscar el usuario
        Persona laPersona = this.personas.get(idPersona);
        log.info("Persona dada: " + laPersona);

        //Miramos si ya esta
        if (laPersona != null) {
            //Asignamos el pedido con el ususario
            m.setPersona(laPersona);
            this.muestras.add(m);
            log.info("Muestra hecha: " + this.muestras);
        }
        //Si es nuevo el usuario
        else {
            log.error("UserNotFound");
            throw new PersonaNotFoundException();
        }
    }

//    @Override                                  //Ordenar (sort) abans de return productes
//    public List<Product> productsByPrize() {
//        log.info("Lista sin cambios: " + this.products);
//
//        //Crear una copia de la lista para modificarla por orden
//        List<Product> ret = new ArrayList<>(this.products);
//
//        //Function to compare the salary
//        ret.sort((pr1, pr2) -> (int) (pr1.getPrize() - pr2.getPrize()));
//
//        log.info("Lista ordenada precio ASC: " + ret);
//        return ret;
//        //Perdem precisió al pasar-ho a enter (petit error). Ordre invers-->*-1
//    }

//    @Override                                  //Ordenar (sort) abans de return productes
//    public List<Product> productsBySales() {
//        log.info("Lista antes de cambios: "+ this.products);
//        //Crear una copia de la lista para modificarla por orden
//        List<Product> ret = new ArrayList<>(this.products);
//
//        //Function to compare the salary
//        ret.sort((pr1, pr2) -> (-1) * (pr1.getNumVendes() - pr2.getNumVendes()));
//        log.info("Lista ordenada por ventas DESC: " + ret);
//        return ret;
//    }
     //Funció:Afegir new order a la cua "FIFO"

//    private void process(Muestra o) {       //Desempaquetar l'ordre
//        log.info("2. Entramos al proceso");
//        log.info("Ver la muestra: " + o);
//
//        Laboratorio laboratorio = this.getLaboratorio();
//        }

    public Muestra getMuestra(){
        Muestra o =this.muestras.pop();     //Obtenir element que está al cap de la cua
        log.info("Order served: " + o);

//        log.info("1Intentamos entrar al proces");
//        process(o);                    //Procesar la comanda obtinguda: saber qui la fet
//        log.info("3Volvemos a entrar a la funcion servir pedido");

        //Añadimos el pedido a la lista de pedidos del usuario
        Persona u = o.getPersona();
        log.info("Usuario: " + u);
        u.addMuestra(o);                //Aixi afegir dintre del user la order que s'ha completat
        return o;
    }

    public LinkedList<Muestra> getAllMuestrasOfAUser(String persona) throws PersonaNotFoundException{
        LinkedList<Muestra> muestras;
        //We want to find the given user
        Persona laPersona = this.personas.get(persona);
        log.info("Persona dada: " + laPersona);

        if(laPersona!=null){
            log.info("Persona prueba: " + laPersona);
            muestras = laPersona.getMuestraList();
        }
        else {
            throw new PersonaNotFoundException();
        }
        log.info("Historial de lista muestras: " +muestras);
        return muestras;
    }
}

