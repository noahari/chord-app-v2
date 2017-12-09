package backend;

import com.sun.xml.internal.fastinfoset.util.QualifiedNameArray;
import frontend.ButtonsPanel;
import frontend.Panel;
import org.jfugue.theory.*;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Test {
    public static void main(String[] args){
        Panel p = new ButtonsPanel();
        p.setKey(new Key("C#maj"));
        System.out.println(p.stringCorrect(new  Note("E#")));

//
//
//        chordChart.insertUseable(new Chordy("C", "maj7", "q"));
//        chordChart.insertUseable(new Chordy("D", "min7", "q"));
//
//        // chord inserted here
//        chordChart.insertUseable(new Chordy("B", "dom9", "q"));
//        chordChart.insertUseable(new Chordy("C", "maj7", "q"));
//
//        chordChart.insertUseable(new Resty("w")); // note how it still cuts off sharply at the end...
//
////        chordChart.restChord(5);
//        chordChart.insertUseable(6, new Chordy("G", "dom7", "q"));
//        chordChart.delChord(7);

        // Should play: C D G r C r G C
//        chordChart.setTempo(99);
//        chordChart.incTempo();
//        System.out.println("Tempo: " + chordChart.getTempo());
//        chordChart.play();
//        chordChart.play(6); // sounds nice and glitchy
    }
}
