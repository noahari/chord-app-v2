package frontend;

public interface UIBuilder {
    public void makeNotationPanel();
    public void makeButtonsPanel();
    public void makeUI(backend.ChordChart  chart, KeyMore key);
    public UI getUI();
    public void makeGlobalParamsPanel();
}
