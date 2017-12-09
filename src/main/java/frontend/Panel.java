package frontend;

import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;


public abstract class Panel extends JPanel {
    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public abstract void draw();

    public ChordButton toButton(Note n, int i) throws IOException{
        String nStr = stringCorrect(n);
        return toIcon(nStr, stringFromKey(nStr, i));
    }

    public ChordButton toButton(Note n) throws IOException {
        String nStr = stringCorrect(n);
        return toIcon(nStr, "MAJ");
    }

    private static boolean isSharpKey(Key key) {
        String keyStr = key.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }

    private String stringFromKey(String str, int i ){
        if(getKey().getScale().getMajorOrMinorIndicator() == 1){
            if (i == 0 || i == 3 || i == 4) return "MAJ";
            else if (i != 6) return "MIN";
            else return "DIM";
        } else{
            if (i == 2 || i == 5 || i == 6) return "MAJ";
            else if (i != 1) return "MIN";
            else return "DIM";
        }
    }

     private String stringCorrect(Note n){
        String nStr = n.toString();
        char noteOnly = nStr.charAt(0);
        Boolean sharpKey = isSharpKey(getKey());
        if(nStr.length() > 1) {
            if (sharpKey)
                nStr = Note.getDispositionedToneStringWithoutOctave(1, n.getValue());
            else
                nStr = Note.getDispositionedToneStringWithoutOctave(-1, n.getValue());
        }
        String keySignature = getKey().getKeySignature();
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

    private ChordButton toIcon(String nStr, String extension) throws IOException {
        ImageIcon icon = new ImageIcon("graphics/Button.png");
        ChordButton button = new ChordButton(nStr, extension);
        button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(button.toString());
        return button;
    }
}
