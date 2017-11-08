# chord-app-v2

### Chordy:

Name | Purpose
 --- | --- 
toString() | returns a properly formatted chord in string form
toRest() | turns the chord into a rest
getRoot() | getter for Root
getExtension() | getter for Extension
getDuration() | getter for Duration
setRoot(String root) | setter for Root
setExtension(String extension) | setter for Extension
setDuration(String duration) | setter for Duration
decDur() | shortens a chordy by exactly one jfugue duration interval
incDur() | lengthens a chordy by exactly one jfugue duration interval
incOct() | increments octave of `root` (i.e. from "C5" to "C6")
decOct() | decrements octave of `root` (i.e. from "C6" to "C5")
detNote() | detects the note of a chordy and returns it as a String
detOct() | detects the octave of a chordy and returns it as an int
incRoot() | increments `root` (i.e. from "C" to "D")
decRoot() | decrements `root` (i.e. from "D" to "C")

#### ideas: (*see below "Things to consider", and please add things*)
Name | Purpose
 --- | --- 
Method Name | Method Purpose

### ChordChart:

Name | Purpose
 --- | --- 
getChordList() | returns the array of chords in ChordChart
getChordList(int index) | returns chordList starting from index
getTempo() | returns the tempo (as a string)
setChordList(ArrayList<Chordy> chordList) | setter for ChordList
setTempo(String tempo) | setter for Tempo
incTempo() | increments tempo by 1
decTempo() | decrements tempo by 1
insertChord(Chordy chord) | adds a chord to the end of the chart
insertChord(int index, Chordy chord) | adds a chord to a particular place
toString() | returns a string properly formatted for JFugue to play
toString(int index) | returns the string starting at index
play() | plays the ChordChart!
play(int index) | plays the ChordChart starting at index
delChord(int index) | delete a chord from a particular place
getChord(int index) | return a particular chord
restChord(int index) | replace a particular chord with a rest
toFile() | outputs a midi file of a ChordChart

##### Things to consider
 - is `(int index)` a good way of setting up parameters?
   depends on how we set up the GUI. for example, if we did end up using time signatures,
   it would make sense to have `(int measure, int beat)`.
   Even if its harder to program, its ultimately easier to use when making the GUI.
   We don't need to change it now, but its something to think about before implementing GUI.
 - is it useful to have `play(int start, int end)`?  Also applies to `toString` and `getChordList`.
 - I think there is a `Tempo` class.  Should `tempo` be of type `Tempo`?
 - How can we make the piano not clip out at the end of playing? Adding a rest doesn't work.
 - is it useful to represent `root` as an `int`?
   that way, we can just `root++` instead of trying to turn `"C"` into `"D"`.
   and an octave is just `root+12`. seems very useful. but its certainly harder to look at for us.
   
   we should investigate JFugue; there could be a class for this `Root root = new Root("C")`.
   Also consider applying this type of thinking to `duration`.
        -I did not apply this type of thinking to duration for the time being,
         but it should be easy enough to refactor if we implement any sort of methods
         to translate between string and int for these things
         
  - We may also want to consider that in order to change octave as a separate action from changing
     the note, that is to say not just indicating C5 to C6 being a note change, we will likely need to
     add an octave component to Chordy. This would be easy but would require checking all existing code
     to make sure it doesn't break anything.
