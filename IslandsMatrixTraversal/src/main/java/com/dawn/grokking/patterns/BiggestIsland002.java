package com.dawn.grokking.patterns;

public class BiggestIsland002 {

  public static void main(String[] args) {
    System.out.println(
        "The biggest island has "
            + BiggestIsland002.maxAreaOfIsland(
                new int[][] {
                  {1, 1, 1, 0, 0},
                  {0, 1, 0, 0, 1},
                  {0, 0, 1, 1, 0},
                  {0, 1, 1, 0, 0},
                  {0, 0, 1, 0, 0}
                })
            + " cells");
  }

  public static int maxAreaOfIsland(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int biggestIslandArea = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          biggestIslandArea = Math.max(biggestIslandArea, visitedIslandDFS(matrix, i, j));
        }
      }
    }
    return biggestIslandArea;
  }

  private static int visitedIslandDFS(int[][] matrix, int x, int y) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
      return 0;
    }
    if (matrix[x][y] == 0) {
      return 0;
    }

    matrix[x][y] = 0;

    int area = 1;

    area += visitedIslandDFS(matrix, x + 1, y);
    area += visitedIslandDFS(matrix, x - 1, y);
    area += visitedIslandDFS(matrix, x, y + 1);
    area += visitedIslandDFS(matrix, x, y - 1);

    return area;
  }
}
