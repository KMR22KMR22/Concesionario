package Vista;

import Modelo.Coche;
import Modelo.Ventas;

import java.util.List;
import java.util.Scanner;



public class Vista {

    static Scanner sc = new Scanner(System.in);

    /**
     * Muestra el menu
     *
     * @return La opcion que eligió el usuario*/
    public int menu(String RESET, String Blue) {
        System.out.println(Blue + " " + "=========================" + RESET);
        System.out.println(Blue + "||" + RESET + "Bienvenisdo a UniqueCars" + Blue + "||" + RESET);
        System.out.println(Blue + " " + "=========================" + RESET);
        System.out.println("");
        System.out.println("Sleccione que quiere realizar:");
        System.out.println(Blue + "+" + "----------------------------------" + "+" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "1. Añadir coches al concesionario" + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "2. Mostar los coches disponibles " + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "3. Buscar coches disponibles     " + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "4. Registrar un nuevo cliente    " + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "5. Registrar una venta           " + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "6. Listar ventas                 " + Blue + "|" + RESET);
        System.out.println(Blue + "|" + "----------------------------------" + "|" + RESET);
        System.out.println(Blue + "|" + RESET + " " + "7. Salir                         " + Blue + "|" + RESET);
        System.out.println(Blue + "+" + "----------------------------------" + "+" + RESET);


        int userImput = sc.nextInt();
        sc.nextLine();

        return userImput;
    }




    /**
     * Muestra mensaje de error
     *
     * @param message*/
    public void showErrorMessage(String message) {
        System.err.println(message);
    }



    /**
     * Muestra el mensaje de coches agotados cuando no quedan coches con el atributo sold = false*/
    public void carsSoldOut(){
        System.out.println("Lo sentimos, no tenemos coches disponibles");
    }




    //Agregar Coche
    /**
     * Pide la marca del coche que se quiere agragar
     * @return marca*/
    public String askBrand() {

        System.out.println("Que marca es el coche");
        String brand = sc.nextLine();
        return brand;
    }
    /**
     * Pide el modelo del coche que se quiere agragar
     * @return moelo*/
    public String askmodel() {

        System.out.println("Que modelo es el coche");
        String model = sc.nextLine();
        return model;
    }
    /**
     * Pide el año del coche que se quiere agragar
     * @return año*/
    public int askYear() {

        System.out.println("De que año es el coche");
        int year = sc.nextInt();
        sc.nextLine();
        return year;
    }
    /**
     * Pide el precio del coche que se quiere agragar
     * @return precio*/
    public double askPrice() {

        System.out.println("Que precio tiene");
        double prize = sc.nextDouble();
        sc.nextLine();
        return prize;
    }
    /**
     * Pide la matrícula del coche que se quiere agragar
     * @return matricula*/
    public String askNumberPlate() {

        System.out.println("Dime numero de la matricula");
        String NumberPlate = sc.nextLine();
        return NumberPlate;
    }
    /**
     * Pide los kilometros recorridos por coche que se quiere agragar
     * @return kilometros*/
    public double askKm() {
        System.out.println("Cuantos Kilometros tiene");
        double km = sc.nextDouble();
        sc.nextLine();
        return km;
    }




    /**
     * Muestra la lista de coches
     *
     * @param coches* */
    public void showCars(List<Coche> coches) {
        for(int i = 0; i < coches.size(); i++) {

            System.out.println((i+1) + coches.get(i).toString());
        }
    }





