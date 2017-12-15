package backend;

import java.io.*;
import java.util.ArrayList;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.*;

import java.util.Observable;

public class ChordChart extends Observable {

    private final ArrayList<Useable> chordList;

    private int tempo = 120;


    //<editor-fold desc="Getters and Setters">
    ArrayList<Useable> getChordList() {
        return chordList;
    }

    ArrayList<Useable> getChordList(int index) {
        ArrayList<Useable> retList = chordList;
        retList.subList(0, index).clear();
        return retList;
    }


    public int getTempo() {
        return tempo;
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
        this.chordList = new ArrayList<>();
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
        notifyObservers(1);
    }
    //

    void incTempo() {
        tempo++;
    }
    void decTempo() { tempo--; }

    public void insertUseable(Useable chord) {
        chordList.add(chord);
    }
    void insertUseable(int index, Useable chord) {
        chordList.add(index, chord);
    }

    Chordy getChord(int index) {
        if(getChordList().get(index) instanceof Chordy) {
            return (Chordy) chordList.get(index);
        }
        else return null;
    }

    public Useable getUseable(int index){
        return getChordList().get(index);
    }

    void restChord(int index) {
        if(!(getChordList().get(index).isRest())) {
            Chordy c = getChord(index);
            getChordList().set(index, new Resty(c.getDuration()));
        }
     }


    public void delChord(int index) {
        chordList.remove(index);
    }

    public void moveChord(int presentIndex, int futureIndex) {
        if (futureIndex>=0&&futureIndex<=chordList.size()) {
            if (presentIndex<futureIndex) {
                insertUseable(futureIndex+1,getChord(presentIndex));
                delChord(presentIndex);
            } else if (presentIndex>futureIndex) {
                insertUseable(futureIndex,getChord(presentIndex));
                delChord(presentIndex+1);
            }
        }
    }

    void toMIDIFile(String path){
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
        StringBuilder retString;

        retString = new StringBuilder("T" + tempo);

        for(Useable chord : chordList) { // should we use this.getChordList() instead?
            retString.append(" ").append(chord.toString());
        }

        return retString.toString();
    }
    private String toString(int index) {
        StringBuilder retString;

        retString = new StringBuilder("T" + tempo);

        for(Useable chord : getChordList(index)) {
            retString.append(" ").append(chord.toString());
        }

        return retString.toString();
    }

    public void play() {
        Player player = new Player();
        System.out.println(this.toString());
        player.play(this.toString());
    }

    public String[][] toTableArray(){
        String[][] retArray = new String[chordList.size()][3];
        for(int i = 0; i < chordList.size(); i++){
            retArray[i] = chordList.get(i).getRow();
        }
        return retArray;
    }

    // saves the ChordChart as a .txt file
    public void saveFile(String fileName) {
        // begin file with the tempo
        StringBuilder txt = new StringBuilder("T" + tempo + "\n");

        // for each item in the chord list, create a new line with all of the data
        for (Useable item : chordList) {
            String[] data = item.getRow();
            txt.append(data[0]).append(" ").append(data[1]).append(" ").append(data[2]).append("\n");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter( fileName + ".chordface"));
            writer.write(txt.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR GENERATING FILE");
        }
    }

    public static ChordChart fileToChart(String path) {
        // setup the chart to be returned
        ChordChart chart = new ChordChart();

        try {
            // grab the file
            BufferedReader fileIn = new BufferedReader(new FileReader(path));

            // read the first line
            String line = fileIn.readLine();

            // setup tempo
            int tempo = Integer.parseInt(line.substring(1, line.length()));
            chart.setTempo(tempo);

            // setup the usable objects
            while((line = fileIn.readLine()) != null) {
                // split up parts of line by whitespace
                String[] partData = line.split("\\s+");

                // add useable to chart depending on type
                if(partData[0].equals("R")) {
                    chart.insertUseable(new Resty(Duration.valueOf(partData[1])));
                } else {
                    chart.insertUseable(new Chordy(partData[0], partData[1], Duration.valueOf(partData[2])));
                }
            }
        } catch (Exception e) {
            System.out.println("INVALID FILE");
        }

        return chart;
    }
}
