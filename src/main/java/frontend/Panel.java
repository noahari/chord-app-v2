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

    public void setUserInterface(UI ui){userInterface = ui;}
    //</editor-fold>

    public Panel(){}

    public Panel(UI userInterface){
        this.userInterface = userInterface;
    }

    public abstract void draw(Object arg);

    public KeyMore getKey(){
        try {
            return getUserInterface().getKey();
        }
        catch(NullPointerException e){
           return new KeyMore("Cmaj");
        }
    }

    public Key getKeyAsKey(){
        return getKey().getKey();
    }


    protected ChordButton toButton(Note n, int i) throws IOException{
        String nStr = getKey().stringCorrect(n);
        return toIcon(nStr, getKey().typeFromKey(i));
    }

    protected ChordButton toButton(Note n) throws IOException {
        String nStr = getKey().stringCorrect(n);
        return toIcon(nStr, "MAJ");
    }

    private ChordButton toIcon(String nStr, String extension) throws IOException {
        ImageIcon icon = new ImageIcon("graphics/Button.png");
        ChordButton button = new ChordButton(nStr, extension);
        button.setIcon(icon);
        Font fonty = new Font("ARIAL", Font.PLAIN, 36);
        button.setFont(fonty);
        button.setForeground(Color.white);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setText(button.toString());
        return button;
    }
}
