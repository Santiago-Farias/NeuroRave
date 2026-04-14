package main;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        
        int opcion = 100;
        
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("=== NEURORAVE v0.1 ===" +
                "\n1. Agregar Track" +
                "\n2. Ver playlist" +
                "\n3. Reproducir playlist completa" +
                "\n0. Salir");
            
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            
            if (opcion != 0) {
                System.out.println("\nProyecto en desarrollo..\n");
            }
            
        } while (opcion != 0);
        
        
        
    }
    
}
