package frontend;

import backend.ChordChart;

import javax.swing.*;
import javax.swing.filechooser.*;

class Main {
    private static final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView());
    private static final UIBuilder uiBuilder = new GenericUIBuilder();
    private static final JFrame frame = new JFrame("Chordy McChordface");

    public static void main(String[] args) {
        // ask if open an old file or create a new one
        int n = ask();

        // if opening old file
        if(n == 1) {
            loadFile();
        }

        // initialize UI visual
        initializeUI();
    }

     static int ask() {
        Object[] options = {"New", "Load"};
        return JOptionPane.showOptionDialog(frame,
                "Load or Create a chart",
                "McChordface Startup",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[1]); //default button title
    }
    static void initializeUI() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(uiBuilder.getPanel());
        frame.pack();
        frame.setVisible(true);
    }

    static void loadFile() {
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
