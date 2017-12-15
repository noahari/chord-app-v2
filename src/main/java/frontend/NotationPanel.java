package frontend;

import backend.ChordChart;
import backend.Duration;
import org.jfugue.theory.Chord;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("Convert2Lambda")
public class NotationPanel extends Panel {
    //private ArrayList<DrawnChord> drawnChordList;
    private JPanel panel1;
    private JTable TrackerTable;
    private JScrollPane scrollPane;
    private JComboBox<Duration> durBox;
    private JButton delButton;
    private JButton shiftDownButton;
    private JButton shiftUpButton;
    private JTabbedPane tabbedPane1;
    private JPanel generalTab;
    private JComboBox<String> extBox;
    private JList<String> extList;
    private JButton resetButton;
    private JTable extTable;
    private final String[] COL_NAMES = new String[]{"Root", "Extension", "Duration"};
    private DefaultTableModel tableModel;
    private final DefaultComboBoxModel<Duration> DB_MODEL = new DefaultComboBoxModel<>(new Duration[]{
            Duration.WHOLE,
            Duration.HALF,
            Duration.QUARTER,
            Duration.EIGHTH,
            Duration.SIXTEENTH,
            Duration.THIRTYSECOND,
            Duration.SIXTYFOURTH,
            Duration.ONETWENTYEIGHTH
    });


    public NotationPanel(UI userInterface) {
        super(userInterface);
        $$$setupUI$$$();
        panel1.setPreferredSize(new Dimension(800, 500));
        updateTable();
        setUpControl();
    }


    //JTable TrackerTable = new JTable(ChordChart.chordList);
    public void draw(Object arg) {
        updateTable();
    }

    /*
        // if this sucks just delete it:
        public void updateDrawnChordList(){
            ArrayList<DrawnChord> retlist = new ArrayList<>();
            for (Useable chord : userInterface.chordChart.getChordList()){
                retlist.add(new DrawnChord((Chordy) chord));
            }
            this.drawnChordList = retlist;
        }
    */
    private void updateTableModel() {
        this.tableModel = new DefaultTableModel(
                this.getUserInterface().getChordChart().toTableArray(),
                COL_NAMES
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private void updateTable() {
        updateTableModel();
        this.TrackerTable.setModel(this.tableModel);
    }

    private void setUpControl() {
        // set up duration box:
        durBox.setModel(DB_MODEL);
        durBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (TrackerTable.getSelectedRows().length > 0) {
                    int placeholder = TrackerTable.getSelectedRow();
                    //int endholder = TrackerTable.getSelectedRows()[TrackerTable.getSelectedRows().length - 1];
                    tableSetDur(TrackerTable.getSelectedRows(), (Duration) durBox.getSelectedItem());
                    TrackerTable.changeSelection(placeholder, 2, false, false);
                    //TrackerTable.changeSelection(endholder, 2, false, true);
                }
            }
        });

        // set up delete button:
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (TrackerTable.getSelectedRows().length > 0) {
                    int placeholder = TrackerTable.getSelectedRow();
                    tableDelChord(TrackerTable.getSelectedRows());
                }
                TrackerTable.clearSelection();
            }
        });

        // set up shiftUp button:
        shiftUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (TrackerTable.getSelectedRows().length > 0) {
                    int placeholder = TrackerTable.getSelectedRow();
                    tableShiftUp(TrackerTable.getSelectedRow());
                    TrackerTable.changeSelection(placeholder - 1, 0, false, false);
                }
            }
        });

        // set up shiftDown button:
        shiftDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (TrackerTable.getSelectedRows().length > 0) {
                    int placeholder = TrackerTable.getSelectedRow();
                    tableShiftDown(TrackerTable.getSelectedRow());
                    TrackerTable.changeSelection(placeholder + 1, 0, false, false);
                }
            }
        });

        // set up extension list:
        this.extList.setListData(reverse(Chord.getChordNames()));
        this.extList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (TrackerTable.getSelectedRows().length > 0) {
                    int placeholder = TrackerTable.getSelectedRow();
                    //int endholder = TrackerTable.getSelectedRows()[TrackerTable.getSelectedRows().length - 1];
                    tableSetExt(extList.getSelectedValue(), TrackerTable.getSelectedRows());
                    TrackerTable.changeSelection(placeholder, 1, false, false);
                    //TrackerTable.changeSelection(endholder, 1, false, true);
                }
            }
        });

        this.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetTable();
            }
        });
    }

    public String[] reverse(String[] array) {
        String[] retArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            retArray[array.length - 1 - i] = array[i];
        }
        return retArray;
    }

    public void resetTable() {
        ChordChart cc = getUserInterface().getChordChart();
        getUserInterface().setChordChart(new ChordChart(cc.getTempo()));
    }

    private void tableSetExt(String ext, int[] array) {
        ChordChart cc = getUserInterface().getChordChart();
        for (int anArray : array) {
            cc.getChord(anArray).setExtension(ext);
        }
        getUserInterface().setChordChart(cc);
    }

    private void tableShiftDown(int i) {
        ChordChart cc = getUserInterface().getChordChart();
        cc.moveChord(i, i + 1);
        getUserInterface().setChordChart(cc);
    }

    private void tableShiftUp(int i) {
        ChordChart cc = getUserInterface().getChordChart();
        cc.moveChord(i, i - 1);
        getUserInterface().setChordChart(cc);
    }

    private void tableDelChord(int[] array) {
        ChordChart cc = getUserInterface().getChordChart();
        for (int i = 0; i < array.length; i++) {
            cc.delChord(array[i] - i);
        }
        getUserInterface().setChordChart(cc);
    }

    private void tableSetDur(int[] array, Duration duration) {
        ChordChart cc = getUserInterface().getChordChart();
        getUserInterface().setDuration(duration);
        for (int anArray : array) {
            cc.getUseable(anArray).setDur(duration);
        }
        getUserInterface().setChordChart(cc);
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        scrollPane = new JScrollPane();
        panel1.add(scrollPane, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        TrackerTable = new JTable();
        scrollPane.setViewportView(TrackerTable);
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        generalTab = new JPanel();
        generalTab.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("General", generalTab);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        generalTab.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        shiftDownButton = new JButton();
        shiftDownButton.setText("Shift Down");
        panel2.add(shiftDownButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shiftUpButton = new JButton();
        shiftUpButton.setText("Shift Up");
        panel2.add(shiftUpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        delButton = new JButton();
        delButton.setText("Delete Selected");
        delButton.setToolTipText("delete the chord selected in the Tracker Table");
        generalTab.add(delButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        durBox = new JComboBox();
        generalTab.add(durBox, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        resetButton = new JButton();
        resetButton.setText("Reset");
        generalTab.add(resetButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        tabbedPane1.addTab("Extensions", scrollPane1);
        extList = new JList();
        scrollPane1.setViewportView(extList);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
