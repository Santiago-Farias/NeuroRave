package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.BreakcoreTrack;
import model.DubstepTrack;
import model.Track;
import model.VocaloidTrack;

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
            scanner.nextLine();
            
            if (mainOption == 1) { // if option is ADD TRACK
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
                } while (genereOption < 1 && genereOption > 3);
                System.out.println("");
                System.out.println("Enter track bpm: ");
                bpmTemp = scanner.nextInt();
                System.out.println("");
                System.out.println("Enter track duration in seconds: ");
                secDurationTemp = scanner.nextInt();
                
                // ideally, have a array with generes and validation in input
                switch (genereOption) {
                    case 1:
                        genereTemp = "Breakcore";
                        BreakcoreTrack breakcore = new BreakcoreTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(breakcore);
                        break;
                    case 2:
                        genereTemp = "Dubstep";
                        DubstepTrack dubstep = new DubstepTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(dubstep);
                        break;
                    case 3:
                        genereTemp = "Vocaloid";
                        VocaloidTrack vocaloid = new VocaloidTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(vocaloid);
                        break;
                }
                
                System.out.println(genereTemp + " song added to playlist!");
                artistTemp = "";
                nameTemp = "";
                genereTemp = "";
                bpmTemp = 0;
                secDurationTemp = 0;
            }
            
            if (mainOption == 2) { // Show playlist logic
                if (playList.isEmpty()) {
                    System.out.println("");
                    System.out.println("The playlist is empty!");
                } else {
                    System.out.println("Current playlist:");
                    for (int i = 0; i < playList.size(); i++) {
                        System.out.println(playList.get(i).getArtist() + " - " + playList.get(i).getName());
                    }
                }
            }
            
            if (mainOption != 0) {
                System.out.println("\nWork in progress..\n");
            }
            
        } while (mainOption != 0);
        
        
        
    }
    
}
