package frontend;

import backend.ChordChart;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Main {
    private static final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
    private static final UIBuilder uiBuilder = new GenericUIBuilder();
    private static final JFrame frame = new JFrame("Chordy McChordface");

    public static void main(String[] args) {
        // ask if open an old file or create a new one
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
            loadFile();
        }

        // initialize UI visual
        initializeUI();
    }

    private static void initializeUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(uiBuilder.getPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private static void loadFile() {
        fc.setDialogTitle("Select a chart");
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Chordface Files",
                "chordface");
        fc.addChoosableFileFilter(filter);

        int returnValue = fc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getPath();
            ChordChart chart = ChordChart.fileToChart(path);
            uiBuilder.getUI().setChordChart(chart);
            String fileName = fc.getSelectedFile().getName();
            uiBuilder.getGlobalParamsPanel().setFileName(fc.getSelectedFile().getName().substring(0, fileName.length() - 10));
            uiBuilder.getGlobalParamsPanel().setTempo(chart.getTempo());
        }
    }
}
