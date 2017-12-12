package backend;

import java.io.*;
import java.util.ArrayList;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import org.jfugue.midi.*;
import org.jfugue.theory.Chord;

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

    public void play() {
        Player player = new Player();
        player.play(this.toString());
    }

    public void play(int index) {
        Player player = new Player();
        player.play(this.toString(index));
    }

    public String[][] toTableArray(){
        String[][] retArray = new String[chordList.size()][3];
        for(int i = 0; i < chordList.size(); i++){
		retArray[i] = chordList.get(i).getRow();
	}
        return retArray;
    }

    // saves the ChordChart as a .txt file
    public void toTextFile(String fileName) {
        // begin file with the tempo
        String txt = "T" + tempo + "\n";

        // for each item in the chord list, create a new line with all of the data
        for (Useable item : chordList) {
            String[] data = item.getRow();
            txt += data[0] + " " + data[1] + " " + data[2] + "\n";
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".chordface"));
            writer.write(txt);
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR GENERATING FILE");
        }
    }

    public static ChordChart fileToChart(String fileName) {
        // setup the chart to be returned
        ChordChart chart = new ChordChart();

        try {
            // grab the file
            BufferedReader fileIn = new BufferedReader(new FileReader(fileName + ".chordface"));

            // read the first line
            String line = fileIn.readLine();

            // setup tempo
            try {
                int tempo = Integer.parseInt(line.substring(1, line.length()));
                if (tempo > 200 || tempo < 40) throw new NumberFormatException("Invalid");
                chart.setTempo(tempo);
            } catch (NumberFormatException nfe) {
                System.out.println("INVALID TEMPO");
            }

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