    //Buscar Coches
    /**
     * Muestra un menu secundario cuando el usuario elige la opcion de buscar coches, para que introduzca de que manera lo quiere buscar
     *
     * @return eleccion del usuario*/
    public int searchCars(){
        System.out.println("Elige como quieres buscar el coche");
        System.out.println("------------------------------------");
        System.out.println("1. Por la marca");
        System.out.println("2. Por el precio");
        System.out.println("3. Por el año");
        System.out.println("4. Regresar");

        int userImput = sc.nextInt();
        sc.nextLine();
        return userImput;
    }
    /**
     * Muestra un mensaje de que no se encontraron coches*/
    public void carNotFoundBrand(String brand) {
        System.out.println("Lo siento, no tenemos coches de la marca " + brand + " actualmente");
    }
    /**
     *Una vez que el usuario ha elegido buscar el coche por precio se le pide que ingrese el valor minimo y el valor maximo que esta dispuesto a pagar
     *
     *@return valor minimo y valor maximo en un array */
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
    /**
     * Muestra un mensaje de que no pudo encontrar un coche tan barato*/
    public void carNotFoundUnderPrice() {
        System.err.println("Lo siento, no tenemos un coche tan barato como ese");
    }
    /**
     * Muestra un mensaje de que no pudo encontrar un coche tan caro*/
    public void carNotFoundOverPrice(){
        System.err.println("Lo siento, no tenemos ningun coche tan caro como ese");
    }
    /**
     * Muestra el mensaje para saber de que año es el coche que el usuario esta buscando
     *
     * @return año*/
    public int searchCarsYear() {

        System.out.println("De que año estas buscando tu coche");
        System.out.println("-------------------------");
       int year = sc.nextInt();
        sc.nextLine();
       return year;
    }
    /**
     * Muestra el mensaje para cuando no se encuentra un coche que corresponda con el año buscado
     */
    public void yearNotFound() {
        System.err.println("Lo siento, no tenemos coches de ese año");
    }
    /**
     * Muestra un mensaje para cuando el usuario introduce un año imposible*/
    public void improbableYear() {
        System.err.println("Año incorrecto");
    }






    //Clientes
    /**
     * Muestra un mensaje pidiendo el dni del cliente
     *
     * @return dni del cliente*/
    public String addClientDni() {
        System.out.println("Introduce el dni del cliente");
        String dni = sc.nextLine();
        return dni;
    }
    /**
     * Muestra un mensaje pidiendo el nombre del cliente
     *
     * @return nombre del cliente*/
    public String addClientName(){
        System.out.println("Introduce el nombre ");
        String name = sc.nextLine();
        return name;
    }
    /**
     * Muestra un mensaje pidiendo el telefono del cliente
     *
     * @return telefono del cliente*/
    public String addClientPhone(){
        System.out.println("Introduce el telefono ");
        String phone = sc.nextLine();
        return phone;
    }
    /**
     * Muestra un mensaje de cliente existente*/
    public void existedClient(){
        System.out.println("Veo que ya es cliente nuestro");
        System.out.println("------------------------------");
    }
    /**
     * Muestra un mensaje para cuando detecte que es un cliente nuevo*/
    public void askToLogin(){
        System.out.println("Veo que es un nuevo cliente");
        System.out.println("----------------------------");
        System.out.println("Por favor introduzca sus datos:");
        System.out.println("-------------------------------");
    }





    //Vender Coche
    /**
     * Muestra el mensaje que le pongo al usuario cuadno quiere realizar una compra*/
    public void askBeforSale(){
        System.out.println("Antes de mostrarle los coches necesito el dni del cliente para identificarlo");
        System.out.println("-----------------------------------------------------------------");
    }
    /**
     * Mensaje que se muestra antes de mostrar los coches disponibles*/
    public void messageToBuy(){
        System.out.println("A continuacion te muestro todos los coches que tenemos disponibles:");
        System.out.println("-------------------------------------------------------------------");
    }
    /**
     * Le pido al usuario que elija el coche que quiere comprar
     *
     * @return opcion del usuario*/
    public int askToPickCar(){
        System.out.println("----------------------------------------------");
        System.out.println("Introduce el numero del coche que te interesa");
        System.out.println("----------------------------------------------");
        int userImput = sc.nextInt();
        sc.nextLine();
        return userImput;
    }
    /**
     * Mensaje de agradecimiento que se le muestra al usuario una vez realizada una venta*/
    public void thanksForBuying(){
        System.out.println("==================================================================");
        System.out.println("Muchas gracias por comprar nuestros coches. Que tenga un buen dia");
        System.out.println("==================================================================");
    }




    //Mostrar Ventas
    /**
     * Muestra todas las ventas registradas
     *
     * @param ventas*/
    public void showSales(List<Ventas> ventas){

        for (Ventas v : ventas) {

            System.out.println("---------------------------------------------------------------------");
            System.out.println(v);
            System.out.println("---------------------------------------------------------------------");
        }

    }

}
