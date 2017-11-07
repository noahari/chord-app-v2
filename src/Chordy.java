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

    public void shrinkChordy(){
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

    public void growChordy(){
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
