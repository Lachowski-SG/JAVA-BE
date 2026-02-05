package bedu;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Cliente base = new Cliente("4599", 200000);
        Cajero cajero = new Cajero(base);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingresa tu NIP: ");

            String entrada = sc.nextLine();

            if (!cajero.validarNip(entrada)){
                System.out.println("NIP incorrecto");
                return; //Termina la ejecución
            }
            System.out.println("Saldo: " + base.getSaldo());
        }
    }
}
