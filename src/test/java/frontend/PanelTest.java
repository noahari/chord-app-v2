package frontend;
import org.jfugue.theory.Note;
import org.junit.Before;
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
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private UI userInterface;
    @Mock
    private KeyMore key;
    @Mock
    private Note note;

    @Spy
    private Panel panel;

    @Before
    public void setUp(){
        panel.setUserInterface(userInterface);
    }

    @Test
    public void getKeyTest(){
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


