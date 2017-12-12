package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.swing.*;
import java.awt.*;

import java.awt.font.TextLayout;
import java.io.IOException;


public abstract class Panel extends JPanel {

    private UI userInterface;

    //<editor-fold desc="Getters and Setters">

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

    public Key getKey(){
        try {
            return getUserInterface().getKey();
        }
        catch(NullPointerException npe){
           return new Key("Cmaj");
        }
    }

    public void setKey(Key key){
        getUserInterface().setKey(key);
    }


    protected ChordButton toButton(Note n, int i) throws IOException{
        KeyMore keyMore = new KeyMore(getKey());
        String nStr = keyMore.stringCorrect(n);
        return toIcon(nStr, keyMore.stringFromKey(i));
    }

    protected ChordButton toButton(Note n) throws IOException {
        KeyMore keyMore = new KeyMore(getKey());
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
