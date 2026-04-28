package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PlaylistFileManager {
    
    public static void savePlaylist(ArrayList<Track> playlist) {
        try {
            FileWriter playlistFileWriter = new FileWriter("playlist.txt", false);
            for (Track track : playlist) {
                playlistFileWriter.write(track.toString());
                playlistFileWriter.write("\n");
                
            }
            playlistFileWriter.close();
            System.out.println("");
            System.out.println("Playlist succefully saved!\n");
        } catch (IOException e) {
            System.out.println("The track could be not be saved: " + e);
        }
    }
    
    public static ArrayList<Track> loadPlaylist() throws IOException {
        ArrayList<Track> playlistEmpty = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("playlist.txt"))){
            String brString;
            while ((brString = br.readLine()) != null) {
                // Add the load tracks to objects logic
                String[] savedTextData = brString.split("\\|");
                
                switch (savedTextData[0]) {
                    case "Breakcore":
                        BreakcoreTrack breakcore = new BreakcoreTrack(savedTextData[1], savedTextData[2], savedTextData[0], Integer.parseInt(savedTextData[3]), Integer.parseInt(savedTextData[4]));
                        playlistEmpty.add(breakcore);
                        break;
                    case "Dubstep":
                        DubstepTrack dubstep = new DubstepTrack(savedTextData[1], savedTextData[2], savedTextData[0], Integer.parseInt(savedTextData[3]), Integer.parseInt(savedTextData[4]));
                        playlistEmpty.add(dubstep);
                        break;
                    case "Vocaloid":
                        VocaloidTrack vocaloid = new VocaloidTrack(savedTextData[1], savedTextData[2], savedTextData[0], Integer.parseInt(savedTextData[3]), Integer.parseInt(savedTextData[4]));
                        playlistEmpty.add(vocaloid);
                        break;
                    default:
                        System.out.println("Unknown track type in file: " + savedTextData[0]);
                        break;
                }
            }
            System.out.println("\nPlaylist loaded successfully!\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\nMake sure you have saved your playlist first, error: " + e);
        }
        return playlistEmpty;
    }
    
}
