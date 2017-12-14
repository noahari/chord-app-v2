package frontend;

import backend.ChordChart;
import backend.Chordy;
import backend.Useable;
import javafx.scene.control.ButtonBar;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ButtonsPanelTest {


    @Test
    public void actionPerformed() throws Exception {
        UI ui = mock(UI.class);
        ChordChart chordChart =  mock(ChordChart.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        ButtonsPanel buttonsPanel = new ButtonsPanel(ui);
        Field field = ButtonsPanel.class.getDeclaredField("chordButton1");
        field.setAccessible(true);
        ChordButton button = (ChordButton)field.get(buttonsPanel);
        when(ui.getChordChart()).thenReturn(chordChart);
        button.doClick();
        verify(ui).setChordChart(chordChart);
    }

    @Test
    public void actionPerformedExtra() throws Exception {
        UI ui = mock(UI.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        ButtonsPanel buttonsPanel = new ButtonsPanel(ui);

        Field field = ButtonsPanel.class.getDeclaredField("extraButton");
        field.setAccessible(true);
        ChordButton button = (ChordButton)field.get(buttonsPanel);
        button.doClick();

        Field field2 = ButtonsPanel.class.getDeclaredField("chordButton1");
        field2.setAccessible(true);
        ChordButton button1 = (ChordButton)field2.get(buttonsPanel);

        assertEquals("C#/DB", button1.getText());

        button.doClick();

        assertEquals("C", button1.getText());
    }


    @Test
    public void draw(){
        UI ui = mock(UI.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        ButtonsPanel buttonsPanel = new ButtonsPanel(ui);
        buttonsPanel.draw(0);
        assertEquals(true, buttonsPanel.inKey);
    }

}