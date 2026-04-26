package model;

public class BreakcoreTrack extends Track {
    
    private int glitchIntensity = 80;
    
    public BreakcoreTrack(String artistTrack, String nameTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, nameTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("Apllying glith intensity (" + glitchIntensity + "%)");
    }
}
