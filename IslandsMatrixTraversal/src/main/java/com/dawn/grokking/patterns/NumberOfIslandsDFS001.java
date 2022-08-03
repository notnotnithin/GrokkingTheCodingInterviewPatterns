package com.dawn.grokking.patterns;

public class NumberOfIslandsDFS001 {

  public static void main(String[] args) {
    System.out.println(
        "Number of connected islands are: "
            + NumberOfIslandsDFS001.countIslands(
                new int[][] {
                  {0, 1, 1, 1, 0},
                  {0, 0, 0, 1, 1},
                  {0, 1, 1, 1, 0},
                  {0, 1, 1, 0, 0},
                  {0, 0, 0, 0, 0}
                }));

    System.out.println(
        "Number of connected islands are: "
            + NumberOfIslandsDFS001.countIslands(
                new int[][] {
                  {1, 1, 1, 0, 0},
                  {0, 1, 0, 0, 1},
                  {0, 0, 1, 1, 0},
                  {0, 0, 1, 0, 0},
                  {0, 0, 1, 0, 0}
                }));
  }

  public static int countIslands(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int totalIslands = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          totalIslands++;
          visitIslandDFS(matrix, i, j);
        }
      }
    }
    return totalIslands;
  }

  private static void visitIslandDFS(int[][] matrix, int x, int y) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
      return;
    }
    if (matrix[x][y] == 0) {
      return;
    }

    // mark all the cells as visited
    matrix[x][y] = 0;

    visitIslandDFS(matrix, x + 1, y); // lower cell (vertical - on the x-axis)
    visitIslandDFS(matrix, x - 1, y); // upper cell (vertical - on the x-axis)
    visitIslandDFS(matrix, x, y + 1); // right cell (horizontal - on the y-axis)
    visitIslandDFS(matrix, x, y - 1); // left cell (horizontal - on the y-axis)
  }
}
