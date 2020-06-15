package danielbatchford;

class Cfg {

    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;
    static final int DIVX = 10;
    static final int DIVY = 10;
    static final int DIVWIDTH = WIDTH / DIVX;
    static final int DIVHEIGHT = HEIGHT / DIVY;


    static final int FRAMERATE = 60;

    static final int[] WALKABLECOLOR = new int[]{234, 226, 183};
    static final int[] UNWALKABLECOLOR = new int[]{252, 191, 73};
    static final int[] STARTCOLOR = new int[]{0, 48, 73};
    static final int[] ENDCOLOR = new int[]{214, 40, 40};
}