package backend;
import org.jfugue.theory.*;

public class Chordy extends Chord {

    private Duration duration;
    //For easy reference to root
    private Note root = this.getRoot();


    public Chordy(String rootStr, String extension, Duration duration) {
        super(rootStr + extension);
        if(!root.isOctaveExplicitlySet()) root.setOctaveExplicitlySet(true);
        this.duration = duration;
    }

    public void decDur(){
        duration.decDur();
    }

    public void incDur(){
        duration.incDur();
    }

    public void incOct(){
        if(root.getValue() <= 115) root.changeValue(12);

    }

    public void incOct(int n){
        if(root.getValue()+ (12* n) <= 127) root.changeValue(12*n);
    }

    public void decOct(){
        if(root.getValue() >= 12) root.changeValue(-12);
    }

    public void decOct(int n){
        if(root.getValue()- (12 * n) >= 0) root.changeValue(-12*n);
    }

    //Returns the octave of the chord
    public int getOct(){
        return Byte.toUnsignedInt(root.getOctave());
    }

    //helper function to detect the note of a chordy without its octave
    public String detNote(){
        return root.toStringWithoutDuration().replaceAll("[\\d.]", "");
    }

    //Raises chord by 1 half step
    public void incRoot() {
        if(root.getValue() <= 126) root.changeValue(1);
    }

    //Lowers chord by 1 half step
    public void decRoot() {
        if(root.getValue() >= 1) root.changeValue(-1);
    }

    //<editor-fold desc="Getters and Setters">

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    //</editor-fold>

    public String toString() {
        return super.toString() + duration;
    }

}
