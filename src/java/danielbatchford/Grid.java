package java.danielbatchford;

import processing.core.PApplet;

public class Grid{

    private PApplet p;
    private Box[][] grid;

    Grid(PApplet p){
        this.p = p;
        grid = new Box[Cfg.WIDTH][Cfg.HEIGHT];
    }

    Box getBox(int[] cord){
        return grid[cord[0]][cord[1]];
    }

    void setWalkable(int[] cord,boolean walkable){
        grid[cord[0]][cord[1]].setWalkable(walkable);
    }

    void draw(){
        for(int x = 0, maxX = Cfg.WIDTH; x < maxX; x++){
            for(int y = 0, maxY = Cfg.HEIGHT; y < maxY; y++){
                Box b = grid[x][y];
                b.draw(p,(b.isWalkable()) ? Cfg.WalkableColor: Cfg.UnwalkableColor);
            }
        }
    }
}
