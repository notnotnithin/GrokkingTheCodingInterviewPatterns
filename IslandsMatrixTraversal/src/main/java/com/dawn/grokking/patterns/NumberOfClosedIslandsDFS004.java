package com.dawn.grokking.patterns;

public class NumberOfClosedIslandsDFS004 {

  public static void main(String[] args) {
    System.out.println(
        "The given matrix has "
            + NumberOfClosedIslandsDFS004.countClosedIslands(
                new int[][] {
                  {1, 1, 0, 0, 0},
                  {0, 1, 0, 0, 0},
                  {0, 0, 1, 1, 0},
                  {0, 1, 1, 0, 0},
                  {0, 0, 0, 0, 0}
                })
            + " island(s) and closed islands.");

    System.out.println(
        "The given matrix has "
            + NumberOfClosedIslandsDFS004.countClosedIslands(
                new int[][] {
                  {0, 0, 0, 0},
                  {0, 1, 0, 0},
                  {0, 1, 0, 0},
                  {0, 0, 1, 0},
                  {0, 0, 0, 0}
                })
            + " island(s) and closed islands.");
  }

  public static int countClosedIslands(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int closedIslandsCount = 0;
    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1 && !visited[i][j]) {
          if (isClosedIslandDFS(matrix, i, j, visited)) {
            closedIslandsCount++;
          }
        }
      }
    }
    return closedIslandsCount;
  }

  private static boolean isClosedIslandDFS(int[][] matrix, int x, int y, boolean[][] visited) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
      return false;
    }
    if (matrix[x][y] == 0 || visited[x][y]) {
      return true;
    }

    visited[x][y] = true; // mark the cell visited

    boolean isClosed;

    isClosed = isClosedIslandDFS(matrix, x + 1, y, visited);
    isClosed &= isClosedIslandDFS(matrix, x - 1, y, visited);
    isClosed &= isClosedIslandDFS(matrix, x, y + 1, visited);
    isClosed &= isClosedIslandDFS(matrix, x, y - 1, visited);

    return isClosed;
  }
}
