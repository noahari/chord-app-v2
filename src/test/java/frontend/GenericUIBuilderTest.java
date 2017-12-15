package frontend;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericUIBuilderTest {
    private UIBuilder uiBuilder;

    @Before
    public void setUp(){
        uiBuilder = new GenericUIBuilder(); //Constructor calls each "make" method
    }

    @After
    public void tearDown(){
        uiBuilder = null;
    }

    @Test
    public void makeNotationPanel(){
        assertNotNull(uiBuilder.getNotationPanel());
    }

    @Test
    public void makeButtonsPanel(){
        assertNotNull(uiBuilder.getButtonsPanel());
    }

    @Test
    public void makeUI(){
        assertNotNull(uiBuilder.getUI());
    }

    @Test
    public void makeGlobalParamsPanel(){
        assertNotNull(uiBuilder.getGlobalParamsPanel());
    }

}