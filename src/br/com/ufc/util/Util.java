package br.com.ufc.util;

public class Util {
    public static int[][] generateRandomMatrix(int factor, int line, int column){
        int[][] matrix = new int[line][column];

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (int) (Math.random() * factor);
            }
        }

        return matrix;
    }

    public static void printMatrix(int line, int column, int[][] matrix){
        for (int i = 0; i < line; i++){
            for (int j = 0; j < column; j++){
                System.out.println("["+i+","+j+"] = " + matrix[i][j]);
            }
        }
    }
}