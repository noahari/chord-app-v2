package backend;
import org.jfugue.theory.*;

public class Chordy extends Chord implements Useable {

    private Duration duration;
    //For easy reference to root
    private final Note root = this.getRoot();


    public Chordy(String rootStr, String extension, Duration duration) {
        super(rootStr + extension);
        if(!root.isOctaveExplicitlySet()) root.setOctaveExplicitlySet(true);
        this.duration = duration;
    }

    public void incDur(){
        switch (this.duration){
            case ONETWENTYEIGHTH:
                this.duration = Duration.SIXTYFOURTH;
                break;
            case SIXTYFOURTH:
                this.duration = Duration.THIRTYSECOND;
                break;
            case THIRTYSECOND:
                this.duration = Duration.SIXTEENTH;
                break;
            case SIXTEENTH:
                this.duration = Duration.EIGHTH;
                break;
            case EIGHTH:
                this.duration = Duration.QUARTER;
                break;
            case QUARTER:
                this.duration = Duration.HALF;
                break;
            case HALF:
                this.duration = Duration.WHOLE;
                break;
            case WHOLE:
                break;
        }
    }

    public void decDur(){
        switch (this.duration){
            case WHOLE:
                this.duration = Duration.HALF;
                break;
            case HALF:
                this.duration = Duration.QUARTER;
                break;
            case QUARTER:
                this.duration = Duration.EIGHTH;
                break;
            case EIGHTH:
                this.duration = Duration.SIXTEENTH;
                break;
            case SIXTEENTH:
                this.duration = Duration.THIRTYSECOND;
                break;
            case THIRTYSECOND:
                this.duration = Duration.SIXTYFOURTH;
                break;
            case SIXTYFOURTH:
                this.duration = Duration.ONETWENTYEIGHTH;
                break;
            case ONETWENTYEIGHTH:
                break;
        }
    }


    void incOct(){
        if(root.getValue() <= 115) root.changeValue(12);
    }

    void incOct(int n){
        if(root.getValue()+ (12* n) <= 127) root.changeValue(12*n);
    }

    void decOct(){
        if(root.getValue() >= 12) root.changeValue(-12);
    }

    void decOct(int n){
        if(root.getValue()- (12 * n) >= 0) root.changeValue(-12*n);
    }

    //Returns the octave of the chord
    int getOct(){
        return Byte.toUnsignedInt(root.getOctave());
    }

    //helper function to detect the note of a chordy without its octave
    String detNote(){
        return root.toStringWithoutDuration().replaceAll("[\\d.]", "");
    }

    //Raises chord by 1 half step
    void incRoot() {
        if(root.getValue() <= 126) root.changeValue(1);
    }

    //Lowers chord by 1 half step
    void decRoot() {
        if(root.getValue() >= 1) root.changeValue(-1);
    }

    public boolean isRest(){return false;}

    public String[] getRow() {
	    return new String[]{
		    this.getRoot().toString(),
		    this.getChordType(),
		    this.getDuration().toString()
	    };
    }

    //<editor-fold desc="Getters and Setters">

    Duration getDuration() {
       return duration;
    }

    String getDurationString(){return duration.getDur();}

    void setDuration(String dur) {
        duration.setDur(dur);
    }

    public void setDur(Duration dur) {
        this.duration = dur;
    }
    //</editor-fold>

    public String toString() {
        return super.toString() + duration;
    }


}
