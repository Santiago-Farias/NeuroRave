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
        int songOption = 10000;
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
                System.out.print("Enter the artist: ");
                artistTemp = scanner.nextLine();
                System.out.println("");
                System.out.print("Enter track name: ");
                nameTemp = scanner.nextLine();
                System.out.println("");
                
                // Genere menu loop
                do {
                    System.out.println("1. Breakcore");
                    System.out.println("2. Dubstep");
                    System.out.println("3. Vocaloid");
                    System.out.print("Select the genere by entering a number: ");
                    genereOption = scanner.nextInt();
                } while (genereOption < 1 || genereOption > 3);
                System.out.println("");
                System.out.print("Enter track bpm: ");
                bpmTemp = scanner.nextInt();
                System.out.println("");
                System.out.print("Enter track duration in seconds: ");
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
                    System.out.println("");
                    System.out.println("Current playlist:");
                    for (int i = 0; i < playList.size(); i++) {
                        System.out.println(playList.get(i).getArtist() + " - " + playList.get(i).getName());
                    }
                }
            }
            
            if (mainOption == 3) { // Play the playlist logic
                if (playList.isEmpty()) {
                    System.out.println("");
                    System.out.println("The playlist is empty!");
                } else {
                    System.out.println("");
                    System.out.println("Current playlist:");
                    for (int i = 0; i < playList.size(); i++) {
                        playList.get(i).reproducir();
                    }
                }
            }
            
            if (mainOption == 4) { // Play specific song logic
                if (playList.isEmpty()) {
                    System.out.println("");
                    System.out.println("The playlist is empty!");
                } else {
                    System.out.println("");
                    System.out.println("Current song in playlist: ");
                    for (int i = 0; i < playList.size(); i++) {
                        System.out.println("[" + (i+1) + "] " + playList.get(i).getArtist() + " - " + playList.get(i).getName());
                    }
                    do {
                    System.out.print("Choose a song: ");
                    songOption = scanner.nextInt();
                    } while (songOption < 1 || songOption > (playList.size()));
                }
                for (int i = 1; i <= playList.size(); i++) {
                    if (i == songOption) {
                        playList.get(songOption).reproducir();                    
                    }
                }
            }
            
            if (mainOption != 0) {
                System.out.println("\nWork in progress..\n");
            }
            
        } while (mainOption != 0);
        
        
        
    }
    
}
