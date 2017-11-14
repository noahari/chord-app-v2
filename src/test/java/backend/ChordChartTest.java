package backend;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChordChartTest {

    @Test
    public void insertChord() {
        ChordChart chordChart = new ChordChart();

        Chordy insertChord = new Chordy("C", "maj7", "q");

        chordChart.insertChord(insertChord);

        ArrayList<Chordy> testArray = new ArrayList<>();

        testArray.add(insertChord);

        assertEquals(testArray, chordChart.getChordList());
    }





}