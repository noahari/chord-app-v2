package backend;


import frontend.ButtonsPanel;
import frontend.Panel;
import org.jfugue.theory.*;

import java.awt.*;

class Test {
    public static void main(String[] args){
//        Chord c = new Chord(new Key("Db"));
//        System.out.println(c);

        // test of ChordChart.toTextFile() and ChordChart.stringToChart()
        ChordChart chordChart = new ChordChart();
        chordChart.insertUseable(new Chordy("C", "maj7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("D", "min7", Duration.QUARTER));
        chordChart.insertUseable(new Resty(Duration.HALF));
        chordChart.insertUseable(new Chordy("G", "dom7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("C", "maj7", Duration.QUARTER));
        chordChart.setTempo(98);

        System.out.println(chordChart);

        chordChart.moveChord(2, 1);

        System.out.println(chordChart);

        String fileName = "chordChart";
        chordChart.saveFile(fileName);
        chordChart = ChordChart.fileToChart(fileName + ".chordface");

        System.out.println(chordChart);

        chordChart.play();

//        String[] txtArray = txt.split(System.getProperty("line.separator"));
//
//        for (String part: txtArray) {
//            String[] partData = part.split("\\s+");
//            if (partData[0].equals("T99")) continue;
//            System.out.println(partData[0]);
//            System.out.println(partData[1]);
//            if(!partData[0].equals("R")) System.out.println(partData[2]);
//        }



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
