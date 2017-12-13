package frontend;

import backend.ChordChart;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UITest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    KeyMore key;
    //ChordChart chordChart;

    @Test
    public void setKeyTest(){
        ChordChart chordChart = mock(ChordChart.class);
        doNothing().when(chordChart).chartChanged();
        UI ui = new UI(key, chordChart);
        ui.setKey(key);
        verify(key).keyChanged();
    }
}
