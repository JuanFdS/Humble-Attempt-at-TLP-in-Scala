package tlp.booleans

object Boolean {

  trait Boolean {
    type If[TrueVal <: UpperBound, FalseVal <: UpperBound, UpperBound] <: UpperBound
    type Not <: Boolean
  }
  
  trait True extends Boolean {
    type If[TrueVal <: UpperBound, FalseVal <: UpperBound, UpperBound] = TrueVal
    type Not = False
  }
  
  trait False extends Boolean {
    type If[TrueVal <: UpperBound, FalseVal <: UpperBound, UpperBound] = FalseVal
    type Not = True
  }

}