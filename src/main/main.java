package main;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        
        int opcion = 100;
        
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("=== NEURORAVE v0.1 ===");
            System.out.println("1. Add track");
            System.out.println("2. Show playlist");
            System.out.println("3. Play the playlist");
            System.out.println("4. Play a specific track");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            opcion = scanner.nextInt();
            
            if (opcion != 0) {
                System.out.println("\nWork in progress..\n");
            }
            
        } while (opcion != 0);
        
        
        
    }
    
}
