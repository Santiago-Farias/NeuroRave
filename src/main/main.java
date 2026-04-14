package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Track;

public class main {


    public static void main(String[] args) {
        
        int mainOption = 100;
        int genereOption = 100;
        String artistTemp = "";
        String nameTemp = "";
        String genereTemp = "";
        int bpmTemp = 0;
        int secDurationTemp = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Track> playList = new ArrayList<>();
        
        do {
            System.out.println("=== NEURORAVE v0.1 ===");
            System.out.println("1. Add track");
            System.out.println("2. Show playlist");
            System.out.println("3. Play the playlist");
            System.out.println("4. Play a specific track");
            System.out.println("0. Exit");
            
            System.out.print("Enter your choice: ");
            mainOption = scanner.nextInt();
            
            if (mainOption == 1) {
                System.out.println("");
                System.out.println("Enter the artist: ");
                artistTemp = scanner.nextLine();
                System.out.println("");
                System.out.println("Enter track name: ");
                nameTemp = scanner.nextLine();
                System.out.println("");
                
                // Genere menu loop
                do {
                    System.out.println("1. Breakcore");
                    System.out.println("2. Dubstep");
                    System.out.println("3. Vocaloid");
                    System.out.println("Select the genere by entering a number: ");
                    genereOption = scanner.nextInt();
                } while (genereOption >= 1 && genereOption <= 3);
                System.out.println("");
                System.out.println("Enter track bpm: ");
                bpmTemp = scanner.nextInt();
                System.out.println("");
                System.out.println("Enter track duration in seconds: ");
                secDurationTemp = scanner.nextInt();
                
                // ideally, have a array with generes and validation in input
                switch (genereOption) {
                    case 1 -> genereTemp = "Breakcore";
                    case 2 -> genereTemp = "Dubstep";
                    case 3 -> genereTemp = "Vocaloid";
                    default -> {
                    }
                }
            }
            
            if (mainOption != 0) {
                System.out.println("\nWork in progress..\n");
            }
            
        } while (mainOption != 0);
        
        
        
    }
    
}
