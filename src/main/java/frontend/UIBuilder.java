package frontend;

import javax.swing.*;

public interface UIBuilder {
    void makeNotationPanel();
    NotationPanel getNotationPanel();
    void makeButtonsPanel();
    void makeUI(backend.ChordChart  chart, KeyMore key);
    UI getUI();
    void makeGlobalParamsPanel();
    GlobalParametersPanel getGlobalParamsPanel();
    JPanel getPanel();
    ButtonsPanel getButtonsPanel();
}
