package backend;

public enum Duration {
    WHOLE("w"),
    HALF("h"),
    QUARTER("q"),
    EIGHTH("i"),
    SIXTEENTH("s"),
    THIRTYSECOND("t"),
    SIXTYFOURTH("x"),
    ONETWENTYEIGHTH("o");

    private String duration;
    Duration(String duration){
        this.duration = duration;
    }

    public String getDur(){
        return this.duration;
    }

    public void setDur(String dur){
        this.duration = dur;
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

    public Boolean isValidDur(String dur){
        if(dur.equals("w") ||
                dur.equals("h") ||
                dur.equals("q") ||
                dur.equals("i") ||
                dur.equals("s") ||
                dur.equals("t") ||
                dur.equals("x") ||
                dur.equals("o")) {
            return true;
        }
        else {
            return false;
        }
    }
}
