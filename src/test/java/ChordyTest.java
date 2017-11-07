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

    @Test
    public void detNote(){
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        assertEquals("C", sChord.detNote());
    }

    @Test
    public void detOct(){
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        assertEquals(5, sChord.detOct());
    }

    @Test
    public void incOct() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        sChord.incOct();

        assertEquals("C6", sChord.getRoot());
    }

    @Test
    public void decOct() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        sChord.decOct();

        assertEquals("C4", sChord.getRoot());
    }

}