package backend;

import org.junit.Test;
import static org.junit.Assert.*;

public class RestyTest {
    @Test
    public void isRest() throws Exception {
        Resty restytesty = new Resty(Duration.WHOLE);
        assertEquals(true, restytesty.isRest());
    }

    @Test
    public void getRow() throws Exception {
        Resty restytesty = new Resty(Duration.WHOLE);
        String[] testArray = new String[]{
                "R",
                "",
                "WHOLE"
                //This test fails **IT SHOULD RETURN "WHOLE", instead it returns 1.0**
                // since a rest is a note, and therefore the duration is represented numerically,
                //therefore, we need to update this method for the sake of UI display consistency
        };
        assertArrayEquals(testArray, restytesty.getRow());
    }
}
