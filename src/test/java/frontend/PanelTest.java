package frontend;
import backend.ChordChart;
import org.jfugue.theory.Note;
import org.junit.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

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
        assertEquals(panel.getKey().toString(), "CMAJ") ;
    }

    @Test
    public void toButtonATest(){
        panel.setUserInterface(userInterface);
        Note note = mock(Note.class);
        KeyMore key = mock(KeyMore.class);
        when(userInterface.getKey()).thenReturn(key);
        when(key.stringCorrect(note)).thenReturn("A");
        ChordButton button = null;
        try {
            button = panel.toButton(note);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        assertEquals(button.getText(),"A" );
    }

    @Test
    public void toButtonBTest(){
        panel.setUserInterface(userInterface);
        Note note = mock(Note.class);
        KeyMore key = mock(KeyMore.class);
        when(userInterface.getKey()).thenReturn(key);
        when(key.stringCorrect(note)).thenReturn("A");
        when(key.typeFromKey(1)).thenReturn("MIN");
        ChordButton button = null;
        try {
            button = panel.toButton(note, 1);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        assertEquals(button.getText(),"a" );
    }
}


