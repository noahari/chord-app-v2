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

    public JButton toIcon(Note n) throws IOException {

        String nStr = n.toString();
        ImageIcon icon = new ImageIcon("graphics/C.png");
        icon.setDescription(nStr);
        JButton button = new JButton();
        button.setIcon(icon);
        button.setFont(new Font(button.getFont().getName(), Font.PLAIN, 25));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(nStr.substring(0, nStr.length() - 1));
        return button;

    }
}
