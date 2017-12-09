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

    public JButton toIcon(Chord c) throws IOException {
        String cStr = c.toString();
        cStr = cStr.substring(0, cStr.length() - 4);
        switch(c.getChordType()){
            case "AUG":
                cStr = cStr + "+";
            case "MAJ":
                cStr = cStr.toUpperCase();
                break;
            case "DIM":
                cStr = cStr + "o";
            case "MIN":
                cStr = cStr.toLowerCase();
                break;
        }
        ImageIcon icon = new ImageIcon("graphics/C.png");
        icon.setDescription(cStr);
        JButton button = new JButton();
        button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(cStr);
        return button;

    }
}
