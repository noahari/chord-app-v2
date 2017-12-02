package backend;

import org.jfugue.theory.Note;

public class Resty extends Note implements Useable{

    public Resty(double duration) {
        super(createRest(duration));
    }

    public boolean isRest(){
        return super.isRest();
    }
}
