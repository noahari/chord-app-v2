package frontend;

import backend.*;
import jdk.nashorn.internal.objects.Global;
import org.jfugue.theory.Key;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// yoooooooooooooooooo should it extend Panel or JPanel???
// Panel is prettier imo but might be unnecessary
public class UI implements Observer {
    // Instance Variables
    private Key key = new Key("Cmaj");
    private Observable observable;
    ChordChart chordChart;
    private JFrame frame;

    private Panel[] panels;

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public void setPanels(Panel[] panels) {
        this.panels = panels;
    }

    public UI(Observable observable){
        this.observable = observable;
        this.setChordChart((ChordChart) observable);
        observable.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        redraw();
    }

    public void redraw(){
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
