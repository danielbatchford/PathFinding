package danielbatchford;

import processing.core.PApplet;

import java.util.Arrays;
import java.util.Random;

public class Controller {

    private final PApplet p;
    private final Box[][] grid;
    private Box start;
    private Box end;

    private Random random;

    Controller(PApplet p) {
        this.p = p;
        grid = new Box[Cfg.WIDTH][Cfg.HEIGHT];

        for (int x = 0, maxX = Cfg.DIVX; x < maxX; x++) {
            for (int y = 0, maxY = Cfg.DIVY; y < maxY; y++) {
                grid[x][y] = new Box(new int[]{x, y}, true);
            }
        }

        random = new Random();

        start = grid[random.nextInt(Cfg.DIVX)][random.nextInt(Cfg.DIVY)];
        end = grid[random.nextInt(Cfg.DIVX)][random.nextInt(Cfg.DIVY)];
        while(start.equals(end)){
            end = grid[random.nextInt(Cfg.DIVX)][random.nextInt(Cfg.DIVY)];
        }

        start.setStart(true);
        end.setEnd(true);
    }

    void inputHandler(){
        if (p.mousePressed) {
            Box box = grid[p.mouseX / Cfg.DIVWIDTH][p.mouseY / Cfg.DIVHEIGHT];

                box.setWalkable(p.mouseButton == p.RIGHT);
        }
    }


    void update() {

    }


    void draw() {
        for (int x = 0, maxX = Cfg.DIVX; x < maxX; x++) {
            for (int y = 0, maxY = Cfg.DIVY; y < maxY; y++) {
                Box b = grid[x][y];
                b.draw(p);
            }
        }
    }

    Box getBox(int[] cord) {
        return grid[cord[0]][cord[1]];
    }

}
