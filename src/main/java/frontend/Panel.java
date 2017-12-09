package frontend;

import org.apache.commons.io.FilenameUtils;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Panel extends JPanel {
    public abstract void draw();

    protected JButton noteProcessor(Note n, Boolean sharpKey) throws IOException{
        String nStr = n.toString();
        if(nStr.length() > 1) {
            if (sharpKey) {
                nStr = Note.getDispositionedToneStringWithoutOctave(1, n.getValue());
                System.out.println("!");
            } else
                nStr = Note.getDispositionedToneStringWithoutOctave(-1, n.getValue());
        }
        JButton icon = toIcon(nStr);
        return icon;
    }

    private static JButton toIcon(String nStr) throws IOException {
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
