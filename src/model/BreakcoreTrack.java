package model;

public class BreakcoreTrack extends Track {
    
    private int glitchIntensity = 80;
    
    public BreakcoreTrack(String artistTrack, String nameTrack, String genereTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, genereTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("Applying heavy glitch intensity (" + glitchIntensity + "%)");
    }
}
