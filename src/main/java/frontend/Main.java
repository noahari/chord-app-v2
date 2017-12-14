package frontend;

import backend.ChordChart;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Main {
    static JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
    static UIBuilder uiBuilder = new GenericUIBuilder();;

    public static void main(String[] args) {

        // ask if open an old file or create a new one
        JFrame frame = new JFrame();

        Object[] options = {"New", "Load"};
        int n = JOptionPane.showOptionDialog(frame,
                "Load chart or Start a new chart",
                "McChordface Startup",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title

        // if opening old file
        if(n == 1) {
            fc.setDialogTitle("Select a chart");
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Chordface Files",
                    "chordface");
            fc.addChoosableFileFilter(filter);

            int returnValue = fc.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String path = fc.getSelectedFile().getPath();
                ChordChart chart = ChordChart.fileToChart(path);

                uiBuilder.makeUI(chart, new KeyMore("Cmaj"));

            } else {
                // else, makeUI for a generic chart
                System.out.println("making generic");
                uiBuilder.makeUI(new ChordChart(), new KeyMore("Cmaj"));
            }
        } else {
            // else, makeUI for a generic chart
            System.out.println("making generic");
            uiBuilder.makeUI(new ChordChart(), new KeyMore("Cmaj"));
        }

        // initialize UI frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(uiBuilder.getPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
