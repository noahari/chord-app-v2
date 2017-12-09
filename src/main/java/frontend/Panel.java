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

    public JButton toButton(Note n, int i) throws IOException{
        String nStr = stringCorrect(n);
        nStr = stringFromKey(nStr, i);
        return toIcon(nStr);
    }

    public JButton toButton(Note n) throws IOException {
        String nStr = stringCorrect(n);
        return toIcon(nStr);
    }

    private static String isMajor(String str){
        return str.toUpperCase();
    }

    private static String isMinor(String str){
        return str.toLowerCase();
    }

    private static String isDiminished(String str){
        return isMinor(str) + "o";
    }

    private static boolean isSharpKey(Key key) {
        String keyStr = key.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }

    private String stringFromKey(String str, int i ){
        if(getKey().getScale().getMajorOrMinorIndicator() == 1){
            if (i == 0 || i == 3 || i == 4) str = isMajor(str);
            else if (i != 6) str = isMinor(str);
            else str = isDiminished(str);
        } else{
            if (i == 2 || i == 5 || i == 6) str = isMajor(str);
            else if (i != 1) str = isMinor(str);
            else str = isDiminished(str);
        }
        return str;
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

    private JButton toIcon(String nStr) throws IOException {
        ImageIcon icon = new ImageIcon("graphics/C.png");
        icon.setDescription(nStr);
        JButton button = new JButton();
        //button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(nStr);
        return button;
    }
}
