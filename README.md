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

### ChordChart:

Name | Purpose
 --- | --- 
getChordList() | returns the array of chords in ChordChart
getChordList(int index) | returns chordList starting from index
getTempo() | returns the tempo (as a string)
setChordList(ArrayList<Chordy> chordList) | setter for ChordList
setTempo(String tempo) | setter for Tempo
insertChord(Chordy chord) | adds a chord to the end of the chart
insertChord(int index, Chordy chord) | adds a chord to a particular place
toString() | returns a string properly formatted for JFugue to play
toString(int index) | returns the string starting at index
play() | plays the ChordChart!
play(int index) | plays the ChordChart starting at index
delChord(int index) | delete a chord from a particular place
getChord(int index) | return a particular chord
restChord(int index) | replace a particular chord with a rest

##### Things to consider
 - is `(int index)` a good way of setting up parameters?
   depends on how we set up the GUI. for example, if we did end up using time signatures,
   it would make sense to have `(int measure, int beat)`.
   Even if its harder to program, its ultimately easier to use when making the GUI.
   We don't need to change it now, but its something to think about before implementing GUI.
 - is it useful to have `play(int start, int end)`?  Also applies to `toString` and `getChordList`.
 - Should `tempo` be an `int`?  I feel like that will ultimately be easier to use.
   It means we need to do a little extra work in the `toString` method,
   but overall it will be easier to manipulate the tempo outside of the class.
   Helpful for using constructor, `get`/`set` `Tempo`, and potential methods like `incTempo`, `doubleTempo`.
 - How can we make the piano not clip out at the end of playing? Adding a rest doesn't work.
