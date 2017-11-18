package backend;

import java.io.IOException;
import java.util.ArrayList;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.*;
import org.jfugue.theory.*;
import java.io.File;

public class ChordChart {

    private ArrayList<Chordy> chordList;

    private int tempo = 120;

    //<editor-fold desc="Getters and Setters">
    public ArrayList<Chordy> getChordList() {
        return chordList;
    }

    private ArrayList<Chordy> getChordList(int index) {
        ArrayList<Chordy> retList = chordList;
        retList.subList(0, index-1).clear();
        return retList;
    }

    public int getTempo() {
        return tempo;
    }

    public void setChordList(ArrayList<Chordy> chordList) {
        this.chordList = chordList;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    //</editor-fold>

    //CONSTRUCTORS
    public ChordChart() {
        this.chordList = new ArrayList<>();
    }

    public ChordChart(int tempo) {
        this.chordList = new ArrayList<Chordy>();
        this.tempo = tempo;
    }

    public ChordChart(ArrayList<Chordy> chordList) {
        this.chordList = chordList;
    }

    public ChordChart(ArrayList<Chordy> chordList, int tempo) {
        this.chordList = chordList;
        this.tempo = tempo;
    }

    public void incTempo() {
        tempo++;
    }
    public void decTempo() { tempo--; }

    public void insertChord(Chordy chord) {
        chordList.add(chord);
    }
    public void insertChord(int index, Chordy chord) {
        chordList.add(index, chord);
    }

    private Chordy getChord(int index) {
        return chordList.get(index);
    }

    public void restChord(int index) {
        for(Note n: getChord(index).getNotes())
           n = Note.createRest(n.getDuration());
     }

    public void delChord(int index) {
        chordList.remove(index);
    }

    public void moveChord(int presentIndex, int futureIndex) {
        this.insertChord(futureIndex, this.getChord(presentIndex));
        this.delChord(presentIndex);
    }

    public void toFile(String path){
        String pat = "T" + tempo + " ";
        for(Chordy chord:getChordList()){
            pat += "" + chord.toString();
        }
        Pattern p = new Pattern(pat); // shouldn't `pat` just be `this.toString()`?
        try {
            MidiFileManager.savePatternToMidi(p, new File(path+"/yourMidi.midi"));
        }
        catch(IOException ioe){
            System.out.println("Error");
            ioe.printStackTrace();
        }
    }

    public String toString() {
        String retString;

        retString = "T" + tempo;

        for(Chordy chord : chordList) {
            retString += " " + chord.toString();
        }

        return retString;
    }
    private String toString(int index) {
        String retString;

        retString = "T" + tempo;

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
