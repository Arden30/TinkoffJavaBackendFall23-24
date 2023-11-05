package edu.project2.logic;

import edu.project2.algorithms.BinaryTreeMazeGenerator;
import edu.project2.utils.Cell;
import edu.project2.utils.Coordinate;
import edu.project2.utils.Maze;
import java.util.List;

public class PrettyPrinter implements Renderer {
    private static final int HEIGHT = 10;
    private static final int WIDTH = 10;

    @Override
    public String render(Maze maze) {
        int row = 2 * maze.height() + 1;
        int col = maze.width() + 1;
        Cell[][] grid = maze.grid();
        StringBuilder res = new StringBuilder();

        //для того чтобы вывод выглядел ещё лучше, нужно уменьшить шрифт символов, выводимых в консоль
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != null) {
                    if (i % 2 == 0 && grid[i][j].type() == Cell.Type.WALL) {
                        res.append(" ——");
                    } else if (grid[i][j].type() == Cell.Type.WALL && i % 2 != 0) {
                        if (j == 0) {
                            res.append("| ");
                        } else if (j == col - 1) {
                            res.append(" |");
                        } else {
                            res.append(" | ");
                        }
                    } else {
                        res.append("   ");
                    }
                }
            }
            res.append('\n');
        }
        return res.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        return null;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void print() {
        BinaryTreeMazeGenerator binaryTreeMazeGenerator = new BinaryTreeMazeGenerator();
        Maze maze = binaryTreeMazeGenerator.generate(HEIGHT, WIDTH);
        String mazePrint = render(maze);
        System.out.println(mazePrint + '\n');
    }
}
