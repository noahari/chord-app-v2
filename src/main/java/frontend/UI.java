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
    ChordChart chordChart;
    KeyMore key;

    private Panel[] panels;

    public void setPanels(Panel[] panels) {
        this.panels = panels;
    }

    public UI(Observable chartObs, Observable keyObs){
        this.chordChart = (ChordChart) chartObs;
        this.key = (KeyMore) keyObs;
        this.chordChart.addObserver(this);
        this.key.addObserver(this);
    }

    public void update(Observable obs, Object arg){
        for (Panel panel : panels) {
            panel.draw(arg);
        }
    }

    // why are we casting chordChart to ChordChart? -aidan
    public ChordChart getChordChart(){
        return (ChordChart) chordChart;
    }

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        chordChart.chartChanged();
    }

    public void setKey(KeyMore newKey) {
        this.key = newKey;
        this.key.addObserver(this);
        key.keyChanged();
    }

    public KeyMore getKey() {
        return key;
    }

}
