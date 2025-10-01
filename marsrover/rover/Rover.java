package rover;

import grid.Grid;

public class Rover {
    private Position position;
    private Direction direction;
    private final Grid grid;

    public Rover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        Position newPos = position.copy();
        newPos.move(direction);

        if (grid.isAccessible(newPos.getX(), newPos.getY())) {
            this.position = newPos;
        } else {
            System.out.println("Obstacle or boundary detected. Rover stays at " + position);
        }
    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public void turnRight() {
        this.direction = direction.right();
    }

    public String getStatusReport() {
        return "Rover is at " + position + " facing " + direction +
                ". No critical obstacles detected.";
    }
}
