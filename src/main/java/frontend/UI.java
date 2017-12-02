package frontend;

import backend.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// yoooooooooooooooooo should it extend Panel or JPanel???
// Panel is prettier imo but might be unnecessary
public class UI extends JPanel implements Observer {
    // Instance Variables
    Observable observable;
    ChordChart chordChart;
    private JFrame frame;

    private NotationPanel notationPanel;
    private ChordButtonsPanel buttonsPanel;
    private GlobalParametersPanel globalParamsPanel;

    private ArrayList<Panel> panels = new ArrayList<>();

    public UI(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
        addPanel();
    }

    public void update(Observable obs, Object arg){
        for(Panel panel : panels){
            panel.draw();
        }
    }

    private void addPanel(){
        panels.add(notationPanel);
        panels.add(buttonsPanel);
        panels.add(globalParamsPanel);
    }

    public ChordChart getChordChart(){
        return chordChart;
    }

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        chordChart.chartChanged();
    }

}
