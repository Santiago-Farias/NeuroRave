package model;

public class Track {
    private String artist = "";
    private String name = "";
    private String genere = "";
    private int bpm = 0;
    private int secDuration = 0;
    
    // Constructor
    public Track(String artistTrack, String nameTrack, String genereTrack, int bpmTrack, int secDuracionTrack) {
        this.artist = artistTrack;
        this.name = nameTrack;
        this.genere = genereTrack;
        this.bpm = bpmTrack;
        this.secDuration = secDuracionTrack;
    }
    
    // Metodos principales
    public void reproducir() {
        System.out.println("> Reproduciendo: " + getArtist() + " - " + getName() + " [" + getMinutesDuration() + "]");
    }
    
    public String getMinutesDuration() {
        int minutos = secDuration / 60;
        int segundos = secDuration % 60;
        
        return minutos + ":" + (segundos < 10 ? "0" : "") + segundos;
    }
    
    // Getters
    public String getArtist() {
        return this.artist;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getGenere() {
        return this.genere;
    }
    
    public int getBpm() {
        return this.bpm;
    }
    
    public int getSecDuration() {
        return this.secDuration;
    }
    
    // Setters
    public void setArtist(String newArtist) {
        this.artist = newArtist;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setGenere(String newGenere) {
        this.genere = newGenere;
    }
    
    public void setBpm(int newBpm) {
        this.bpm = newBpm;
    }
    
    public void setSecDuration(int newSecDuration) {
        this.secDuration = newSecDuration;
    }
}
