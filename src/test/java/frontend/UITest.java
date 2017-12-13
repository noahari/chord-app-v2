package frontend;

import backend.ChordChart;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class UITest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    KeyMore key;

    @Mock
    ChordChart chordChart;

    @Test
    public void setKeyTest(){
        UI ui = new UI(chordChart, key);
        ui.setKey(key);
        verify(key).keyChanged();
    }

    @Test
    public void setChordChartTest(){
        UI ui = new UI(chordChart, key);
        ui.setChordChart(chordChart);
        verify(chordChart).chartChanged();
    }

    @Test
    public void updateTest(){
        ButtonsPanel bp = mock(ButtonsPanel.class);
        Panel[] panels = new Panel[]{bp};
        UI ui = new UI(chordChart, key);
        ui.setPanels(panels);
        ui.update(ui.getChordChart(), null);
        verify(bp).draw();
    }
}
