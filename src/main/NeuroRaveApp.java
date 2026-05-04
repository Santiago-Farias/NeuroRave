package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import model.BreakcoreTrack;
import model.DubstepTrack;
import model.PlaylistFileManager;
import model.Track;
import model.VocaloidTrack;

public class NeuroRaveApp {


    public static void main(String[] args) {
        
        int mainOption = 100;
        int genereOption = 100;
        String replacePlaylistOption;
        String artistTemp = "";
        String nameTemp = "";
        String genereTemp = "";
        String[] trackGeneres = {"Breakcore", "Dubstep", "Vocaloid"};
        String[] byeMessages = {"Bye!", "Cya!", "See you next time!", "Take care!", "Later!"};
        int bpmTemp = 0;
        int secDurationTemp = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Track> playList = new ArrayList<>();
        
        Random rdm = new Random();
        
        do {
            System.out.println("=== NEURORAVE v0.1 ===");
            System.out.println("1. Add track");
            System.out.println("2. Show playlist");
            System.out.println("3. Play the playlist");
            System.out.println("4. Play a specific track");
            System.out.println("5. Save playlist");
            System.out.println("6. Load playlist");
            System.out.println("7. Remove track");
            System.out.println("0. Exit");
            
            mainOption = requestValidIndex(scanner, 0, 7, "Enter your choice: ");
            
            //System.out.println(integerValidation("Ingrese el texto para parsear: "));
            
            if (mainOption == 0) {
                System.out.println("");
                for (int i = 0; i < 1; i++) {
                    int randomByeMessageIndex = rdm.nextInt(byeMessages.length);
                    System.out.println(byeMessages[randomByeMessageIndex]);
                }
            }
            
            if (mainOption == 1) { // if option is ADD TRACK
                System.out.println("");
                System.out.print("Enter the artist: ");
                artistTemp = scanner.nextLine();
                System.out.println("");
                System.out.print("Enter track name: ");
                nameTemp = scanner.nextLine();
                System.out.println("");
                
                // Genere menu loop
                for (int i = 0; i < trackGeneres.length; i++) {
                    System.out.println("[" + (i+1) + "] " + trackGeneres[i]);
                }
                genereOption = requestValidIndex(scanner, 1, trackGeneres.length, "Select the genere by entering a number: ");
                System.out.println("");
                bpmTemp = requestValidIndex(scanner, 0, 300, "Enter track bpm: ");
                System.out.println("");
                secDurationTemp = requestValidIndex(scanner, 0, 50000, "Enter track duration in seconds: ");
                
                // ideally, have a array with generes and validation in input
                switch (genereOption) {
                    case 1:
                        genereTemp = trackGeneres[0];
                        BreakcoreTrack breakcore = new BreakcoreTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(breakcore);
                        break;
                    case 2:
                        genereTemp = trackGeneres[1];
                        DubstepTrack dubstep = new DubstepTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(dubstep);
                        break;
                    case 3:
                        genereTemp = trackGeneres[2];
                        VocaloidTrack vocaloid = new VocaloidTrack(artistTemp, nameTemp, genereTemp, bpmTemp, secDurationTemp);
                        playList.add(vocaloid);
                        break;
                }
                
                System.out.println("\n" + genereTemp + " song added to playlist!\n");
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
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println("Current playlist:");
                    for (int i = 0; i < playList.size(); i++) {
                        System.out.println(playList.get(i).getArtist() + " - " + playList.get(i).getName());
                    }
                    System.out.println("");
                }
            }
            
            if (mainOption == 3) { // Play the playlist logic
                if (playList.isEmpty()) {
                    System.out.println("");
                    System.out.println("The playlist is empty!");
                    System.out.println("");
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
                    System.out.println("The playlist is empty!\n");
                } else {
                    System.out.println("");
                    System.out.println("Current songs in playlist: ");
                    showNumeredPlaylist(playList);
                    int validSongOption = requestValidIndex(scanner, 1, playList.size(), "Enter your choice: ");
                    playList.get(validSongOption-1).reproducir();
                }
            }
            
            if (mainOption == 5) { // Save playlist logic
                if (playList.isEmpty()) {
                    System.out.println("\nEmpty playlist! You must add songs first.\n");
                } else {
                    PlaylistFileManager.savePlaylist(playList);
                }
            }
            
            if (mainOption == 6) {// Load playlist logic
                
                try {
                    if (playList.isEmpty()) {
                        playList = PlaylistFileManager.loadPlaylist();
                    } else {
                        do {
                            System.out.print("The playlist has Tracks. Overwrite? (y/n): ");
                            replacePlaylistOption = scanner.nextLine();
                            if (replacePlaylistOption.equalsIgnoreCase("y")) {
                                playList = PlaylistFileManager.loadPlaylist();
                            }
                        } while (!replacePlaylistOption.equalsIgnoreCase("y") && !replacePlaylistOption.equalsIgnoreCase("n"));
                    }
                } catch (IOException e) {
                    System.out.println("Error loading playlist: " + e);
                }
            }
            
            if (mainOption == 7) { // Remove song from playlist logic
                if (playList.isEmpty()) {
                    System.out.println("");
                    System.out.println("The playlist is empty!\n");
                } else {
                    System.out.println("");
                    System.out.println("Current songs in playlist: ");
                    showNumeredPlaylist(playList);
                    int validSongOption = requestValidIndex(scanner, 1, playList.size(), "Enter your choice: ");
                    String removedTrackTemp = playList.get(validSongOption-1).getArtist() + " - " + playList.get(validSongOption-1).getName();
                    playList.remove(validSongOption-1);
                    System.out.println("The (" + removedTrackTemp + ") song was removed!");
                }
            }
            
            if (mainOption > 7) {
                System.out.println("\nWork in progress..\n");
            }
              
        } while (mainOption != 0);
        
    }
    
    public static void showNumeredPlaylist(ArrayList<Track> playList) {
        for (int i = 0; i < playList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + playList.get(i).getArtist() + " - " + playList.get(i).getName());
        }
    }
    
    public static int requestValidIndex(Scanner scanner, int inputMin, int inputMax, String inputText) { // if the inputMin is 0, and user enter text, this thing will show a error with 0 too
        String inputStringTemp;
        int stringConveted = 0;
        boolean stringConvertedFlag;
        
        do {
            stringConvertedFlag = true;
            System.out.print(inputText);
            inputStringTemp = scanner.nextLine();
        try {
            stringConveted = Integer.parseInt(inputStringTemp);
        } catch (NumberFormatException e) {
            System.out.println("Error converting '" + inputStringTemp + "' to an integer: " + e);
            stringConvertedFlag = false;
        } 
        
        if ((stringConveted < inputMin || stringConveted > inputMax)) {
            System.out.println("The '" + stringConveted + "' value is out of valid range! (Valid range: " + inputMin + " -> " + inputMax + ")");
            stringConvertedFlag = false;
        }
        } while (stringConvertedFlag == false);
        
        //System.out.println("Pudo convertir" + stringConvertedFlag);
        
        return stringConveted;
    }
    
    // Add more validations, e.g.: numbers inputs with limitations
}
