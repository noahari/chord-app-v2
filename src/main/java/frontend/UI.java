package frontend;

import backend.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class UI extends JPanel implements Observer {
    // Instance Variables
    Observable observable;
    private JFrame frame;
    protected ChordChart chordChart;

    //These classes don't exist yet
     private NotationPanel notationPanel;
     private ChordButtonsPanel buttonsPanel;
     private GlobalParametersPanel globalParamsPanel;

    ArrayList<JPanel> panels = new ArrayList<>();

    public UI(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        for(JPanel panel : panels){
            panel.draw();
        }
    }

    public void addPanel(){
        panels.add(notationPanel);
        panels.add(buttonsPanel);
        panels.add(globalParamsPanel);
    }

    public ChordChart getChordChart(){
        return chordChart;
    }

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        chordChart.chartChanged();;
    }

}
