package frontend;

import javax.swing.*;

public class ChordButton extends JButton {
    private String extenstion;
    private String chord;

    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }

    public String getExtenstion() {
        return extenstion;
    }

    public void setExtenstion(String extenstion) {
        this.extenstion = extenstion;
    }

    public ChordButton(){}

    public ChordButton(String chord, String extension){
        this.chord = chord;
        this.extenstion = extension;
    }

    public String toString(){
        String endChord = chord;
        switch(extenstion){
            case "MAJ":
                endChord = endChord.toUpperCase();
                break;
            case "DIM":
                 endChord += "o";
            case "MIN":
                endChord = endChord.toLowerCase();
                break;
        }
        return endChord;
    }
}
