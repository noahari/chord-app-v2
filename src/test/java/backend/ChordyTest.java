package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;


public class ChordyTest {

    private Chordy sChord;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Chordy chordy;
    private String dur;
    private Duration duration;

    @Before
    public void setUp(){
        sChord = new Chordy("C5", "maj7", Duration.ONETWENTYEIGHTH);
    }

    @After
    public void tearDown(){
        sChord = null;
    }

    @Test
    public void decDur() throws Exception {
        //test chordy
        Chordy sChord = new Chordy("C", "maj7", Duration.WHOLE);

        for(int i = 0; i < 7; i++) {
            sChord.decDur();
        }

        assertEquals(Duration.ONETWENTYEIGHTH, sChord.getDuration());
        //should add more JUnit tests for each case
    }

    @Test
    public void incDur() throws Exception {
        for(int i = 0; i < 7; i++) {
            sChord.incDur();
        }

        assertEquals(Duration.WHOLE, sChord.getDuration());
        //should add more JUnit tests for each case
    }

    @Test
    public void detNote(){
        assertEquals("C", sChord.detNote());
    }

    @Test
    public void getOctTest(){
        assertEquals(5, sChord.getOct());

        Chordy aChord = new Chordy("C" , "maj", Duration.ONETWENTYEIGHTH);
        assertEquals(4, aChord.getOct());
    }

    @Test
    public void incOct() throws Exception {
        sChord.incOct();
        assertEquals("C6", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G", "dom7", Duration.ONETWENTYEIGHTH);
        aChord.incOct();
        assertEquals("G5", aChord.getRoot().getToneString());

        Chordy bChord = new Chordy("A9", "maj", Duration.HALF);
        bChord.incOct();
        assertEquals("A9", bChord.getRoot().getToneString());
    }

    @Test
    public void incOctParam() throws Exception {
        sChord.incOct(2);
        assertEquals("C7", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G8", "dom7", Duration.ONETWENTYEIGHTH);
        aChord.incOct(3);
        assertEquals("G8", aChord.getRoot().getToneString());
    }

    @Test
    public void decOct() throws Exception {
        sChord.decOct();
        assertEquals("C4", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G", "dom7", Duration.ONETWENTYEIGHTH);
        aChord.decOct();
        assertEquals("G3", aChord.getRoot().getToneString());

        Chordy bChord = new Chordy("G0", "dom7", Duration.ONETWENTYEIGHTH);
        aChord.decOct();
        assertEquals("G0", bChord.getRoot().getToneString());
    }

    @Test
    public void decOctParam() throws Exception {
        sChord.decOct(2);
        assertEquals("C3", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("G2", "dom7", Duration.ONETWENTYEIGHTH);
        aChord.decOct(4);
        assertEquals("G2", aChord.getRoot().getToneString());
    }

    @Test
    public void decRoot() throws Exception {
        sChord.decRoot();
        assertEquals("B4", sChord.getRoot().getToneString());

        Chordy aChord = new Chordy("C0", "maj7", Duration.ONETWENTYEIGHTH);
        sChord.decRoot();
        assertEquals("C0", aChord.getRoot().getToneString());

    }

    @Test
    public void incRoot() throws Exception {
        sChord.incRoot();
        assertEquals("C#5", sChord.getRoot().getToneString());
    }

    @Test
    public void isRest() throws Exception {
        assertEquals(false, chordy.isRest());
    }

    @Test
    public void getDurationString() throws Exception{
        assertEquals("o", sChord.getDurationString());
    }

    @Test
    public void setDuration() throws Exception {
        chordy.setDuration(dur);
        assertEquals(dur, chordy.getDurationString());
    }

    //This test shows that we may want to change getRow() for the sake of UI readability
    @Test
    public void getRow(){
        Chordy sChord = new Chordy("B", "maj7", Duration.ONETWENTYEIGHTH);
        String[] testArray = new String[]{
                "B",
                "maj7",
                "ONETWENTYEIGHTH"
        };
        assertArrayEquals(testArray, sChord.getRow());
    }


}