package frontend;

import javax.swing.*;
import java.awt.*;

public interface UIBuilder {
    public void makeNotationPanel();
    public void makeButtonsPanel();
    public void makeUI(backend.ChordChart  chart, KeyMore key);
    public UI getUI();
    public void makeGlobalParamsPanel();
    public GlobalParametersPanel getGlobalParamsPanel();
    public JPanel getPanel();
}
