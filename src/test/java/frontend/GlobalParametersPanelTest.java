package frontend;

import backend.ChordChart;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

public class GlobalParametersPanelTest {
    private GlobalParametersPanel gpp;


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private UI ui;

    @Mock
    private ChordChart chordChart;

    @Mock
    private KeyMore key;

    @Spy
    private GlobalParametersPanel gpp2 = new GlobalParametersPanel(ui);

    @Before
    public void setUp(){
        chordChart = mock(ChordChart.class);
        key = mock(KeyMore.class);
        this.gpp = new GlobalParametersPanel(new UI(chordChart, key));
    }

    @Test
    public void actionPerformedComboBox(){
        gpp.keys.setSelectedIndex(1);
        verify(ui).setKey(any());
    }

    @Test
    public void actionPerformedTextField() {
        ChordChart chordChart = mock(ChordChart.class);
        KeyMore key = mock(KeyMore.class);
        this.gpp = new GlobalParametersPanel(new UI(chordChart, key));
        gpp.tempo.setText("100");
        gpp.tempo.postActionEvent();
        verify(chordChart).setTempo(100);
    }

    @Test
    public void actionPerformedTextFieldError(){
        gpp.tempo.setText("abcd");
        gpp.tempo.postActionEvent();
        verify(chordChart).setTempo(120);
    }

    @Test
    public void actionPerformedPlayButton(){
        gpp.playButton.doClick();
        verify(chordChart).play();
    }

    @Test
    public void actionPerformedSaveButton(){
        gpp.setFileName("File");
        gpp.save.doClick();
        verify(chordChart).saveFile("File");
    }

}