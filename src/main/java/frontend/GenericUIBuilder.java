package frontend;

import backend.*;

public class GenericUIBuilder implements UIBuilder{
    UI userInterface;

    //All of these "make" methods need to be tied to the actual GUI
    //but .add is kind of the intuition
    public void makeNotationPanel(){
       userInterface.add(new NotationPanel());
    }
    public void makeButtonsPanel(){
        userInterface.add(new ChordButtonsPanel());
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
        userInterface.add(new GlobalParametersPanel());
    }
}
