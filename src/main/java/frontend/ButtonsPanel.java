package frontend;

import backend.Chordy;
import backend.Duration;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonsPanel extends JPanel {
    UI userInterface;

    public void rootButtonHit(JButton rootButton){
        userInterface.getChordChart().insertUseable(new Chordy(rootButton.getName(), "", Duration.QUARTER));
    }
    public void actionPerformed(ActionEvent evt){
        //
    }
}
