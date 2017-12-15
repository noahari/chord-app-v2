package it;

import backend.ChordChart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import frontend.*;


public class ChordFaceIT {

    private UIBuilder builder;

    @Before
    public void setUp(){
        builder = new GenericUIBuilder();
    }

    @After
    public void tearDown(){
        builder = null;
    }

    @Test
    public void chordFaceIt(){
        ButtonsPanel buttonsPanel = builder.getButtonsPanel();
        buttonsPanel.getFirstButton().doClick();
        ChordChart chart = builder.getUI().getChordChart();
        assertEquals("CMAJWHOLE", chart.getUseable(0).toString());
    }

    @Test
    public void chordFaceIt2(){
        GlobalParametersPanel gpp = builder.getGlobalParamsPanel();
        gpp.getKeys().setSelectedIndex(2);
        ChordButton button = builder.getButtonsPanel().getFirstButton();
        assertEquals("D", button.getText());
    }

}
