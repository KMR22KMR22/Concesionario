package Vista;

import Modelo.Coche;
import Modelo.Ventas;

import java.util.List;
import java.util.Scanner;



public class Vista {

    //Declaracion de variables que guardan los colores en codigo ANSI para daerle color al menu
    public static final String RESET = "\u001B[0m";
    public static final String Blue = "\u001B[34m";

    static Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println(Blue + " " + "=========================" + RESET);
        System.out.println(Blue + "||" + RESET + "Bienvenisdo a UniqueCars" + Blue + "||" + RESET);
        System.out.println(Blue + " " + "=========================" + RESET);
        System.out.println("");
        System.out.println("Sleccione que quiere realizar:");
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "1. Añadir coches al concesionario" + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "2. Mostar los coches disponibles " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "3. Buscar coches disponibles     " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "4. Registrar un nuevo cliente    " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "5. Registrar una venta           " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "6. Listar ventas                 " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "7. Salir                         " + Blue + "|" + RESET);
        System.out.println(Blue + "------------------------------------" + RESET);


        int userImput = sc.nextInt();
        sc.nextLine();

        return userImput;
    }




    //Valor no admitido
    public void wrongImput(){
        System.err.println("Valor no admitido");
    }


    //Coches agotados
    public void carsSoldOut(){
        System.out.println("Lo sentimos, no tenemos coches disponibles");
    }




    //Agregar Coche
    public String askBrand() {

        System.out.println("Que marca es el coche");
        String brand = sc.nextLine();
        return brand;
    }
    public String askmodel() {

        System.out.println("Que modelo es el coche");
        String model = sc.nextLine();
        return model;
    }
    public int askYear() {

        System.out.println("De que año es el coche");
        int year = sc.nextInt();
        sc.nextLine();
        return year;
    }
    public double askPrice() {

        System.out.println("Que precio tiene");
        double prize = sc.nextDouble();
        sc.nextLine();
        return prize;
    }
    public String askNumberPlate() {

        System.out.println("Dime numero de la matricula");
        String NumberPlate = sc.nextLine();
        return NumberPlate;
    }
    public double askKm() {
        System.out.println("Cuantos Kilometros tiene");
        double km = sc.nextDouble();
        sc.nextLine();
        return km;
    }




    //Mostrar lista de coches
    public void showCars(List<Coche> coches) {
        for(int i = 0; i < coches.size(); i++) {

            System.out.println((i+1) + coches.get(i).toString());
        }
    }





    //Buscar Coches
    public int searchCars(){
        System.out.println("Elige como quieres buscar el coche");
        System.out.println("------------------------------------");
        System.out.println("1. Por la marca");
        System.out.println("2. Por el precio");
        System.out.println("3. Por el año");
        System.out.println("4. Salir");

        int userImput = sc.nextInt();
        sc.nextLine();
        return userImput;
    }
    //Por marca
    public void carNotFoundBrand(String brand) {
        System.out.println("Lo siento, no tenemos coches de la marca " + brand + " actualmente");
    }
    //Por precio
    public int[] searchCarsPrice() {
        System.out.println("Dame un rango de precios:");
        System.out.println("-------------------------");
        System.out.println("Valor minimo:");
        int min = sc.nextInt();
        sc.nextLine();
        System.out.println("Valor maximo:");
        int max = sc.nextInt();
        sc.nextLine();

        int[] range = new int[2];
        range[0] = min;
        range[1] = max;

        return range;
    }
    public void carNotFoundUnderPrice() {

        System.err.println("Lo siento, no tenemos un coche tan barato como ese");
    }
    public void carNotFoundOverPrice(){
        System.err.println("Lo siento, no tenemos ningun coche tan caro como ese");
    }
    //por año
    public int searchCarsYear() {

        System.out.println("De que año estas buscando tu coche");
        System.out.println("-------------------------");
       int year = sc.nextInt();
        sc.nextLine();
       return year;
    }
    public void yearNotFound() {
        System.err.println("Lo siento, no tenemos coches de ese año");
    }
    public void improbableYear() {
        System.err.println("Año incorrecto");
    }




    //Clientes
    public String addClientDni() {
        System.out.println("Introduce el dni del cliente");
        String dni = sc.nextLine();
        return dni;
    }
    public String addClientName(){
        System.out.println("Introduce el nombre ");
        String name = sc.nextLine();
        return name;
    }
    public String addClientPhone(){
        System.out.println("Introduce el telefono ");
        String phone = sc.nextLine();
        return phone;
    }
    public void existentClientDni(){
        System.err.println("Ese cliente ya existe");
    }




    //Vender Coche
    public String askForDni(){
        System.out.println("Antes de mostrarle los coches necesito el dni del cliente para identificarlo");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Introduzcalo por favor");
        String dni = sc.nextLine();
        return dni;
    }
    public void existedClient(){
        System.out.println("Veo que ya es cliente nuestro");
        System.out.println("------------------------------");
    }
    public void askToLogin(){
        System.out.println("Veo que es un nuevo cliente");
        System.out.println("----------------------------");
        System.out.println("Por favor introduzca sus datos:");
        System.out.println("-------------------------------");
    }
    public void messageToBuy(){
        System.out.println("A continuacion te muestro todos los coches que tenemos disponibles:");
        System.out.println("-------------------------------------------------------------------");
    }
    public void showCarsWithOrder(Coche c, int contador){
        System.out.println(contador + ": " + c);
    }
    public int askToPickCar(){
        System.out.println("----------------------------------------------");
        System.out.println("Introduce el numero del coche que te interesa");
        System.out.println("----------------------------------------------");
        int userImput = sc.nextInt();
        sc.nextLine();
        return userImput;
    }
    public void thanksForBuying(){
        System.out.println("==================================================================");
        System.out.println("Muchas gracias por comprar nuestros coches. Que tenga un buen dia");
        System.out.println("==================================================================");
    }




    //Mostrar Ventas
    public void showSales(List<Ventas> ventas){

        for (Ventas v : ventas) {

            System.out.println("---------------------------------------------------------------------");
            System.out.println(v);
            System.out.println("---------------------------------------------------------------------");
        }

    }
}
