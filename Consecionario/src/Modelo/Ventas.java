package Modelo;

import java.util.Date;

public class Ventas {
    private Coche car;
    private Cliente client;
    private int id;
    private Date fecha;



    //Getters y Setters

    public Coche getCar() {
        return car;
    }

    public void setCar(Coche car) {
        this.car = car;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

//Constructor

    public Ventas(Coche car, Cliente client,  int id) {
        this.car = car;
        this.client = client;
        this.id = id;
        this.fecha = new Date();
    }

    public String toString() {
        return "id: " + id + "\n" +
                "Coche: " + car + "\n" +
                " | Cliente: " + client + "\n" +
                " | Fecha: " + fecha + "\n";
    }
}
