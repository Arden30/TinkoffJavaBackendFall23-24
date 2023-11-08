package edu.project2.algorithms;

import edu.project2.logic.Solver;
import edu.project2.utils.Cell;
import edu.project2.utils.Coordinate;
import edu.project2.utils.Maze;
import java.util.ArrayList;
import java.util.List;

public class BFSMazeSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {

        Cell[][] grid = maze.grid();

        List<Coordinate> coordinates = new ArrayList<>();

        return coordinates;
    }
}
