package Algorithms;


public class CountPathInMatrix {
  // count the number of paths from top left to bottom right - 27
  // we can only move right or bottom

  // every path can be subdivided : to right and to bottom :
  //
  //	so paths(a,z) = paths(a right ,z) + paths(a bottom ,z)
  //	paths(a right,z) = paths (a right-right, z) + paths(a right-bottom, z	public static void main(String[] args) {

  // if a path taken leads to z at last, return a 1 else return 0

  static int[][] matrix = {
      {1, 0, 0, 0},
      {1, 1, 1, 1},
      {0, 0, 1, 1},
      {0, 1, 0, 1}
  };


  private static int countPath(int[][] matrix, int row, int col) {

    //boundary checks
    if (col > matrix.length - 1 || row > matrix.length - 1 || matrix[row][col] == 0) {
      return 0;
    }
    // i have reached to the last path , return 1 to my calling countPath
    if (row == matrix.length - 1 && col == matrix[matrix.length - 1].length - 1) {
      return 1;
    }

    // we can move from one index to final destination in right or bottom
    int paths = countPath(matrix, row + 1, col) + countPath(matrix, row, col + 1);
    return paths;
  }

  private static boolean checkPathInMaze(int[][] maze, int[][] matrix, int row, int col) {
    //boundary checks
    if (col > matrix.length - 1 || row > matrix.length - 1 || matrix[row][col] == 0) {
      return false;
    }
    // i have reached to the last path , return 1 to my calling countPath
    if (row == matrix.length - 1 && col == matrix[matrix.length - 1].length - 1) {
      maze[row][col] = 1;
      return true;
    }

    // we can move from one index to final destination in right or bottom
    boolean isPathBottom = checkPathInMaze(maze, matrix, row + 1, col);
    boolean isPathRight = checkPathInMaze(maze, matrix, row, col + 1);
    if (isPathBottom || isPathRight) {
      maze[row][col] = 1;
    }

    return isPathBottom || isPathRight;
  }


  public static void main(String[] args) {

    //1. count paths form start left to bottm right
    System.out.println(countPath(matrix, 0, 0));

    //2. rat in a maze problem
    int[][] maze = {
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}
    };
    System.out.println(checkPathInMaze(maze, matrix, 0, 0));
    ;
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze.length; j++) {
        System.out.print(maze[i][j] + " ");
      }
      System.out.println();
    }

  }


}
