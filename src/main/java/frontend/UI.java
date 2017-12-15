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
    KeyMore key;
    private Duration duration = Duration.WHOLE;

    private Panel[] panels;

    void setPanels(Panel[] panels) {
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

    public ChordChart getChordChart(){
        return chordChart;
    }

    public void setChordChart(ChordChart chord){
        this.chordChart = chord;
        this.chordChart.addObserver(this);
        chordChart.chartChanged();
    }

    public void setKey(KeyMore newKey) {
        this.key = newKey;
        this.key.addObserver(this);
        key.keyChanged();
    }

    public void setDuration(Duration duration){
        this.duration = duration;
    }

    public Duration getDuration(){
        return this.duration;
    }

    public KeyMore getKey() {
        return key;
    }

}
