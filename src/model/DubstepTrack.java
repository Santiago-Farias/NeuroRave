package model;

public class DubstepTrack extends Track {
    
    private int transformersNoises = 15;
    
    public DubstepTrack(String artistTrack, String nameTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, nameTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println(transformersNoises + " transforms did some noise!");
    }
    
}
