package backend;

class Test2 {
    public static void main(String[] args){

        //ChordChart chordChart = new ChordChart();

        /*
        chordChart.insertUseable(new Chordy("C", "maj7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("D", "min7", Duration.QUARTER));
        chordChart.insertUseable(new Resty(Duration.HALF));
        chordChart.insertUseable(new Chordy("G", "dom7", Duration.QUARTER));
        chordChart.insertUseable(new Chordy("C", "maj7", Duration.QUARTER));
        */

        String[][] array = new ChordChart().toTableArray();

        System.out.println("should work:");
        for(int i = 0; i < (new ChordChart().getChordList().size()); i++) {
            System.out.println(array[i][0] + " " + array[i][1] + " " + array[i][2]);
        }

        /*
        System.out.println("should work:");
        for (int j = 0; j < 3; j++){
            System.out.println(array[0][j]);
        }
        */

        /*
        System.out.println("should break:");
        for(int i = 0; i < (chordChart.getChordList().size()+1); i++) {
            System.out.println(array[i][0] + " " + array[i][1] + " " + array[i][2]);
        }
        */
    }

}