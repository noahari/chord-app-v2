package backend;

import org.jfugue.theory.Note;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChordChartTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

     @Mock
     private Chordy chordy;
     private Chordy chordyB;
     private Resty resty;
     private Duration duration;

    @Test
    public void insertUseable() {
        ChordChart chordChart = new ChordChart();

        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(1, chordy);


        ArrayList<Useable> testArray = new ArrayList<>();

        testArray.add(chordy);
        testArray.add(chordy);
        testArray.add(resty);

        assertEquals(testArray, chordChart.getChordList());


    }

    @Test
    public void tempoTest(){
        ChordChart chordChart = new ChordChart(12);
        chordChart.incTempo();
        assertEquals(13, chordChart.getTempo());
        chordChart.decTempo();
        assertEquals(12, chordChart.getTempo());
    }

    @Test
    public void getChordListParam() {
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(chordy);
        chordChart.insertUseable(chordyB);
        ArrayList<Chordy> testList = new ArrayList<>();
        testList.add(chordyB);
        assertEquals(testList, chordChart.getChordList(1));
    }

    @Test
    public void restChord(){
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(chordy);
        when(chordy.getDuration()).thenReturn(Duration.QUARTER);
        chordChart.restChord(0);
        assertTrue(chordChart.getChordList().get(0).isRest());

        chordChart.restChord(0);
        assertTrue(chordChart.getChordList().get(0).isRest());
    }

    @Test
    public void getChord() throws Exception {
        ChordChart chordChart = new ChordChart();

        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        assertEquals(chordy, (chordChart.getChord(0)));
        assertEquals(null, (chordChart.getChord(1)));
        assertEquals(chordy, (chordChart.getChord(2)));
    }

    @Test
    public void getUseable() throws Exception {
        ChordChart chordChart = new ChordChart();

        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);


        assertEquals(chordy, (chordChart.getUseable(0)));
        assertEquals(resty, (chordChart.getUseable(1)));
        assertEquals(chordy, (chordChart.getUseable(2)));
    }

    @Test
    public void delChord() throws Exception {
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        chordChart.delChord(1);

        assertEquals(chordy, chordChart.getChordList().get(1));
    }

    @Test
    public void moveChord() throws Exception {
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(chordy);
        chordChart.insertUseable(chordy);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(resty);
        chordChart.insertUseable(chordy);

        chordChart.moveChord(1,2);

        assertEquals(chordy, chordChart.getChordList().get(2));
    }

    @Test
    public void toTableArray() throws Exception {
    }

    @Test
    public void toFile(){
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(new Chordy("C","maj",Duration.QUARTER));
        String path = System.getProperty("user.home")+"/Downloads/";
        chordChart.toFile(path);
        assertTrue(new File(path+"/yourMidi.midi").exists());
    }

}