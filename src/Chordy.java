public class Chordy {

    String root;
    String extension;
    String duration;

    public Chordy(String root, String extension, String duration) {
        this.root = root;
        this.extension = extension;
        this.duration = duration;
    }

    public String toString() {
        return root + extension + duration;
    }
    
    public void toRest() {
        this.root = "R";
        this.extension = "";
    }

}
