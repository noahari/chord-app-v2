package it;

import backend.ChordChart;
import org.junit.Test;
import static org.junit.Assert.*;
import frontend.*;


public class ChordFaceIT {

    @Test
    public void chordFaceIt(){
        UIBuilder builder = new GenericUIBuilder();
        ButtonsPanel buttonsPanel = builder.getButtonsPanel();
        buttonsPanel.getFirstButton().doClick();
        ChordChart chart = builder.getUI().getChordChart();
        assertEquals("C4MAJWHOLE", chart.getUseable(0).toString());
    }

    @Test
    public void chordFaceIt2(){

    }

}
