package edu.project2.algorithms;

import edu.project2.logic.Generator;
import edu.project2.utils.Cell;
import edu.project2.utils.Maze;
import java.util.Random;

public class BinaryTreeMazeGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        Random randomizer = new Random();
        int row = 2 * height + 1;
        int col = width + 1;
        Cell[][] grid = new Cell[row][col];

        //заполняем все стенки лабиринта
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i % 2 == 0 && j != col - 1) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                } else if (i % 2 != 0) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }

        //произвольно убираем некоторые стенки
        for (int i = 1; i < row - 1; i += 2) {
            for (int j = 1; j < col; j++) {
                //убираем вертикальные стенки в первой строке (образуется пустой коридор)
                if (i == 1) {
                    if (j != col - 1) {
                        grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                    }
                } else if (j == col - 1) {
                    //убираем верхнюю стенку в последней ячейке
                    //(для образования вертикального коридора в последней колонке)
                    grid[i - 1][j - 1] = new Cell(i - 1, j - 1, Cell.Type.PASSAGE);
                } else if (randomizer.nextBoolean()) {
                    //убираем горизонтальную стенку со случайной вероятностью и при этом оставляем вертикальную
                    grid[i - 1][j - 1] = new Cell(i - 1, j - 1, Cell.Type.PASSAGE);
                } else {
                    //убираем вертикальную стенку со случайной вероятностью и при этом оставляем горизонтальную
                    grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                }
            }
        }

        return new Maze(height, width, grid);
    }
}
