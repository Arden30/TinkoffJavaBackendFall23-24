package edu.project2.logic;

import edu.project2.utils.Maze;

public interface Generator {
    Maze generate(int height, int width);
}
