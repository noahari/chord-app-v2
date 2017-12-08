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
    private NotationPanel notationPanel;
    private GlobalParametersPanel globalParametersPanel;
    private ButtonsPanel buttonsPanel;
    ChordChart chordChart;
    private JFrame frame;

    private ArrayList<Panel> panels = new ArrayList<>();

    public UI(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
        addPanels();
    }

    public void update(Observable obs, Object arg){
        for(Panel panel : panels){
            panel.draw();
        }
    }

    private void addPanels(){
        panels.add(globalParametersPanel = new GlobalParametersPanel());
        panels.add(notationPanel = new NotationPanel());
        panels.add(buttonsPanel = new ButtonsPanel());
    }

    public ChordChart getChordChart(){
        return chordChart;
    }

    public NotationPanel getNotationPanel(){return notationPanel;}

    public GlobalParametersPanel getGlobalParametersPanel(){return globalParametersPanel;}

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        chordChart.chartChanged();
    }

}
