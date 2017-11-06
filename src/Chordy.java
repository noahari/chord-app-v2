public class Chordy {

    String root;
    String extension;
    String duration;

    public Chordy(String root, String extension, String duration) {
        this.root = root;
        this.extension = extension;
        this.duration = duration;
    }

    public void toRest() {
        this.root = "R";
        this.extension = "";
    }

    //<editor-fold desc="Getters and Setters">
    public String getRoot(){
        return root;
    }

    public String getExtension() {
        return extension;
    }

    public String getDuration() {
        return duration;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    //</editor-fold>

    public String toString() {
        return root + extension + duration;
    }

}
