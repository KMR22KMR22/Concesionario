package Controlador;

import Modelo.Cliente;
import Modelo.Coche;
import Modelo.Ventas;
import Vista.Vista;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;


public class Concesionario {

    Scanner sc = new Scanner(System.in);

    private Vista vista;
    private double topPrice;

    //Creo el ArrayList de los coches
    static List<Coche> coches = new ArrayList<>();

    /**
     * Llena el arraylist (coches) con coches predeterminados para que cuando arranque el progreama el concesionario ya cuente con coches
     * */
    public void declaracionCoches() {
        coches.add(new Coche( "Lamborghini", "Gallardo", 2011, 100000, "1111ABC", false, 32000));
        coches.add(new Coche( "Lamborghini", "Aventador", 2021, 500000, "1111ABC", false, 0));
        coches.add(new Coche( "Porsche", "911", 2021, 90000, "1111ABC", false, 10000));
        coches.add(new Coche( "Porsche", "Cayanne - SUV", 2024, 95000, "1111ABC", false, 0));
        coches.add(new Coche( "BMW", "Serie 7 - Sedan", 2019, 123000, "1111ABC", false, 0));
        coches.add(new Coche( "BMW", "X7 - SUV", 2018, 104300, "1111ABC", false, 19000));
    }

    //Creo el ArrayList de los clientes
    public List<Cliente> clientes = new ArrayList<>();

    /**
     * Llena el arraylist (clientes) con clientes predeterminados para que cuando arranque el progreama el concesionario ya cuente con clientes
     * */
    public void declarateClients() {

        clientes.add(new Cliente("12345678A", "Kevin", "+34 1234567"));
        clientes.add(new Cliente("87654321B", "Maria", "+34 7654321"));

    }

    //Creo el ArrayList de las ventas
    public List<Ventas> ventas = new ArrayList<>();


    /**
     * Este es el run del programa
     * */
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


    /**
     * Añade un cocehe al concesionario (arraylist de coches) preguntandole al usuario por cada uno de los datos del coche que va a añadir*/
    public void addCar() {

        String brand = vista.askBrand();
        String model = vista.askmodel();
        int year;

        //Compruebo que cuando el usuario ponga el año del coche este no sea menor a 1900 o mayor a 2026
        while (true) {

            year = vista.askYear();

            if(year >= 1900 & year <= 2026) {

                break;
            }else {
                vista.wrongImput();
            }
        }

        double price;

        //Compruebo que cuando el usuario ponga el precio este no sea menor que 30000 (ya no es un precio demaciado bajo para un coche, y este es un concesoinario de lujo), y que no sea mayor a 30millones (ya que no hay coches de lujo que cuesten mas que eso)

        while (true) {

            price = vista.askPrice();

            if(price >= 30000 & price <= 30000000) {

                break;
            }else {
                vista.wrongImput();
            }
        }

        String numberPlate = vista.askNumberPlate();

        double km;

        //Compruebo que cuando el usuario ponga los km del coche estos no exedan los 60000 km ya que es demaciado uso para un coche que voy a vender en un concesionario de lujo

        while (true) {

            km = vista.askKm();

            if(km >= 0 & km <= 60000) {

                break;
            }else{
                vista.wrongImput();
            }
        }

        coches.add(new Coche(brand, model, year, price, numberPlate, false, km));

        //Compruebo los precios de todos los coches para saber cual es el mas alto y establecerlo como tope a la hora de buscar coches por precio
        for (Coche c : coches) {
            if(c.getPrice() > this.topPrice) {
                this.topPrice = c.getPrice();
            }
        }
    }

    /**
     * Muestra todos los coches disponibles para vender en el concesionario (los que tienen el atributo sold = false)
     *
     * @return Lista de coches no vendidos
     *     */
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



    /**
     * Busca los coches por marca, año, o preco*/
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
                int[] rango;
                int min;
                int max;
                boolean underPrice = true; //Esta variable es para ver si e
                // l precio maximo que ingreso el usuario es menor o mayor que el precio de mi coche mas caro

                while (true) {
                    rango = vista.searchCarsPrice();
                     min = rango[0];
                     max = rango[1];

                    if (min > 0){
                        break;
                    }else{
                        vista.wrongImput();
                    }
                }

                if (max > this.topPrice) {
                    underPrice = false;
                }

                for (Coche c : coches) {
                    if (c.getPrice() >= min && c.getPrice() <= max) {
                        cochesEncontrados.add(c);
                        found = true;

                    }
                }
                if (found) {
                    vista.showCars(cochesEncontrados);
                }

                if (!found && underPrice) {

                    vista.carNotFoundUnderPrice();
                }
                if (!found && !underPrice) {
                    vista.carNotFoundOverPrice();
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

                if (!found && (year > 1900 && year < 2026)) {
                    vista.yearNotFound();
                }
                if (!found && (year < 1900 || year > 2026)) {
                    vista.improbableYear();
                }
            }

            if (found || (userIput == 4)) {
                break;
            }

        }

    }

    /**
     * Agrega un cliente al arraylist de clientes
     * @return Cliente existente o cliente nuevo
     */
    public Cliente addClient() {
        boolean exists = false;
        String dni = "";
        Cliente client = null;
        dni = vista.addClientDni();

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                client = c;
                vista.existedClient();
                exists = true;
            }
        }
        if(!exists) {
            vista.askToLogin();
            clientes.add(new Cliente(dni, vista.addClientName(), vista.addClientPhone()));
            client = clientes.getLast();
        }
        return client;
    }


    /**
     * Vender los coches agregando las instancias del coche que se vendió y del cliente que lo compro, tambien el id de la venta y la fecha*/
    public void manageSale() {

        vista.askBeforSale();

        Cliente cliente = addClient();

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
            coches.get(choise - 1).setVendido(true);  //Ya que el coche se vendió convierto su atributo de vendido en true
            Coche coche = coches.get(choise - 1);

            int id = ventas.size() +1;  //Ya que voy a agregar una nueva venta el numero de esa venta sera igual a la cantidad de ventas que se se habian realizado + 1

            ventas.add(new Ventas(coche, cliente, id));

            vista.thanksForBuying();

        } else {
            vista.carsSoldOut();  //En caso de que no queden coches para vender es muestra un mensaje de coches agotados
        }
    }

    /**
     * Llama a la funcion de la vista que mustra el arraylist de ventas*/
    public void showSales() {

        vista.showSales(ventas);
    }


    //Constructor
    public Concesionario(Vista vista) {
        this.vista = vista;
        this.topPrice = 500000;
    }


}








