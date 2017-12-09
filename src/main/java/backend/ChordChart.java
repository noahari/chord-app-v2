package backend;

import java.io.IOException;
import java.util.ArrayList;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.*;

import java.io.File;
import java.util.Observable;

public class ChordChart extends Observable {

    private ArrayList<Useable> chordList;

    private int tempo = 120;


    //<editor-fold desc="Getters and Setters">
    public ArrayList<Useable> getChordList() {
        return chordList;
    }

    public ArrayList<Useable> getChordList(int index) {
        ArrayList<Useable> retList = chordList;
        retList.subList(0, index).clear();
        return retList;
    }

    public int getTempo() {
        return tempo;
    }

    public void setChordList(ArrayList<Useable> chordList) {
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
        this.chordList = new ArrayList<Useable>();
        this.tempo = tempo;
    }

    public ChordChart(ArrayList<Useable> chordList) {
        this.chordList = chordList;
    }

    public ChordChart(ArrayList<Useable> chordList, int tempo) {
        this.chordList = chordList;
        this.tempo = tempo;
    }
    //

    //Observer Method
    public void chartChanged(){
        setChanged();
        notifyObservers();
    }
    //

    public void incTempo() {
        tempo++;
    }
    public void decTempo() { tempo--; }

    public void insertUseable(Useable chord) {
        chordList.add(chord);
    }
    public void insertUseable(int index, Useable chord) {
        chordList.add(index, chord);
    }

    public Chordy getChord(int index) {
        if(getChordList().get(index) instanceof Chordy) {
            return (Chordy) chordList.get(index);
        }
        else return null;
    }

    public Useable getUseable(int index){
        return getChordList().get(index);
    }

    public void restChord(int index) {
        if(!(getChordList().get(index).isRest())) {
            Chordy c = getChord(index);
            getChordList().set(index, new Resty(c.getDuration()));
        }
     }


    public void delChord(int index) {
        chordList.remove(index);
    }

    public void moveChord(int presentIndex, int futureIndex) {
        this.insertUseable(futureIndex, this.getChord(presentIndex));
        this.delChord(presentIndex);
    }

    public void toFile(String path){
        Pattern p = new Pattern(this.toString());
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

        for(Useable chord : chordList) { // should we use this.getChordList() instead?
            retString += " " + chord.toString();
        }

        return retString;
    }
    private String toString(int index) {
        String retString;

        retString = "T" + tempo;

        for(Useable chord : getChordList(index)) {
            retString += " " + chord.toString();
        }

        return retString;
    }

    private String[][] toTableArray(){
        String[][] retArray;
        for(int i = 0; i > chordList.size(); i++){
            if(chordList.get(i).isRest()) {
                Resty resterino = (Resty)chordList.get(i);
                retArray[i][0] = "R";
                retArray[i][1] = "";
                retArray[i][2] = String.valueOf(resterino.getDuration());
            }
            else{
                Chordy chorderino = (Chordy)chordList.get(i);
                retArray[i][0] = chorderino.getRoot().toString();
                retArray[i][1] = chorderino.getChordType();
                retArray[i][2] = chorderino.getDuration().toString();
            }
        }
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
