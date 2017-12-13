package frontend;
import backend.ChordChart;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PanelTest {

    //C has no sharps or flats, however none of its notes need correction
    //so its values should evaluate to the default i.e. True.
    private static final String[] SHARPKEYS = {"C", "G", "D", "A", "E", "B", "F#", "C#"};

    private static final String[] FLATKEYS = {"F", "BB", "EB", "AB", "DB", "GB", "CB"};

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UI userInterface;

    @Spy
    Panel panel;

    @Test
    public void getKeyTest(){
        panel.setUserInterface(userInterface);
        KeyMore key = mock(KeyMore.class);
        when(userInterface.getKey()).thenReturn(key);
        assertEquals(panel.getKey(), key);
    }

    @Test
    public void getKeyTestException(){
        panel.setUserInterface(userInterface);
        when(userInterface.getKey()).thenThrow(new NullPointerException());
        assertEquals(panel.getKey().toString(), "Cmaj") ;
    }
    public void toButtonATest(){

    }
}


