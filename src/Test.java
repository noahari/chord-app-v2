public class Test {
    public static void main(String[] args){
//        Player player = new Player();
//        player.play("C D E F G A B C6");
        ChordChart chordChart = new ChordChart();

        chordChart.insertChord(new Chordy("C", "maj7", "w"));
        chordChart.insertChord(new Chordy("D", "min7", "w"));
        chordChart.insertChord(new Chordy("G", "dom7", "w"));
        chordChart.insertChord(new Chordy("C", "maj7", "w"));

        chordChart.play();
    }
}
