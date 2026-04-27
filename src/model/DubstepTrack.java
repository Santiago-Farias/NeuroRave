package model;

public class DubstepTrack extends Track {
    
    private int transformersNoises = 15;
    
    public DubstepTrack(String artistTrack, String nameTrack, String genereTrack, int bpmTrack, int secDuracionTrack) {
        super(artistTrack, nameTrack, genereTrack, bpmTrack, secDuracionTrack);
    }
    
    @Override
    public void reproducir() {
        super.reproducir();
        System.out.println("¡WUB WUB! " + transformersNoises + " monster transformer sounds incoming!");
    }
    
}
