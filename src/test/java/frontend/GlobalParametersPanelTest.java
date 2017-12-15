package frontend;

import backend.ChordChart;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class GlobalParametersPanelTest {
    private GlobalParametersPanel gpp;

    @Mock
    private UI ui;

    @Mock
    private ChordChart chordChart;

    @Before
    public void setUp(){
        this.gpp = new GlobalParametersPanel(ui);
    }

    @Test
    public void actionPerformedComboBox(){
        gpp.keys.setSelectedIndex(1);
        verify(ui).setKey(any());
    }

    //I DONT KNOW WHY THIS DOESNT WORK???
    @Test
    public void actionPerformedTextField() {
        gpp.tempo.setText("100");
        gpp.tempo.postActionEvent();
        ChordChart chordChart = mock(ChordChart.class);
        when(ui.getChordChart()).thenReturn(chordChart); //its really just this line its returning null not chordChart??
        verify(chordChart).setTempo(100);
    }

    //THIS ONE TOO
    @Test
    public void actionPerformedStartButton(){
        gpp.playButton.doClick();
        when(ui.getChordChart()).thenReturn(chordChart);
        verify(chordChart).play();
    }






}