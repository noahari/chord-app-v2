import org.junit.Test;

import static org.junit.Assert.*;

public class ChordyTest {
    @Test
    public void shrinkChordy() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "w");

        sChord.shrinkChordy();

        assertEquals("h", sChord.getDuration());
        //should add more JUnit tests for each case

    }

    @Test
    public void growChordy() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        sChord.growChordy();

        assertEquals("x", sChord.getDuration());
        //should add more JUnit tests for each case
    }

}