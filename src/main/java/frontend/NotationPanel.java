package frontend;

import java.util.ArrayList;

import backend.ChordChart;
import backend.Chordy;
import backend.Useable;

import javax.swing.*;

public class NotationPanel extends Panel {
    private UI userInterface;
    private String title;
    //private ArrayList<DrawnChord> drawnChordList;
    private JPanel panel1;
    private JTable table1;
    private final String[] COL_NAMES = new String[]{"Root","Extension","Duration"};

    //JTable table1 = new JTable(ChordChart.chordList);
    public void draw(){
        // uhhh
    }
/*
    // if this sucks just delete it:
    public void updateDrawnChordList(){
        ArrayList<DrawnChord> retlist = new ArrayList<>();
        for (Useable chord : userInterface.chordChart.getChordList()){
            retlist.add(new DrawnChord((Chordy) chord));
        }
        this.drawnChordList = retlist;
    }
*/
    public void updateTable(){
	    this.table1 = new JTable(
			    userInterface.chordChart.getChordList().toTableArray(),
			    COL_NAMES
			    );
    }
}
