package frontend;

import backend.*;
import jdk.nashorn.internal.objects.Global;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// yoooooooooooooooooo should it extend Panel or JPanel???
// Panel is prettier imo but might be unnecessary
public class UI extends JPanel implements Observer {
    // Instance Variables
    private Observable observable;
    ChordChart chordChart;
    private JFrame frame;

    private Panel[] panels;

    public void setPanels(Panel[] panels) {
        this.panels = panels;
    }

    public UI(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        for(Panel panel : panels){
            panel.draw();
        }
    }

    public ChordChart getChordChart(){
        return chordChart;
    }

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        chordChart.chartChanged();
    }

}
