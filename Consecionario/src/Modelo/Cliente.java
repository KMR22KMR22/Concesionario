package Modelo;

public class Cliente {
    private String dni;
    private String name;
    private String phone;

    //Getters and Setters


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getPhone() {
        return phone;
    }

    //Constructor

    public Cliente(String dni, String nombre, String phone) {
        this.dni = dni;
        this.name = nombre;
        this.phone = phone;
    }

    public String toString() {
        return "nombre: " + name +
                " | dni: " + dni +
                " | telefono: " + phone + "\n";
    }
}

