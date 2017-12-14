package frontend;

import javafx.scene.control.ButtonBar;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ButtonsPanelTest {


    @Test
    public void actionPerformed() throws Exception {
    }

    @Test
    public void draw(){
        UI ui = mock(UI.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        ButtonsPanel buttonsPanel = new ButtonsPanel(ui);
        buttonsPanel.draw(0);
        assertEquals(true, buttonsPanel.inKey);
    }

    @Test(expected = IOException.class)
    public void drawException(){
        UI ui = mock(UI.class);
        when(ui.getKey()).thenReturn(new KeyMore("Cmaj"));
        ButtonsPanel buttonsPanel = new ButtonsPanel(ui);
        buttonsPanel.draw(0);
    }

}