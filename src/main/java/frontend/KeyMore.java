package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import java.util.Observable;

public class KeyMore extends Observable {

    private Key key;

    public KeyMore(String s){
        this.key = new Key(s);
    }

    public Key getKey() {
        return key;
    }

    /**
     * @return True if sharp key (C is treated as "sharp")
     */
    private boolean isSharpKey() {
        String keyStr = key.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }

    /**
     * @param i scale degree (0-6)
     * @return The given degree's chord quality
     */
    protected String typeFromKey(int i){
        if(key.getScale().getMajorOrMinorIndicator() == 1){
            if (i == 0 || i == 3 || i == 4) return "MAJ";
            else if (i != 6) return "MIN";
            else return "DIM";
        } else{
            if (i == 2 || i == 5 || i == 6) return "MAJ";
            else if (i != 1) return "MIN";
            else return "DIM";
        }
    }

    /**
     * Fixing JFugue's insistence on not using enharmonic notes
     * @param n Note to be evaluated
     * @return The note as a string in this key
     */
    protected String stringCorrect(Note n){
        String nStr = n.toString();
        char noteOnly = nStr.charAt(0);
        Boolean sharpKey = isSharpKey();
        if(nStr.length() > 1) {
            if (sharpKey)
                nStr = Note.getDispositionedToneStringWithoutOctave(1, n.getValue());
            else
                nStr = Note.getDispositionedToneStringWithoutOctave(-1, n.getValue());
        }
        String keySignature = key.getKeySignature();
        if((noteOnly == 'C' || noteOnly == 'F') && sharpKey && !keySignature.equals("Cmaj")){
            if(nStr.equals("C") && !(keySignature.equals("Gmaj") || keySignature.equals("Emin"))) nStr = "B#";
            if(nStr.equals("F")) nStr = "E#";
        }
        else if((noteOnly == 'B' || noteOnly == 'E') && !sharpKey) {
            if(nStr.equals("B")) nStr = "Cb";
            if(nStr.equals("E") && !(keySignature.equals("Fmaj") || keySignature.equals("Dmin"))) nStr = "Fb";
        }
        return nStr;
    }

    /**
     * Observer method
     */
    public void keyChanged(){
        setChanged();
        notifyObservers(0);
    }

    @Override
    public String toString(){
        String type;
        if(key.getScale().getMajorOrMinorIndicator() == 1) type = "MAJ";
        else type = "MIN";
        return "" + stringCorrect(key.getRoot()) + type;
    }
}
