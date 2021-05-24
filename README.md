# Overview
The MowItNow company decided to develop an automatic lawn mower, designed for rectangular areas.
The purpose of this project is to implement the mower movement process to cut grass of a given surface.
## Data Model 
###Mower
A mower is represented by its position, a direction and a list of instructions
1. The position of the mower is represented by a cartesian coordinates (x,y).
2. The direction of a mower is represented by a letter indicating the direction according to the 
    English cardinal notation (N,E,W,S) = (N: North, E : East, W : West, S : South)
3. The list of instructions id represented by string combination of 3 letter G,A,D indicating all the future moves of the mower
    each letter indicate a single instruction (G : left), (D : right), (A : move forward)

###Grass Surface
A grass Surface is always rectangular and represented by its surface delimiters.
1. Delimiters are represented by a cartesian coordinates (x,y)

##Entry point

###The application 

class entrypoint is ```src/main/scala/ApplicationRunner.scala```

## Usage

The application takes an input file path as argument.

When launched it extracts the file header, 
validate it as a grass surface data then it reads the rest of the file two lines by two lines. The initial mower position 
is extracted and validated from the first line, the instructions list to be affected to that mower is extracted and validated 
from the second line. 

Once all data is correctly extracted, the first thing to do is to process the mower movements in the grass according to its initial
position, direction and its instructions.

Constraint : the mower must not leave the grass surface during its movement process. Also, all mowers are processed sequentially.

The application stops when all mowers exiting in the file has been processed

The Application output : List of all the final positions and directions of all the existing mowers


# Knowledge base:
- build tools:
        sbt 
   