# A Simple 2d Grid Pathfinding Library For Java

This is a lightweight java pathfinding library, applicable to 2d grids.
## Current Implementations:
Currently, the following pathfinding methods are implemented:
* A* Search
* Djikstra's Algorithm
* Depth First Search
* Breadth First Search
## Installation
To install, add `src\danielbatchford\pathfinding` to your build path.
## Getting Started
Begin by creating a Grid:  
`Grid myGrid = new Grid(new int[]{x,y})` where x and y represent the grid width and height respectively.  

By default, all squares on the grid will be assumed walkable. To set a square as unwalkable, use:  
`myGrid.setWalkable(int[] cordinates, false)`   

To set a square as walkable, use:  
`myGrid.setWalkable(int[] cordinates, false)`  

Next, create a finder:  
`PathFinder myFinder = new AStarSearch();`  

Create an options object:  
`Options myOptions = new Options(arg1, arg2, arg3)` where `arg1` is the distance metric used, `arg2` is whether to allow diagonal movement (boolean) and `arg3` is whether to attach a [State Logger](#state-logging) (boolean).

Current distance metric implementations:
* `m` : Manhattan Distance
* `e` : Euclidian Distance

Finally, find a path:  
`List<int[]> myPath = myFinder.findPath(start, end, myGrid, myOptions`.  
Note that `start` and `end` are 2d integer arrays representing co-ordinates of the form (x,y).  

Use `grid.toConsole()` to preview a string of the current grid and `grid.toconsole(myPath)` to preview the grid and path. Here, `·` represents a walkable square, `■` represents an unwalkable square and `O` represents a square on a path. 

### Sample console output
`System.out.println(myGrid.toConsole(myPath))` gives an output such as the one below:

![SampleImage](sample.png?raw=true "Title")

## Setting your own Heuristic
To set your own A* heuristic, modify `danielbatchford.pathfinding.heuristics.AStarHeuristic.calculate()`. `from` represents the square to calculate from and `to` represents the goal square. Both of these are integer arrays representing 2d co-ordinates.

## State Logging
This library allows search states to be logged, to allow support for GUI visualisations. A `State` object holds a specific open set and closed set state, for each step of a pathfinding search. This is stored in a `StateLogger` class. Using `myFinder.getStateLogger()` returns a `StateLogger` object. Contents can be accessed using `myStateLogger.getStates()`, which returns a list of `State` objects.

The open list at a state can then be accessed using `myState.getVisited()`.  
The closed list at a state can be accessed using `myState.getQueue()`.

A `toString()` overidden method is also included in the `StateLogger` class.

## Contributing
Feel free to open a pull request and submit improvements and bugfixes to this code. Please follow the style guide included. (`style.editorconfig`)

