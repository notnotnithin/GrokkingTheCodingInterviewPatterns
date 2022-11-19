package com.dawn.grokking.patterns;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsVisited001 {

  public static void main(String[] args) {
    System.out.println(
        "Number of connected islands are (using BFS): "
            + NumberOfIslandsVisited001.countIslands(
                new int[][] {
                  {0, 1, 1, 1, 0},
                  {0, 0, 0, 1, 1},
                  {0, 1, 1, 1, 0},
                  {0, 1, 1, 0, 0},
                  {0, 0, 0, 0, 0}
                }));

    System.out.println(
        "Number of connected islands are (using BFS): "
            + NumberOfIslandsVisited001.countIslands(
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
    boolean[][] visited = new boolean[rows][cols];
    int totalIslands = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (!visited[i][j] && matrix[i][j] == 1) {
          totalIslands++;
          visitIslandBFS(matrix, visited, i, j);
        }
      }
    }
    return totalIslands;
  }

  private static void visitIslandBFS(int[][] matrix, boolean[][] visited, int x, int y) {
    Queue<int[]> neighbors = new LinkedList<>();
    neighbors.add(new int[] {x, y});
    while (!neighbors.isEmpty()) {
      int row = neighbors.peek()[0];
      int col = neighbors.peek()[1];
      neighbors.remove(); // remove the entry from the array after saving it

      if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) continue;
      if (matrix[row][col] == 0 || visited[row][col]) continue;

      visited[row][col] = true; // mark the visited array as true

      neighbors.add(new int[] {row + 1, col});
      neighbors.add(new int[] {row - 1, col});
      neighbors.add(new int[] {row, col + 1});
      neighbors.add(new int[] {row, col - 1});
    }
  }
}
