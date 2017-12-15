package frontend;

import org.jfugue.theory.Note;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class KeyMoreTest {

    private KeyMore keyMore;

    @Before
    public void setUp(){
        this.keyMore = new KeyMore("DMaj");
    }

    @Test
    public void typeFromKeyMaj(){
        assertEquals("MAJ", keyMore.typeFromKey(0));
        assertEquals("MIN", keyMore.typeFromKey(1));
        assertEquals("DIM", keyMore.typeFromKey(6));
    }

    @Test
    public void typeFromKeyMin(){
        this.keyMore = new KeyMore("dmin");
        assertEquals("MIN", keyMore.typeFromKey(0));
        assertEquals("MAJ", keyMore.typeFromKey(2));
        assertEquals("DIM", keyMore.typeFromKey(1));
    }

    @Test
    public void stringCorrect(){
        Note note = mock(Note.class);
        when(note.getValue()).thenCallRealMethod();
        when(note.toString()).thenReturn("A");
        assertEquals("A", keyMore.stringCorrect(note));
    }

    @Test
    public void toStringTest() {
        assertEquals("DMAJ", keyMore.toString());
    }

}