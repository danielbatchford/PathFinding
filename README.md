# A Simple 2d Grid Pathfinding Library For Java
## About
This is a lightweight java pathfinding library, applicable to 2d grids.
## Current Implementations:
Currently, the following pathfinding methods are implemented:
* A* Search
## Installation
To install, add `src\danielbatchford\pathfinding` to your build path.
## How to Use
Begin by creating a Grid:  
`Grid myGrid = new Grid(new int[]{x,y})` where x and y represent the grid width and height respectively.  

By default, all squares on the grid will be assumed walkable. To set a square as unwalkable, use:  
`myGrid.setWalkable(int[] cordinates, false)`.  

To set a square as walkable, use:  
`myGrid.setWalkable(int[] cordinates, false)`. 

Next, create a finder:  
`PathFinder myFinder = new AStar();`  

Create an options object:  
`Options myOptions = new Options('argument1', true/false)` where argument1 is the distance metric used and argument 2 is whether to allow diagonal movement.

Current distance metric implementations:
* 'm' : Manhattan Distance.
* 'e' : Euclidian Distance.

If no options are specified then defaults `('m', false)` are used.  

Next, find a path:  
`List<int[]> myPath = myFinder.findPath(int[] start, int[] end, myGrid, myOptions`.  

Use `grid.toConsole()` to preview a string of the current grid and `grid.toconsole(myPath)` to preview the grid and path. Here, `-` represents a walkable square, `X` represents an unwalkable square and `O` represents a square on a path. 

### Sample console output
`System.out.println(myGrid.toConsole(myPath))` gives an output such as the one below:


## Setting your own Heuristic
To set your own A* heuristic, modify the `calculate()` method in `danielbatchford.pathfinding.AStarHeuristic`. `from` represents the square to calculate from and `to` represents the goal square.

