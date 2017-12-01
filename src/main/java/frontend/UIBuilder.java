package frontend;

public interface UIBuilder {
    public void makeNotationPanel();
    public void makeButtonsPanel();
    public void makeButtons();
    public void makeUI(backend.ChordChart  chart);
    public UI getUI();
    public void makeGlobalParamsPanel();
}
