package frontend;

import javax.swing.*;

public class ChordButton extends JButton {
    private String extension;
    private String chord;

    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ChordButton(){}

    public ChordButton(String chord, String extension){
        this.chord = chord;
        this.extension = extension;
    }

    public String toString(){
        String endChord = chord;
        switch(extension){
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
