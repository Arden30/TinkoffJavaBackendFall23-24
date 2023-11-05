package edu.project2.logic;

import edu.project2.utils.Coordinate;
import edu.project2.utils.Maze;
import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
