package frontend;
import org.jfugue.theory.Note;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChordButtonTest {

    @Test
    public void toStringTest(){
        ChordButton chordButton = new ChordButton("C", "MAJ");
        assertEquals("C", chordButton.toString());
        chordButton.setExtension("DIM");
        assertEquals("co", chordButton.toString());
        chordButton.setExtension("MIN");
        assertEquals("c", chordButton.toString());
        chordButton.setChord("BB");
        chordButton.setExtension("MAJ");
        assertEquals("Bb", chordButton.toString());
    }

    @Test
    public void resetKeyTest(){
        KeyMore key = mock(KeyMore.class);
        Note note = mock(Note.class);
        ChordButton chordButton = new ChordButton("C", "MAJ");
        when(key.stringCorrect(note)).thenReturn("D");
        when(key.typeFromKey(1)).thenReturn("MAJ");
        chordButton.resetText(key, note, 1);
        assertEquals("D", chordButton.getText());
    }
}
