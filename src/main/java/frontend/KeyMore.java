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

    public void setKey(Key key) {
        this.key = key;
    }

    private boolean isSharpKey() {
        String keyStr = key.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }

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
            if(nStr.equals("E") && (!keySignature.equals("Fmaj") || keySignature.equals("Dmin"))) nStr = "Fb";
        }
        return nStr;
    }

    public void keyChanged(){
        System.out.println("Changed");
        setChanged();
        System.out.println(this.hasChanged());
        notifyObservers();
    }

    public String toString(){
        return key.toString();
    }
}
