package backend;

import org.jfugue.theory.*;

class Test {
    public static void main(String[] args){
//        Player player = new Player();
//        player.play("C D E F G A B C6");
        ChordChart chordChart = new ChordChart();

        Chordy c = new Chordy("C5", "maj7", "w");

        System.out.println("c: " + c.getRoot().getToneString());

        Chordy d = new Chordy("C5","maj7", "w");

        System.out.println("d: " + d.getRoot().getToneString());

        c.incRoot();

        System.out.println("c: " + c.getRoot().getToneString());

        chordChart.insertChord(c);

        chordChart.insertChord(d);

        chordChart.play(2);

        Chordy blah = new Chordy("C5", "maj7", "q");
        System.out.println(blah.toString());
        blah.setDuration("w");
        System.out.println(blah.toString());


//        chordChart.insertChord(new Chordy("C", "maj7", "q"));
//        chordChart.insertChord(new Chordy("D", "min7", "q"));
//        chordChart.insertChord(new Chordy("G", "dom7", "q"));
//        chordChart.insertChord(new Resty("q"));
//
//        String home = System.getProperty("user.home");
//        chordChart.toFile(home+"/Downloads");
//
//        chordChart.insertChord(new Chordy("C", "maj7", "q"));
//        chordChart.insertChord(new Chordy("D", "min7", "q"));
//
//        // chord inserted here
//        chordChart.insertChord(new Chordy("B", "dom9", "q"));
//        chordChart.insertChord(new Chordy("C", "maj7", "q"));
//
//        chordChart.insertChord(new Resty("w")); // note how it still cuts off sharply at the end...
//
////        chordChart.restChord(5);
//        chordChart.insertChord(6, new Chordy("G", "dom7", "q"));
//        chordChart.delChord(7);

        // Should play: C D G r C r G C
//        chordChart.setTempo(99);
//        chordChart.incTempo();
//        System.out.println("Tempo: " + chordChart.getTempo());
//        chordChart.play();
//        chordChart.play(6); // sounds nice and glitchy
    }
}