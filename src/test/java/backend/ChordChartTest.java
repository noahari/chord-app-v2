package backend;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChordChartTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

     @Mock
     private Chordy chordy;
     private Chordy chordyB;

    @Test
    public void insertChord() {
        ChordChart chordChart = new ChordChart();

        chordChart.insertChord(chordy);

        ArrayList<Chordy> testArray = new ArrayList<>();

        testArray.add(chordy);

        assertEquals(testArray, chordChart.getChordList());
    }

    @Test
    public void getChordListParam() {
        ChordChart chordChart = new ChordChart();
        chordChart.insertChord(chordy);
        chordChart.insertChord(chordyB);
        ArrayList<Chordy> testList = new ArrayList<>();
        testList.add(chordyB);
        assertEquals(testList, chordChart.getChordList(1));
    }

    @Test
    public void restChord(){
        ChordChart chordChart = new ChordChart();
        chordChart.insertChord(chordy);
        when(chordy.getNotes()).thenReturn(new Note[]{new Note(60, 15)});
        chordChart.restChord(0);
        assertTrue(chordChart.getChordList().get(0).isRest());
    }





}