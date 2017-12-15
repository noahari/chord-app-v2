package frontend;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;


abstract class Panel{


    private UI userInterface;

    //<editor-fold desc="Getters and Setters">

    UI getUserInterface() {
        return userInterface;
    }

    void setUserInterface(UI ui){userInterface = ui;}
    //</editor-fold>


<<<<<<< HEAD
    Panel(){}

    Panel(UI userInterface){
=======
    public Panel(UI userInterface){
>>>>>>> f8287a19d9efb8a7235cb266af8f6e13ab5f1bff
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

    Key getKeyAsKey(){
        return getKey().getKey();
    }


    ChordButton toButton(Note n, int i) throws IOException{
        String nStr = getKey().stringCorrect(n);
        return toIcon(nStr, getKey().typeFromKey(i));
    }

    ChordButton toButton(Note n) throws IOException {
        String nStr = getKey().stringCorrect(n);
        return toIcon(nStr, "MAJ");
    }

    private ChordButton toIcon(String nStr, String extension) {
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
