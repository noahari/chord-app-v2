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

    public static Boolean isValidDur(String dur){
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
