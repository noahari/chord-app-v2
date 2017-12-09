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
    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    private Key key;
    public abstract void draw();

    private static boolean isSharpKey(Key key) {
        char kid = key.toString().charAt(1);
        return !(kid == 'b' || kid == 'F' || kid == 'G');
    }


    private String stringCorrect(String nStr) throws IOException{
        char noteOnly = nStr.charAt(0);
        Boolean sharpKey = isSharpKey(getKey());
        if(nStr.length() > 1) {
            if (sharpKey) {
                nStr = Note.getDispositionedToneStringWithoutOctave(1, n.getValue());
            } else
                nStr = Note.getDispositionedToneStringWithoutOctave(-1, n.getValue());
        }
        if((noteOnly == 'C' || noteOnly == 'F') && sharpKey){
            if(nStr.equals("C")) nStr = "B#";
            if(nStr.equals("F")) nStr = "E#;";
        }
        else if((noteOnly == 'B' || noteOnly == 'E') && !sharpKey) {
            if(nStr.equals("B")) nStr = "Cb";
            if(nStr.equals("F")) nStr =
        }
        return nStr;
    }

    public JButton toButton(Note n) throws IOException {
        String nStr = stringCorrect(getKey().toString());
        ImageIcon icon = new ImageIcon("graphics/C.png");
        icon.setDescription(nStr);
        JButton button = new JButton();
        button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(nStr);
        return button;
    }


}
