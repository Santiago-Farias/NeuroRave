package model;


public class VocaloidTrack extends Track{
    
    private int voiceTone = 100;
   
    public VocaloidTrack(String artistTrack, String nameTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, nameTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("Vibing with " + voiceTone + " voice tone!");
    }
    
}
