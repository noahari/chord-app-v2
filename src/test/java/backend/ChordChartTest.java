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
     private Duration duration;

    @Test
    public void insertChord() {
        ChordChart chordChart = new ChordChart();

        chordChart.insertUseable(chordy);

        ArrayList<Chordy> testArray = new ArrayList<>();

        testArray.add(chordy);

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