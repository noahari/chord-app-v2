package backend;

import org.junit.Test;

import static org.junit.Assert.*;


public class ChordyTest {

    @Test
    public void decDur() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "w");

        sChord.decDur();

        assertEquals("h", sChord.getDuration());
        //should add more JUnit tests for each case

    }

    @Test
    public void incDur() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", "o");

        sChord.incDur();

        assertEquals("x", sChord.getDuration());
        //should add more JUnit tests for each case
    }

    @Test
    public void detNote(){
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");

        assertEquals("C", sChord.detNote());
    }

    @Test
    public void getOctTest(){
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");
        assertEquals(5, sChord.getOct());

        Chordy aChord = new Chordy("C" , "maj", "o");
        assertEquals(4, aChord.getOct());
    }

    @Test
    public void incOct() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");
        sChord.incOct();
        assertEquals("C6", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G", "dom7", "o");
        aChord.incOct();
        assertEquals("G5", aChord.getRoot().getToneString());

        Chordy bChord = new Chordy("A9", "maj", "h");
        bChord.incOct();
        assertEquals("A9", bChord.getRoot().getToneString());;
    }

    @Test
    public void incOctParam() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");
        sChord.incOct(2);
        assertEquals("C7", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G8", "dom7", "o");
        aChord.incOct(3);
        assertEquals("G8", aChord.getRoot().getToneString());
    }

    @Test
    public void decOct() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");
        sChord.decOct();
        assertEquals("C4", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G", "dom7", "o");
        aChord.decOct();
        assertEquals("G3", aChord.getRoot().getToneString());

        Chordy bChord = new Chordy("G0", "dom7", "o");
        aChord.decOct();
        assertEquals("G0", bChord.getRoot().getToneString());
    }

    @Test
    public void decOctParam() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C5", "maj7", "o");
        sChord.decOct(2);
        assertEquals("C3", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G2", "dom7", "o");
        aChord.decOct(4);
        assertEquals("G2", aChord.getRoot().getToneString());
    }

    @Test
    public void decRoot() throws Exception {
        Chordy sChord = new Chordy("C", "maj7", "o");
        sChord.decRoot();
        assertEquals("B3", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("C0", "maj7", "o");
        sChord.decRoot();
        assertEquals("C0", aChord.getRoot().getToneString());
    }

    @Test
    public void incRoot() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("B", "maj7", "o");
        sChord.incRoot();
        assertEquals("C5", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G10", "maj", "o");
        aChord.incRoot();
        assertEquals("G10", aChord.getRoot().getToneString());
    }

}