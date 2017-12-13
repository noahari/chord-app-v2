package frontend;

import org.jfugue.theory.Note;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class KeyMoreTest {
    @Test
    public void typeFromKeyMaj(){
        KeyMore keyMore = new KeyMore("ABMaj");
        assertEquals("MAJ", keyMore.typeFromKey(0));
        assertEquals("MIN", keyMore.typeFromKey(1));
        assertEquals("DIM", keyMore.typeFromKey(6));
    }

    @Test
    public void typeFromKeyMin(){
        KeyMore keyMore = new KeyMore("dmin");
        assertEquals("MIN", keyMore.typeFromKey(0));
        assertEquals("MAJ", keyMore.typeFromKey(2));
        assertEquals("DIM", keyMore.typeFromKey(1));
    }

    @Test
    public void stringCorrect(){
        KeyMore keyMore = new KeyMore("BMaj");
        Note note = mock(Note.class);
        when(note.toString()).thenReturn("B");
        assertEquals("B", keyMore.stringCorrect(note));
    }

    @Test
    public void toStringTest() {
        KeyMore keyMore = new KeyMore("ABmin");
        assertEquals("AbMIN", keyMore.toString());
    }

}