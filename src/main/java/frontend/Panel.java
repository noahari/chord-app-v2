package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.swing.*;
import java.awt.*;

import java.awt.font.TextLayout;
import java.io.IOException;


public abstract class Panel extends JPanel {
    private Key key;

    private UI userInterface;

    //<editor-fold desc="Getters and Setters">
    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public UI getUserInterface() {
        return userInterface;
    }
    //</editor-fold>

    public Panel(UI userInterface){
        this.userInterface = userInterface;
    }

    public void setUserInterface(UI userInterface) {
        this.userInterface = userInterface;
    }

    public abstract void draw();

    public ChordButton toButton(Note n, int i) throws IOException{
        KeyMore keyMore = new KeyMore(key);
        String nStr = keyMore.stringCorrect(n);
        return toIcon(nStr, keyMore.stringFromKey(i));
    }

    public ChordButton toButton(Note n) throws IOException {
        KeyMore keyMore = new KeyMore(key);
        String nStr = keyMore.stringCorrect(n);
        return toIcon(nStr, "MAJ");
    }

    private ChordButton toIcon(String nStr, String extension) throws IOException {
        ImageIcon icon = new ImageIcon("graphics/Button.png");
        ChordButton button = new ChordButton(nStr, extension);
        button.setIcon(icon);
        Graphics g = button.getGraphics();
        Font fonty = new Font("ARIAL", Font.PLAIN, 36);
        button.setFont(fonty);
        button.setForeground(Color.white);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(button.toString());
        return button;
    }
}
