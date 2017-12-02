package backend;

import com.sun.xml.internal.fastinfoset.util.QualifiedNameArray;

class Test {
    public static void main(String[] args){
//        Player player = new Player();
//        player.play("C D E F G A B C6");

        Duration dur = Duration.ONETWENTYEIGHTH;
        System.out.println(dur.getDur());


        dur.incDur();
        System.out.println(dur.getDur());

        ChordChart chordChart = new ChordChart();

//        Chordy c = new Chordy("C5", "maj7", Duration.WHOLE);
//
//        System.out.println("c: " + c.getRoot().getToneString());
//
//        Chordy d = new Chordy("C5","maj7", Duration.WHOLE);
//
//        System.out.println("d: " + d.getRoot().getToneString());
//
//        c.incRoot();
//
//        System.out.println("c: " + c.getRoot().getToneString());
//
//        chordChart.insertUseable(c);
//
//        chordChart.insertUseable(d);
//
//        //chordChart.restChord(1);
//
//        for(Useable u : chordChart.getChordList()){
//            System.out.println(u);
//        }
//
//        chordChart.play();

        Chordy blah = new Chordy("C5", "maj7", Duration.QUARTER);
        System.out.println(blah.toString());
        blah.setDuration("w");
        System.out.println(blah.toString());


        chordChart.insertUseable(new Chordy("C", "maj7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("D", "min7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("G", "dom7", Duration.QUARTER));
        chordChart.insertUseable(new Resty(12));

        String home = System.getProperty("user.home");
        chordChart.toFile(home+"/Downloads");
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
