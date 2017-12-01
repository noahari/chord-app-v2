package frontend;

import backend.*;

public class GenericUIBuilder implements UIBuilder{
    UI userInterface;

    public void makeNotationPanel(){
        // dothis
    }
    public void makeButtonsPanel(){
        // dothis
    }
    public void makeButtons(){
        // dothis
    }
    public void makeUI(ChordChart chord){
        userInterface = new UI(chord);
    }
    public UI getUI(){
        return this.userInterface;
    }
    public void makeGlobalParamsPanel(){
        // dothis
    }
}
