package frontend;

import backend.ChordChart;
import org.jfugue.theory.Key;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalParametersPanel extends Panel implements ActionListener {
    private JTextField tempo;
    private JPanel panel;
    private JComboBox<String> keys;
    private JButton playButton;

    private final String[] ALLKEYS = {"CMaj", "GMaj", "DMaj", "AMaj", "EMaj", "BMaj", "F#Maj", "C#Maj",
            "FMaj", "BBMaj", "EBMaj", "ABMaj", "DBMaj", "GBMaj", "CBMaj", "amin", "emin", "bmin", "f#min", "c#min", "g#min", "d#min",
            "a#min", "dmin", "gmin", "cmin", "fmin", "bBmin", "eBmin", "aBmin"};

    public GlobalParametersPanel(UI userInterface) {
        super(userInterface);
        $$$setupUI$$$();
        panel.setPreferredSize(new Dimension(500, 200));
    }

    public void draw() {
        this.repaint();
        $$$setupUI$$$();
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) evt.getSource();
            KeyMore key = new KeyMore((String) cb.getSelectedItem());
            getUserInterface().setKey(key);
        } else if (evt.getSource() instanceof JTextField) {
            String tText = tempo.getText();
            int tInt = 120;
            try {
                tInt = Integer.parseInt(tText);
                if (tInt > 220 || tInt < 40) throw new NumberFormatException("Invalid");
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Enter Valid Tempo (from 40-220)");
                tempo.setText("120");
            }
            ChordChart chordChart = new ChordChart(getUserInterface().getChordChart().getChordList());
            chordChart.setTempo(tInt);
            this.getUserInterface().setChordChart(chordChart);
        } else {
            this.getUserInterface().getChordChart().play();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        keys = new JComboBox<>(ALLKEYS);
        keys.setSelectedIndex(0);
        keys.addActionListener(this);
        tempo = new JTextField("120");
        tempo.addActionListener(this);
        playButton = new JButton("Play");
        playButton.addActionListener(this);
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
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(keys, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panel.add(tempo, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, 24), null, 0, false));
        panel.add(playButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
