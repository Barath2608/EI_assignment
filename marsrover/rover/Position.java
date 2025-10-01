package rover;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Invalid coordinates");
        this.x = x;
        this.y = y;
    }

    public Position copy() {
        return new Position(x, y);
    }

    public void move(Direction direction) {
        this.x += direction.dx();
        this.y += direction.dy();
    }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
