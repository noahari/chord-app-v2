package frontend;

import backend.Chordy;
import backend.Duration;
import backend.ChordChart;
import org.jfugue.theory.Intervals;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ButtonsPanel extends Panel implements ActionListener {
    UI userInterface;

    ArrayList<JButton> usedButtonList = new ArrayList<>();
    ArrayList<JButton> nonUsedButtonList = new ArrayList<>();

    private JPanel panel;
    private JButton chordButton1;
    private JButton chordButton5;
    private JButton chordButton6;
    private JButton chordButton2;
    private JButton chordButton7;
    private JButton chordButton3;
    private JButton extraButton;
    private JButton chordButton4;
    private String extension; //Is this also in global params panel?

    public UI getUserInterface() {
        return userInterface;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ButtonsPanel");
        frame.setContentPane(new ButtonsPanel().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setUserInterface(UI userInterface) {
        this.userInterface = userInterface;
    }

    public ButtonsPanel() {
        $$$setupUI$$$();
        panel.setPreferredSize(new Dimension(900, 400));
    }

    public void rootButtonHit(JButton rootButton) {
        userInterface.getChordChart().insertUseable(new Chordy(rootButton.getName(), "", Duration.QUARTER));
    }

    public void actionPerformed(ActionEvent evt) {
        JButton button = (JButton) evt.getSource();
        if (!button.equals(extraButton)) {
            ChordChart chordChart = this.getUserInterface().getChordChart();
            String note = ((ImageIcon) button.getIcon()).getDescription();
            Chordy chord = new Chordy(note, this.extension, Duration.QUARTER);
            chordChart.insertUseable(chord);
            this.getUserInterface().setChordChart(chordChart);
        } else {
            //ADD JMENU OR WHATEVER WITH BUTTONS IN NONUSED LIST
        }
    }

    private void getButtons() throws IOException {
        //GlobalParametersPanel globalParametersPanel = userInterface.getGlobalParametersPanel();
        //Key key = globalParametersPanel.getKey();
        Key key = new Key("Cmaj");
        Set<String> chromaticNotes = ButtonsPanel.getChromaticNotes();
        String[] chromaticNotesArr = chromaticNotes.toArray(new String[0]);
        key.getScale().getIntervals().setRoot(key.getRoot());
        List<Note> keyNotes = key.getScale().getIntervals().getNotes();
        System.out.println(keyNotes);
        for (int i = 0; i < chromaticNotesArr.length; i++) {
            Note n = new Note(chromaticNotesArr[i] + "4");
            if (keyNotes.contains(n)) {
                usedButtonList.add(toIcon(n));
                chromaticNotes.remove(n.toString());
            } else {
                nonUsedButtonList.add(toIcon(n));
            }
        }
    }

    public static Set<String> getChromaticNotes() {
        Intervals chromatic = new Intervals("1 #1 2 #2 3 4 #4 5 #5 6 #6 7 #7");
        chromatic.setRoot("C5");
        Set<String> chromaticNotes = new LinkedHashSet<>();
        for (Note n : chromatic.getNotes()) {
            chromaticNotes.add(Note.getDispositionedToneStringWithoutOctave(1, n.getValue()));
            chromaticNotes.add(Note.getDispositionedToneStringWithoutOctave(-1, n.getValue()));
        }
        return chromaticNotes;
    }

    public void draw() {
        createUIComponents();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            this.getButtons();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        chordButton1 = usedButtonList.get(0);
        chordButton1.addActionListener(this);
        chordButton2 = usedButtonList.get(1);
        chordButton1.addActionListener(this);
        chordButton3 = usedButtonList.get(2);
        chordButton1.addActionListener(this);
        chordButton4 = usedButtonList.get(3);
        chordButton1.addActionListener(this);
        chordButton5 = usedButtonList.get(4);
        chordButton1.addActionListener(this);
        chordButton6 = usedButtonList.get(5);
        chordButton1.addActionListener(this);
        chordButton7 = usedButtonList.get(6);
        chordButton1.addActionListener(this);


        //I tried to use an Array and iterate over it but it didn't work??

//        chordButton1 = new JButton();
//        chordButton1.setIcon(this.getIconList().get(0));
//        chordButton1.setText(this.getIconList().get(0).getDescription());
//        chordButton1.addActionListener(this);
//        chordButton2 = new JButton();
//        chordButton2.setIcon(this.getIconList().get(1));
//        chordButton2.addActionListener(this);
//        chordButton3 = new JButton();
//        chordButton3.setIcon(this.getIconList().get(2));
//        chordButton3.addActionListener(this);
//        chordButton4 = new JButton();
//        chordButton4.setIcon(this.getIconList().get(3));
//        chordButton4.addActionListener(this);
//        chordButton5 = new JButton();
//        chordButton5.setIcon(this.getIconList().get(4));
//        chordButton5.addActionListener(this);
//        chordButton6 = new JButton();
//        chordButton6.setIcon(this.getIconList().get(5));
//        chordButton6.addActionListener(this);
//        chordButton7 = new JButton();
//        chordButton7.setIcon(this.getIconList().get(6));
//        chordButton7.addActionListener(this);
//        extraButton = new JButton();
//        extraButton.setIcon(getEllipseIcon());
//        extraButton.addActionListener(this);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        chordButton1.setText("");
        panel.add(chordButton1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton5.setText("");
        panel.add(chordButton5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton6.setText("");
        panel.add(chordButton6, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton2.setText("");
        panel.add(chordButton2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton7.setText("");
        panel.add(chordButton7, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton3.setText("");
        panel.add(chordButton3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        extraButton = new JButton();
        extraButton.setText("");
        panel.add(extraButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chordButton4.setText("");
        panel.add(chordButton4, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}


