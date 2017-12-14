package frontend;

import backend.ChordChart;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GlobalParametersPanelTest {
    @Test
    public void actionPerformedComboBox(){
        UI ui = mock(UI.class);
        GlobalParametersPanel gpp = new GlobalParametersPanel(ui);
        gpp.keys.setSelectedIndex(1);
        verify(ui).setKey(any());
    }

    @Test
    public void actionPerformedTextField(){
        UI ui = mock(UI.class);
        ChordChart chart = mock(ChordChart.class);
        GlobalParametersPanel gpp = new GlobalParametersPanel(ui);
        gpp.tempo.setText("100");
        when(ui.getChordChart()).thenReturn(chart);
        verify(chart).setTempo(100);
    }

}