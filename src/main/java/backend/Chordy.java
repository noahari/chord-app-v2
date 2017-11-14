package backend;
import org.jfugue.theory.*;

class Chordy extends Chord {

    private String duration;

    public Chordy(String root, String extension, String duration) {
        super(root + extension + duration);
        if(!this.getRoot().isOctaveExplicitlySet()) getRoot().setOctaveExplicitlySet(true);
        this.duration = duration;
    }

    public void decDur(){
        switch (this.duration){
            case "w":
                this.duration = "h";
                break;
            case "h":
                this.duration = "q";
                break;
            case "q":
                this.duration = "i";
                break;
            case "i":
                this.duration = "s";
                break;
            case "s":
                this.duration = "t";
                break;
            case "t":
                this.duration = "x";
                break;
            case "x":
                this.duration = "o";
                break;
            case "o":
                break;
        }
    }

    public void incDur(){
        switch (this.duration){
            case "o":
                this.duration = "x";
                break;
            case "x":
                this.duration = "t";
                break;
            case "t":
                this.duration = "s";
                break;
            case "s":
                this.duration = "i";
                break;
            case "i":
                this.duration = "q";
                break;
            case "q":
                this.duration = "h";
                break;
            case "h":
                this.duration = "w";
                break;
            case "w":
                break;
        }
    }

    public void incOct(){
        if(this.getRoot().getValue() <= 115) this.getRoot().changeValue(12);

    }

    public void incOct(int n){
        if(this.getRoot().getValue()+ (12* n) <= 127) this.getRoot().changeValue(12*n);
    }

    public void decOct(){
        if(this.getRoot().getValue() >= 12) this.getRoot().changeValue(-12);
    }

    public void decOct(int n){
        if(this.getRoot().getValue()- (12 * n) >= 0) this.getRoot().changeValue(-12*n);
    }

    //Returns the octave of the chord
    public int getOct(){
        return Byte.toUnsignedInt(this.getRoot().getOctave());
    }

    //helper function to detect the note of a chordy without its octave
    public String detNote(){
        return this.getRoot().toStringWithoutDuration().replaceAll("[\\d.]", "");
    }

    //Raises chord by 1 half step
    public void incRoot() {
        if(this.getRoot().getValue() <= 126) this.getRoot().changeValue(1);
    }

    //Lowers chord by 1 half step
    public void decRoot() {
        if(this.getRoot().getValue() >= 1) this.getRoot().changeValue(-1);
    }

    //<editor-fold desc="Getters and Setters">

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    //</editor-fold>


}
