package backend;

import org.jfugue.theory.Note;

public class Resty extends Note implements Useable{

    public Resty(Duration duration) {
        super("R"+duration.getDur());
    }

    public boolean isRest(){
        return super.isRest();
    }
}
