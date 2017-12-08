package frontend;

import org.jfugue.theory.Note;
import org.junit.Test;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.mockito.Mockito.*;
import javax.swing.*;

import static org.junit.Assert.*;

import java.io.IOException;

public class ButtonsPanelTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Note note;

    @Test
    public void toIconsTest(){
        ButtonsPanel buttonsPanel = new ButtonsPanel();
        try {
            when(note.toString()).thenReturn("C5");
            buttonsPanel.toIcons(note);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        assertEquals(buttonsPanel.getIconList().get(0).getDescription(), "C");
    }

    @Test
    public void getButtonsTest(){
        ButtonsPanel buttonsPanel = new ButtonsPanel();
        buttonsPanel.getButtons();
        assertEquals(buttonsPanel.getIconList().size(), 7);
    }
}
