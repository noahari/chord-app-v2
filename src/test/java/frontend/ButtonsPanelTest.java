package frontend;

import backend.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

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
        when(ui.getChordChart()).thenReturn(chordChart);
        buttonsPanel.chordButton1.doClick();
        verify(ui).setChordChart(chordChart);
    }

    @Test
    public void actionPerformedExtra() throws Exception {
        buttonsPanel.extraButton.doClick();
        ChordButton button1 = buttonsPanel.chordButton1;
        assertEquals("C#/DB", button1.getText());
        buttonsPanel.extraButton.doClick();
        assertEquals("C", button1.getText());
    }


    @Test
    public void draw(){
        buttonsPanel.draw(0);
        assertEquals(true, buttonsPanel.inKey);
    }

}