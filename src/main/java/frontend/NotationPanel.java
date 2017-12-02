package frontend;

import java.util.ArrayList;
import backend.Chordy;
import backend.Useable;

public class NotationPanel extends Panel {
    private UI userInterface;
    private String title;
    private ArrayList<DrawnChord> drawnChordList;

    public void draw(){
        // uhhh
    }

    // if this sucks just delete it:
    public void updateDrawnChordList(){
        ArrayList<DrawnChord> retlist = new ArrayList<>();
        for (Useable chord : userInterface.chordChart.getChordList()){
            retlist.add(new DrawnChord((Chordy) chord));
        }
        this.drawnChordList = retlist;
    }
}
