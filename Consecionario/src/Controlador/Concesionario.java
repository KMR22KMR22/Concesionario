package Controlador;

import Modelo.Cliente;
import Modelo.Coche;
import Modelo.Ventas;
import Vista.Vista;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Concesionario {

    Scanner sc = new Scanner(System.in);

    private Vista vista;

    //Creo el ArrayList de los coches
    static List<Coche> coches = new ArrayList<>();

    public void declaracionCoches() {
        coches.add(new Coche( "Lamborghini", "Gallardo", 2010, 100000, "1111ABC", false));
        coches.add(new Coche( "Lamborghini", "Aventador", 2021, 5000000, "1111ABC", false));
        coches.add(new Coche( "Porsche", "911", 2024, 90000, "1111ABC", false));
        coches.add(new Coche( "Porsche", "Cayanne - SUV", 2017, 95000, "1111ABC", false));
        coches.add(new Coche( "BMW", "Serie 7 - Sedan", 2019, 123000, "1111ABC", false));
        coches.add(new Coche( "BMW", "X7 - SUV", 2018, 104300, "1111ABC", false));
    }

    //Creo el ArrayList de los clientes
    public List<Cliente> clientes = new ArrayList<>();

    public void declarateClients() {

        clientes.add(new Cliente("12345678A", "Kevin", "+34 1234567"));
        clientes.add(new Cliente("87654321B", "Maria", "+34 7654321"));

    }

    //Creo el ArrayList de las ventas
    public List<Ventas> ventas = new ArrayList<>();


    //Programa

    public void run() {

        while (true) {

            int userInput;

            try {
                userInput = vista.menu();
                if (userInput >= 1 && userInput <= 7) {

                    if (userInput == 1) {
                        addCar();
                    }
                    if (userInput == 2) {
                        showCars();
                    }
                    if (userInput == 3) {
                        searchCars();
                    }
                    if (userInput == 4) {
                        addClient();
                    }
                    if (userInput == 5) {
                        manageSale();
                    }
                    if (userInput == 6) {
                        showSales();
                    }
                    if (userInput == 7) {
                        break;
                    }
                } else {
                    vista.wrongImput();
                }

            } catch (Exception e) {
                vista.wrongImput();
                sc.nextLine();       //Pongo este nextLine porque si no me hace un bucle infinito mostrando el error constantemente
            }
        }
    }


    public void addCar() {
        coches.add(new Coche(vista.askBrand(), vista.askmodel(), vista.askYear(), vista.askPrize(), vista.askNumberPlate(), false));
    }


    public ArrayList<Coche> showCars() {
        List<Coche> cochesNoVendidos = new ArrayList<>();
        for (Coche c : coches) {
            if (!c.isVendido()) {
                cochesNoVendidos.add(c);
            }
        }
        if (!cochesNoVendidos.isEmpty()) {
            vista.showCars(cochesNoVendidos);

        } else {
            vista.carsSoldOut();
        }
        return (ArrayList<Coche>) cochesNoVendidos;
    }



    //Buscar coches
    public void searchCars() {

        boolean found = false;

        while (true) {

            ArrayList<Coche> cochesEncontrados = new ArrayList<>();

            //Por Marca
            int userIput = vista.searchCars();

            if (userIput == 1) {
                String brand = vista.askBrand();

                for (Coche c : coches) {
                    if (c.getBrand().toLowerCase().contains(brand)) {
                        cochesEncontrados.add(c);
                        found = true;
                    }
                }
                if (found) {
                    vista.showCars(cochesEncontrados);

                } else {
                    vista.carNotFoundBrand(brand);
                }
            }

            //Por Precio
            if (userIput == 2) {

                int[] rango = vista.searchCarsPrize();

                int min = rango[0];
                int max = rango[1];

                boolean underPrize = true;

                if (max > 500000) {
                    underPrize = false;
                }

                for (Coche c : coches) {
                    if (c.getPrize() >= min && c.getPrize() <= max) {
                        cochesEncontrados.add(c);
                        found = true;

                    }
                }
                if (found) {
                    vista.showCars(cochesEncontrados);
                }

                if (!found && underPrize) {

                    vista.carNotFoundUnderPrize();
                }
                if (!found && !underPrize) {
                    vista.carNotFoundOverPrize();
                }
            }

            //Por año
            if (userIput == 3) {
                int year = vista.searchCarsYear();

                for (Coche c : coches) {
                    if (c.getYear() == year) {
                        cochesEncontrados.add(c);
                        found = true;

                    }
                }
                if (found) {
                    vista.showCars(cochesEncontrados);
                }

                if (!found && (year > 2000 && year < 2026)) {
                    vista.yearNotFound();
                }
                if (!found && (year < 2000 || year > 2026)) {
                    vista.improbableYear();
                }
            }

            if (found) {
                break;
            }

        }

    }


    public boolean addClient() {
        boolean exists = false;
        String dni = "";
        dni = vista.addClientDni();

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                vista.existentClientDni();
                exists = true;
            }
        }
        if(!exists) {
            clientes.add(new Cliente(dni, vista.addClientName(), vista.addClientPhone()));
        }
        return exists;
    }


    //Vender Coche
    public void manageSale() {

        //Pedir el dni del cliente para ver si esta guardado o es un nuevo cliente
        boolean ourClient = false;
        Cliente cliente = null;

        String dni = vista.askForDni();

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                vista.existedClient();
                cliente = c;
                ourClient = true;
            }
        }
        if (!ourClient) {
            vista.askToLogin();
            cliente = new Cliente(dni, vista.addClientName(), vista.addClientPhone());

            clientes.add(cliente);
        }

        //Revisar que coches no se han vendido y mostrarlos

        List<Coche> carsForSale = new ArrayList<>();

        carsForSale = showCars();

        if (!carsForSale.isEmpty()) {

            int choise = 0;

            while (true) {
                choise = vista.askToPickCar();
                if (choise <= 0 || choise >= coches.size()) {
                    vista.wrongImput();
                } else {
                    break;
                }
            }

            //Guardar las ventas en el arraylist de ventas
            coches.get(choise - 1).setVendido(true);
            Coche coche = coches.get(choise - 1);

            int id = ventas.size() +1;

            ventas.add(new Ventas(coche, cliente, id));

            vista.thanksForBuying();

        } else {
            vista.carsSoldOut();
        }
    }

    //Mostrar Ventas
    public void showSales() {

        vista.showSales(ventas);
    }


    //Constructor
    public Concesionario(Vista vista) {
        this.vista = vista;
    }
}








