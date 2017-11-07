public class Test {
    public static void main(String[] args){
//        Player player = new Player();
//        player.play("C D E F G A B C6");
        ChordChart chordChart = new ChordChart();

        chordChart.insertChord(new Chordy("C", "maj7", "q"));
        chordChart.insertChord(new Chordy("D", "min7", "q"));
        chordChart.insertChord(new Chordy("G", "dom7", "q"));
        chordChart.insertChord(new Resty("q"));

        chordChart.insertChord(new Chordy("C", "maj7", "q"));
        chordChart.insertChord(new Chordy("D", "min7", "q"));

        // chord inserted here
        chordChart.insertChord(new Chordy("B", "dom9", "q"));
        chordChart.insertChord(new Chordy("C", "maj7", "q"));

        chordChart.insertChord(new Resty("w")); // note how it still cuts off sharply at the end...

        chordChart.restChord(5);
        chordChart.insertChord(6, new Chordy("G", "dom7", "q"));
        chordChart.delChord(7);

        // Should play: C D G r C r G C
        chordChart.setTempo(99);
        chordChart.incTempo();
        System.out.println("Tempo: " + chordChart.getTempo());
        chordChart.play();
        chordChart.play(6); // sounds nice and glitchy
    }
}
