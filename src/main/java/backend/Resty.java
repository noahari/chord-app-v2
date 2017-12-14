package backend;

import org.jfugue.theory.Note;

public class Resty extends Note implements Useable{

    private Duration duration;

    public Resty(Duration duration) {
        super("R"+duration.getDur());
        this.duration = duration;
    }

    public boolean isRest(){
        return true;
    }

    public String[] getRow() {
	    return new String[]{
		    "R",
		    "",
		    duration.toString() // this was originally giving back a double, now it gives back the string
	    };
    }
    public void setDur(Duration dur) {
        this.duration = dur;
    }
}
