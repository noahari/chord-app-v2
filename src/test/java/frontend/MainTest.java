package frontend;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class MainTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Main main;

    @Test
    public void main0() throws Exception {
        doReturn(0).when(Main.ask());
        verify(main).initializeUI();
    }

    @Test
    public void main1() throws Exception{
        doReturn(1).when(Main.ask());
        verify(main).loadFile();
        verify(main).initializeUI();
    }

}