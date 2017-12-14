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
    //THIS FAILS RN GOTTA FUCK AROUND W/ MOCKITO A BIT
    public void actionPerformedTextField() {
        UI ui = mock(UI.class);
        ChordChart chart = mock(ChordChart.class);
        GlobalParametersPanel gpp = new GlobalParametersPanel(ui);
        gpp.tempo.setText("100");
        gpp.tempo.postActionEvent();
        doReturn(chart).when(ui).getChordChart();
        verify(chart).setTempo(100);
    }


}