package frontend;
import backend.Chordy;

public class DrawnChord {
    Chordy chord;

    public DrawnChord(Chordy chord){
        this.chord = chord;
    }

    public Chordy getChord(){
        return this.chord;
    }
    public void SetChord(Chordy chord){
        this.chord = chord;
    }
}
