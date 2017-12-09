package frontend;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class PanelTest {

    //C has no sharps or flats, however none of its notes need correction
    //so its values should evaluate to the default i.e. True.
    private static final String[] SHARPKEYS = {"C", "G", "D", "A", "E", "B", "F#", "C#"};

    private static final String[] FLATKEYS = {"F", "BB", "EB", "AB", "DB", "GB", "CB"};
}


