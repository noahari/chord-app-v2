package frontend;

import org.apache.commons.io.FilenameUtils;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Panel extends JPanel {
    private Key key;

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public abstract void draw();

    public static boolean isSharpKey(Key key) {
        String keyStr = key.getRoot().toString();
        return !((keyStr.length() > 1 && keyStr.charAt(1) == 'B') || keyStr.equals("F"));
    }


    private String stringCorrect(Note n) throws IOException{
        String nStr = n.toString();
        char noteOnly = nStr.charAt(0);
        Boolean sharpKey = isSharpKey(getKey());
        if(nStr.length() > 1) {
            if (sharpKey) {
                nStr = Note.getDispositionedToneStringWithoutOctave(1, n.getValue());
            } else
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

    public JButton toButton(Note n) throws IOException {
        String nStr = stringCorrect(n);
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
