import command.*;
import grid.Grid;
import rover.Rover;
import rover.Direction;
import rover.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            // === Step 1: Grid Setup ===
            System.out.print("Enter grid size (e.g., 10 10): ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            Grid grid = new Grid(width, height);

            System.out.print("Enter number of obstacles: ");
            int obstacleCount = scanner.nextInt();
            for (int i = 0; i < obstacleCount; i++) {
                System.out.print("Enter obstacle " + (i + 1) + " position (x y): ");
                int ox = scanner.nextInt();
                int oy = scanner.nextInt();
                grid.addObstacle(ox, oy);
            }

            // === Step 2: Rover Initialization ===
            System.out.print("Enter rover starting position (x y direction[N/S/E/W]): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String dirInput = scanner.next().toUpperCase();
            Direction direction = Direction.valueOf(dirInput.equals("N") ? "NORTH" :
                                                   dirInput.equals("S") ? "SOUTH" :
                                                   dirInput.equals("E") ? "EAST" :
                                                   "WEST");
            Rover rover = new Rover(new Position(startX, startY), direction, grid);

            // === Step 3: Commands Input ===
            System.out.print("Enter commands sequence (e.g., MMRMLM): ");
            String commandStr = scanner.next().toUpperCase();

            List<Command> commands = new ArrayList<>();
            for (char c : commandStr.toCharArray()) {
                switch (c) {
                    case 'M': commands.add(new MoveCommand(rover)); break;
                    case 'L': commands.add(new TurnLeftCommand(rover)); break;
                    case 'R': commands.add(new TurnRightCommand(rover)); break;
                    default: System.out.println("Ignoring invalid command: " + c);
                }
            }

            // === Step 4: Execute Commands ===
            for (Command cmd : commands) {
                cmd.execute();
            }

            // === Step 5: Status Report ===
            System.out.println(rover.getStatusReport());

        } catch (Exception e) {
            System.err.println("Simulation error: " + e.getMessage());
        }
    }
}
