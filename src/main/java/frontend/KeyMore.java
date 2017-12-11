package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

public class KeyMore extends Key{

    public KeyMore(Key key){
        super(key);
    }

    private boolean isSharpKey() {
        String keyStr = this.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }

    protected String stringFromKey(String str, int i){
        if(this.getScale().getMajorOrMinorIndicator() == 1){
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
        String keySignature = this.getKeySignature();
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
}
