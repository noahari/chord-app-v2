import java.io.IOException;
import java.util.ArrayList;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.*;
import java.io.File;

public class ChordChart {

    private ArrayList<Chordy> chordList;

    private String tempo = "";

    //<editor-fold desc="Getters and Setters">
    public ArrayList<Chordy> getChordList() {
        return chordList;
    }
    public ArrayList<Chordy> getChordList(int index) {
        ArrayList<Chordy> retList = chordList;
        retList.subList(0, index-1).clear();
        return retList;
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
    public void insertChord(int index, Chordy chord) {
        chordList.add(index, chord);
    }

    public Chordy getChord(int index) {
        return chordList.get(index);
    }

    public void restChord(int index) {
        getChord(index).toRest();
    }

    public void delChord(int index) {
        chordList.remove(index);
    }

    public void toFile(){
        String pat = "";
        for(Chordy chord:getChordList()){
            pat += "" + chord.toString();
        }
        Pattern p = new Pattern(pat);
        try {
            MidiFileManager.savePatternToMidi(p, new File("./src/main/resources/midi_test.midi"));
        }
        catch(IOException ioe){
            System.out.println("Error");
            ioe.printStackTrace();
        }
    }

    public String toString() {
        String retString;

        retString = tempo;

        for(Chordy chord : chordList) {
            retString += " " + chord.toString();
        }

        return retString;
    }
    public String toString(int index) {
        String retString;

        retString = tempo;

        for(Chordy chord : getChordList(index)) {
            retString += " " + chord.toString();
        }

        return retString;
    }

    public void play() {
        Player player = new Player();
        player.play(this.toString());
    }

    public void play(int index) {
        Player player = new Player();
        player.play(this.toString(index));
    }

}
