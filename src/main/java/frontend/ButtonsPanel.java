package frontend;

import backend.Chordy;
import backend.Duration;
import backend.ChordChart;
import org.jfugue.theory.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class ButtonsPanel extends Panel implements ActionListener {

    private ArrayList<ChordButton> usedButtonList = new ArrayList<>();
    private ArrayList<String> nonUsedButtonList = new ArrayList<>();

    private JPanel panel;
    private ChordButton chordButton1, chordButton2, chordButton3, chordButton4,
            chordButton5, chordButton6, chordButton7;
    private ChordButton extraButton;

    public ButtonsPanel(UI userInterface) {
        super(userInterface);
        $$$setupUI$$$();
        panel.setPreferredSize(new Dimension(900, 400));
    }

    public ArrayList<ChordButton> getUsedButtonList() {
        return usedButtonList;
    }

    public void actionPerformed(ActionEvent evt) {
        ChordButton button = (ChordButton) evt.getSource();
        if (!button.equals(extraButton)) {
            ChordChart chordChart = this.getUserInterface().getChordChart();
            Chordy chord = new Chordy(button.getChord(), button.getExtension(), Duration.QUARTER);
            chordChart.insertUseable(chord);
            this.getUserInterface().setChordChart(chordChart);
        } else {
            ChordButton[] buttons = new ChordButton[]{chordButton1, chordButton2, chordButton3, chordButton4,
                    chordButton5, chordButton6, chordButton7};
            if (chordButton1.getChord().equals(getKey().stringCorrect(getKeyAsKey().getRoot())))
                for (int i = 0; i < nonUsedButtonList.size(); i++) {
                    buttons[i].resetText(nonUsedButtonList.get(i), "MAJ");
                }
            else {
                for (int i = 0; i < buttons.length; i++) {
                    try {
                        getButtons();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    buttons[i].resetText(usedButtonList.get(i).getChord(), usedButtonList.get(i).getExtension());
                }
            }
        }
    }

    private void getButtons() throws IOException {
        nonUsedButtonList = new ArrayList<>();
        Set<String> chromaticNotes = ButtonsPanel.getChromaticNotes();
        getKeyAsKey().getScale().getIntervals().setRoot(getKeyAsKey().getRoot());
        List<Note> keyNotes = getKeyAsKey().getScale().getIntervals().getNotes();
        if (usedButtonList.size() == 0) {
            for (Note n : keyNotes) {
                usedButtonList.add(toButton(n, keyNotes.indexOf(n)));
                String nStr = n.toString();
                chromaticNotes.remove(nStr.substring(0, nStr.length() - 1));
            }
        } else
            for (int i = 0; i < this.getUsedButtonList().size(); i++) {
                ChordButton b = getUsedButtonList().get(i);
                Note n = keyNotes.get(i);
                b.resetText(getKey(), n, keyNotes.indexOf(n));
                String nStr = n.toString();
                chromaticNotes.remove(nStr.substring(0, nStr.length() - 1));
            }
        nonUsedButtonList = toEnharmonics(chromaticNotes);
    }

    private static Set<String> getChromaticNotes() {
        Intervals chromatic = new Intervals("1 #1 2 #2 3 4 #4 5 #5 6 #6 7 #7");
        chromatic.setRoot("C5");
        Set<String> chromaticNotes = new LinkedHashSet<>();
        for (Note n : chromatic.getNotes()) {
            chromaticNotes.add(Note.getDispositionedToneStringWithoutOctave(1, n.getValue()));
            chromaticNotes.add(Note.getDispositionedToneStringWithoutOctave(-1, n.getValue()));
        }
        return chromaticNotes;
    }

    private static ArrayList<String> toEnharmonics(Set<String> set) {
        String[] notes = set.toArray(new String[]{});
        ArrayList<String> endList = new ArrayList<>();
        for (int i = 0; i < set.size() - 1; i++) {
            if (new Note(notes[i]).getValue() == new Note(notes[i + 1]).getValue()) {
                endList.add(notes[i] + "/" + notes[i + 1]);
                i += 1;
            } else endList.add(notes[i]);
        }
        return endList;
    }

    public void draw() {
        try {
            this.getButtons();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            this.getButtons();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //I tried to use an array to iterate it doesnt work?
        chordButton1 = usedButtonList.get(0);
        chordButton1.addActionListener(this);
        chordButton2 = usedButtonList.get(1);
        chordButton2.addActionListener(this);
        chordButton3 = usedButtonList.get(2);
        chordButton3.addActionListener(this);
        chordButton4 = usedButtonList.get(3);
        chordButton4.addActionListener(this);
        chordButton5 = usedButtonList.get(4);
        chordButton5.addActionListener(this);
        chordButton6 = usedButtonList.get(5);
        chordButton6.addActionListener(this);
        chordButton7 = usedButtonList.get(6);
        chordButton7.addActionListener(this);
        extraButton = new ChordButton();
        extraButton.setIcon(new ImageIcon("graphics/EllipseButton.png"));
        extraButton.addActionListener(this);
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
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(chordButton1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton6, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton7, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(extraButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel.add(chordButton4, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}


