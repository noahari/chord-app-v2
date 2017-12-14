package frontend;

import backend.ChordChart;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class UITest {
    private UI ui;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private KeyMore key;

    @Mock
    private ChordChart chordChart;

    @Before
    public void setUp(){
        this.ui = new UI(chordChart, key);
    }

    @Test
    public void setKeyTest(){
        ui.setKey(key);
        verify(key).keyChanged();
    }

    @Test
    public void setChordChartTest(){
        ui.setChordChart(chordChart);
        verify(chordChart).chartChanged();
    }

    @Test
    public void updateTest(){
        ButtonsPanel bp = mock(ButtonsPanel.class);
        Panel[] panels = new Panel[]{bp};
        ui.setPanels(panels);
        ui.update(ui.getChordChart(), null);
        verify(bp).draw(null);
    }
}
