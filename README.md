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
setDuration(String duration)* | setter for Duration

### ChordChart:

Name | Purpose
:---:|:---:
getChordList() | returns the array of chords in ChordChart
getTempo() | returns the tempo (as a string)
insertChord(Chordy chord) | adds a chord to the end of the chart
toString() | returns a string properly formatted for JFugue to play
play() | plays the ChordChart!
*todo: ???* | *insert a chord in a particular place*
*todo: delChord* | *delete a chord from a particular place*
*todo: getChord* | *return a particular chord*
*todo: restChord* | *replace a particular chord with a rest (use Chordy.toRest() and getChord)*
*todo: setChordList()* | *setter for ChordList*
*todo: setTempo()* | *setter for Tempo*

Aidan:
  Hmmm... what is the best way to give these *todo* methods parameters?
  They all require a particular place in the array.
  On one hand, we could just give an index for the array (simplest to program).
  However, in the long run it might be easier to use a different system.
  Might depend on how the GUI is implemented.
