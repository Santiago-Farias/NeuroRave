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
    
    public static void loadPlayList() throws IOException {
        ArrayList<Track> playlistEmpty;
        try {
            String brString;
            FileReader playlistFileReader = new FileReader("playlist.txt");
            BufferedReader br = new BufferedReader(playlistFileReader);
            while ((brString = br.readLine()) != null) {
                // Add the load tracks to objects logic
                System.out.println(brString);
                String[] savedTextData = brString.split("\\|");
                System.out.println("playlistEmpty: "  + brString + "\n"+savedTextData[0]);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\nMake sure you have saved your playlist first, error: " + e);
        }
    }
    
}
