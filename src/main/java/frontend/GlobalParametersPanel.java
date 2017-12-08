package frontend;

import javax.swing.*;
import java.awt.*;

public class GlobalParametersPanel extends Panel {
    private int tempo;
    private String key;
    private JPanel Panel;

    public GlobalParametersPanel() {
    }

    public GlobalParametersPanel(int tempo, String key) {
        this.tempo = tempo;
        this.key = key;
    }

    public void draw() {
        new GlobalParametersPanel();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
