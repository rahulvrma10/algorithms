package Algorithms;

public class RotateMatrix {


  static int[][] matrix = {
      {1, 2, 3, 4},
      {12, 1, 2, 5},
      {11, 4, 3, 6},
      {10, 9, 8, 7}
  };

  public static void main(String[] args) {

    //rotate the matrix 90 degree clockwise

    int[][] matrixRotate = new int[matrix.length][matrix.length];

    // 00 -> 03
    // 01 -> 13
    // 02 -> 23
    // 03 -> 33

    // 03 -> 33
    // 13 -> 32
    // 23 -> 31
    // 33 -> 30
    //

    int colRotate = matrix.length - 1;
    for (int row = 0; row < matrix.length; row++) {

      for (int col = 0; col < matrix.length; col++) {
        matrixRotate[col][colRotate] = matrix[row][col];
      }
      colRotate--;
    }

    for (int i = 0; i < matrixRotate.length; i++) {
      for (int j = 0; j < matrixRotate.length; j++) {
        System.out.print(matrixRotate[i][j] + " ");
      }
      System.out.println();
    }
  }

}
