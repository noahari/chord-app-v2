package backend;

import org.junit.Test;
import static org.junit.Assert.*;

public class DurationTest {

    @Test
    public void setDur(){
        Duration duration = Duration.HALF;
        String dur = "o";
        duration.setDur(dur);
        assertEquals(dur, duration.getDur());
    }

    @Test
    public void isValidDur(){
        String[] testArrayValid = new String[]{
            "w",
            "h",
            "q",
            "i",
            "s",
            "t",
            "x",
            "o"
        };
        String invalidDur = "THIS IS NOT A VALID DURATION";
        for(int i = 0; i < 8; i++){
            assertEquals(true, Duration.isValidDur(testArrayValid[i]));
        }
        assertEquals(false, Duration.isValidDur(invalidDur));
    }
}
