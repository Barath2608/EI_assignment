package grid;

public class Grid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        initialize();
    }

    private void initialize() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cells[y][x] = new EmptyCell();
            }
        }
    }

    public void addObstacle(int x, int y) {
        if (isInsideGrid(x, y)) {
            cells[y][x] = new ObstacleCell();
        }
    }

    public boolean isAccessible(int x, int y) {
        return isInsideGrid(x, y) && cells[y][x].isAccessible();
    }

    private boolean isInsideGrid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
