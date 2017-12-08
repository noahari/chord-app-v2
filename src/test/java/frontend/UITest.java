package frontend;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;



public class UITest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    backend.ChordChart chordChart;


    @Test
    public void updateTest(){
        UI ui = new UI(chordChart);


    }
}
