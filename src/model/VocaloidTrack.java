package model;


public class VocaloidTrack extends Track{
    
    private int voiceTone = 100;
   
    public VocaloidTrack(String artistTrack, String nameTrack, String genereTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, genereTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("Vocaloid vibes with " + voiceTone + "% perfect voice tone!");
    }
    
}
