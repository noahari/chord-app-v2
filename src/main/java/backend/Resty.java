package backend;

import org.jfugue.theory.Note;

public class Resty extends Note implements Useable{

    public Resty(Duration duration) {
        super("R"+duration.getDur());
    }

    public boolean isRest(){
        return true;
    }

    public String[] getRow() {
	    return new String[]{
		    "R",
		    "",
		    String.valueOf(this.getDuration())
	    };
    }
}
