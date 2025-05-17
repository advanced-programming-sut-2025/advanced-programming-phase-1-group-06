package models.Player;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;

import java.util.*;

public class AStar {
    // Directions (N, NE, E, SE, S, SW, W, NW)
    private static final int[][] DIRECTIONS = {
            {0, 1},   // N  - 0
            {1, 1},   // NE - 1
            {1, 0},   // E  - 2
            {1, -1},  // SE - 3
            {0, -1},  // S  - 4
            {-1, -1}, // SW - 5
            {-1, 0},  // W  - 6
            {-1, 1}   // NW - 7
    };

    private static final double DIAGONAL_COST = Math.sqrt(2);
    private static final double STRAIGHT_COST = 1.0;
    private static final double TURN_COST = STRAIGHT_COST * 10.0;

    private static class Node implements Comparable<Node> {
        int x, y;
        double g; // Cost from start to this node
        double h; // Heuristic estimate to goal
        Node parent;
        int direction; // Direction we came from (0-7)

        Node(int x, int y, double g, double h, Node parent, int direction) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.parent = parent;
            this.direction = direction;
        }

        double f() {
            return g + h;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.f(), other.f());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node node)) return false;
            return x == node.x && y == node.y && direction == node.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }
    }

    /**
     * Find path from start to goal using A* algorithm
     *
     * @param grid   2D grid where 1 is passable and 0 is obstacle
     * @param startX starting X coordinate
     * @param startY starting Y coordinate
     * @param goalX  goal X coordinate
     * @param goalY  goal Y coordinate
     * @return List of coordinates representing the path, or empty list if no path exists
     */
    public static ArrayList<Coordinates> findPath(GameMap grid, int startX, int startY, int goalX, int goalY) {
        if (grid == null || grid.getLength() == 0 || grid.getWidth() == 0) {
            System.out.println("Debug: Grid is invalid");
            return new ArrayList<>();
        }

        int rows = grid.getLength();
        int cols = grid.getWidth();

        // Validate input coordinates
        if (!isValid(startX, startY, rows, cols) || !isValid(goalX, goalY, rows, cols)) {
            System.out.println("Debug: Invalid coordinates - Start(" + startX + "," + startY +
                             ") Goal(" + goalX + "," + goalY + ")");
            return new ArrayList<>();
        }

        if (grid.isBlocked(startX, startY) || grid.isBlocked(goalX, goalY)) {
            System.out.println("Debug: Start or goal position is blocked");
            return new ArrayList<>();
        }

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        // Change: Use a HashSet that only considers x and y for visited nodes
        Set<String> closedSet = new HashSet<>();

        Node startNode = new Node(startX, startY, 0,
            calculateHeuristic(startX, startY, goalX, goalY, -1), null, -1);
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            String currentPos = current.x + "," + current.y;

            if (current.x == goalX && current.y == goalY) {
                return reconstructPath(current);
            }

            // Change: Only add position to closed set if we haven't processed this position yet
            if (closedSet.contains(currentPos)) {
                continue;
            }
            closedSet.add(currentPos);

            // Try all 8 directions
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int newX = current.x + DIRECTIONS[i][0];
                int newY = current.y + DIRECTIONS[i][1];

                if (!isValid(newX, newY, rows, cols) || grid.isBlocked(newX, newY)) {
                    continue;
                }

                String newPos = newX + "," + newY;
                if (closedSet.contains(newPos)) {
                    continue;
                }

                double turnPenalty = 0;
                if (current.direction != -1 && current.direction != i) {
                    turnPenalty = TURN_COST;
                }

                // Change: Adjust movement costs
                double movementCost = (i % 2 == 0) ? STRAIGHT_COST : DIAGONAL_COST;
                // Reduce the impact of turn penalty
                turnPenalty *= 0.5;
                double newG = current.g + movementCost + turnPenalty;

                Node neighbor = new Node(newX, newY, newG,
                    calculateHeuristic(newX, newY, goalX, goalY, i),
                    current, i);

                // Change: Simplified neighbor handling
                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else {
                    // Update the existing neighbor if this path is better
                    for (Node existingNode : openSet) {
                        if (existingNode.equals(neighbor) && existingNode.g > newG) {
                            openSet.remove(existingNode);
                            openSet.add(neighbor);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Debug: No path found after exploring " + closedSet.size() + " nodes");
        return new ArrayList<>();
    }

    // Modify the calculateHeuristic method to be more permissive
    private static double calculateHeuristic(int startX, int startY, int goalX, int goalY, int currentDirection) {
        int dx = Math.abs(goalX - startX);
        int dy = Math.abs(goalY - startY);

        // Use octile distance for more accurate heuristic
        double baseCost = Math.max(dx, dy) + (DIAGONAL_COST - 1) * Math.min(dx, dy);

        if (currentDirection == -1) {
            return baseCost;
        }

        // Reduce the impact of turn penalties in the heuristic
        double angleToGoal = Math.atan2(goalY - startY, goalX - startX);
        int idealDirection = (int) Math.round(4 * angleToGoal / Math.PI) & 7;

        int directionDiff = Math.abs(currentDirection - idealDirection);
        int minTurns = Math.min(directionDiff, 8 - directionDiff);

        // Reduce the turn penalty in the heuristic
        return baseCost + (minTurns * TURN_COST * 0.1);
    }

    // Keep the existing reconstructPath method


    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

//    private static double calculateHeuristic(int startX, int startY, int goalX, int goalY, int currentDirection) {
//        int dx = Math.abs(goalX - startX);
//        int dy = Math.abs(goalY - startY);
//
//        // Base movement cost
//        double baseCost = Math.min(dx, dy) * DIAGONAL_COST + Math.abs(dx - dy) * STRAIGHT_COST;
//
//        // If we don't have a current direction, return just the base cost
//        if (currentDirection == -1) {
//            return baseCost;
//        }
//
//        // Calculate ideal direction to goal
//        double angleToGoal = Math.atan2(goalY - startY, goalX - startX);
//        int idealDirection = (int) Math.round(4 * angleToGoal / Math.PI) & 7;
//
//        // Calculate minimum turns needed
//        int directionDiff = Math.abs(currentDirection - idealDirection);
//        int minTurns = Math.min(directionDiff, 8 - directionDiff);
//
//        return baseCost + (minTurns * TURN_COST);
//    }

    private static ArrayList<Coordinates> reconstructPath(Node node) {
        ArrayList<Coordinates> path = new ArrayList<>();
        while (node != null) {
            path.add(0, new Coordinates(node.x, node.y));
            node = node.parent;
        }
        return path;
    }

    public static ArrayList<Double> calculateEachMoveCost(ArrayList<Coordinates> path) {
        if (path.isEmpty()) {
            return new ArrayList<>();
        }

        int currentX = path.getFirst().x();
        int currentY = path.getFirst().y();
        int dx = 0;
        int dy = 0;
        ArrayList<Double> moveCost = new ArrayList<>();

        // Don't add initial cost for starting position
        moveCost.add(0.0);  // First position costs nothing
        moveCost.add(0.0);
        for (int i = 1; i < path.size(); i++) {  // Start from index 1
            Coordinates c = path.get(i);
            int nextX = c.x();
            int nextY = c.y();

            if (nextX == currentX && nextY == currentY) {
                moveCost.add(0.0);  // Same position
            }
            else if (dx == nextX - currentX && dy == nextY - currentY) {
                moveCost.add(5.0);  // Continuing same direction
            }
            else if ((dx == nextX - currentX && dy != nextY - currentY) ||
                    (dx != nextX - currentX && dy == nextY)) {
                moveCost.add(7.0);  // 90-degree turn
            }
            else if (dx != nextX - currentX && dy != nextY - currentY) {
                moveCost.add(10.0);  // 180-degree turn
            }

            dx = nextX - currentX;
            dy = nextY - currentY;
            currentX = nextX;
            currentY = nextY;
        }
        return moveCost;
    }
}