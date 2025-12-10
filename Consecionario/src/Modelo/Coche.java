package Modelo;

public class Coche {
    private String brand;
    private String model;
    private int year;
    private double prize;
    private String numberPlate;
    private boolean sold;


    //Getters and Setters



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public boolean isVendido() {
        return sold;
    }

    public void setVendido(boolean vendido) {
        this.sold = vendido;
    }

    //Controller
    public Coche(String brand, String model, int year, double prize,  String numberPlate,  boolean sold) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.prize = prize;
        this.numberPlate = numberPlate;
        this.sold = sold;
    }

    public String toString() {
        return ": Marca: " + brand +
                " | Modelo: " + model +
                " | Año: " + year +
                " | Precio: " + prize +
                " | Matrícula: " + numberPlate + "\n";
    }
}
