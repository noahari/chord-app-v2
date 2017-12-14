package frontend;

import backend.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ButtonsPanelTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private UI ui;
    private ChordChart chordChart;
    private ButtonsPanel buttonsPanel;

    @Before
    public void setUp(){
        this.ui = mock(UI.class);
        this.chordChart = mock(ChordChart.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        this.buttonsPanel = new ButtonsPanel(ui);
    }

    @Test
    public void actionPerformed() throws Exception {
        Field field = ButtonsPanel.class.getDeclaredField("chordButton1");
        field.setAccessible(true);
        ChordButton button = (ChordButton)field.get(buttonsPanel);
        when(ui.getChordChart()).thenReturn(chordChart);
        button.doClick();
        verify(ui).setChordChart(chordChart);
    }

    @Test
    public void actionPerformedExtra() throws Exception {
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
        buttonsPanel.draw(0);
        assertEquals(true, buttonsPanel.inKey);
    }

}