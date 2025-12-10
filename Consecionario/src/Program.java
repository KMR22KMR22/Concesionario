import Vista.Vista;
import  Controlador.Concesionario;

public class Program {

    public static void main(String[] args) {

        Vista vista = new Vista();
        Concesionario concesionario = new Concesionario(vista);

        concesionario.declaracionCoches();  // llenar la lista de coches
        concesionario.declarateClients();   // llenar la lista de clientes
        concesionario.run();

    }
}
