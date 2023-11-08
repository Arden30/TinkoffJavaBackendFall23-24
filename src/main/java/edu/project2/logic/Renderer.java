package edu.project2.logic;

import edu.project2.utils.Coordinate;
import edu.project2.utils.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);
}
