package frontend;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;

public class MainTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Main main;

    @Test
    public void main() throws Exception {
        Mockito.when(main.ask()).thenReturn(0);

        Mockito.verify(main, Mockito.times(0)).loadFile();
    }

}