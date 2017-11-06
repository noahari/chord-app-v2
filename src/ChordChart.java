import java.util.ArrayList;
import org.jfugue.player.Player;

public class ChordChart {

    private ArrayList<Chordy> chordList;

    private String tempo = "";

    //<editor-fold desc="Getters and Setters">
    public ArrayList<Chordy> getChordList() {
        return chordList;
    }

    public String getTempo() {
        return tempo;
    }

    public void setChordList(ArrayList<Chordy> chordList) {
        this.chordList = chordList;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    //</editor-fold>

    public ChordChart() {
        this.chordList = new ArrayList<Chordy>();
    }

    public ChordChart(String tempo) {
        this.chordList = new ArrayList<Chordy>();
        this.tempo = tempo;
    }

    public ChordChart(ArrayList<Chordy> chordList) {
        this.chordList = chordList;
    }

    public ChordChart(ArrayList<Chordy> chordList, String tempo) {
        this.chordList = chordList;
        this.tempo = tempo;
    }

    public void insertChord(Chordy chord) {
        chordList.add(chord);
    }

    public Chordy getChord(int index) {
        return chordList.get(index);
    }

    public void restChord(int index) {
        getChord(index).toRest();
    }

    public String toString() {
        String retString;

        retString = tempo;

        for(Chordy chord : chordList) {
            retString += " " + chord.toString();
        }

        return retString;
    }

    public void play() {
        Player player = new Player();
        player.play(this.toString());
    }

}
