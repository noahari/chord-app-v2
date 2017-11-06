# chord-app-v2

### Chordy:

Name | Purpose
:---:|:---:
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
:---:|:---:
getChordList() | returns the array of chords in ChordChart
getTempo() | returns the tempo (as a string)
setChordList(ArrayList<Chordy> chordList) | setter for ChordList
setTempo(String tempo) | setter for Tempo
insertChord(Chordy chord) | adds a chord to the end of the chart
insertChord(int index, Chordy chord) | adds a chord to a particular place
toString() | returns a string properly formatted for JFugue to play
play() | plays the ChordChart!
delChord(int index) | delete a chord from a particular place
getChord(int index) | return a particular chord
restChord(int index) | replace a particular chord with a rest
*todo: playAt* | *begin playing ChordChart from a particular place*

###### Aidan:
  Hmmm... what is the best way to give these *todo* methods parameters?
  They all require a particular place in the array.
  On one hand, we could just give an index for the array (simplest to program).
  However, in the long run it might be easier to use a different system.
  Might depend on how the GUI is implemented.
 
 Also, for playAt, might be a good idea to have methods that work for it.
 Because design patterns / refactoring / whatever.
 toStringAt, and/or getChordListAt.
 Could potentially be useful for it to take 2 indexes, beginning and end.
