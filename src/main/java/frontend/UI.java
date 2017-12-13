package frontend;

import backend.*;
import jdk.nashorn.internal.objects.Global;
import org.jfugue.theory.Key;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class UI implements Observer {
    // Instance Variables
    private ChordChart chordChart;
    private KeyMore key;
    Observable chartObs;
    Observable keyObs;

    private Panel[] panels;

    public void setPanels(Panel[] panels) {
        this.panels = panels;
    }

    public UI(Observable chartObs, Observable keyObs){
        chartObs = chartObs;
        keyObs = keyObs;
        chartObs.addObserver(this);
        keyObs.addObserver(this);
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

    public void setKey(KeyMore key) {
        key.keyChanged();
        this.key = key;
    }
    public KeyMore getKey() {
        return key;
    }

}
