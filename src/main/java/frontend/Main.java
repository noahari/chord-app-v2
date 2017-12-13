package frontend;

import backend.ChordChart;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Main {
    static JFileChooser fc = new JFileChooser();
    static UIBuilder uiBuilder = new GenericUIBuilder();;

    public static void main(String[] args) {
        // ask if open an old file or create a new one

        // if opening old file
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
        jfc.setDialogTitle("Select a chart");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ChordFace Files", "chordface");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String path = jfc.getSelectedFile().getPath();
            System.out.println(path);
            ChordChart chart = ChordChart.fileToChart(path);
            System.out.println(chart.toString());
            chart.play();

            uiBuilder.makeUI(chart, new KeyMore("Cmaj"));
        }
    }
}
