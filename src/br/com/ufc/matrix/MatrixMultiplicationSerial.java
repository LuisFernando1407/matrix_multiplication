package br.com.ufc.matrix;

import br.com.ufc.util.Util;

public class MatrixMultiplicationSerial {
    private int lineA;
    private int columnA;

    private int lineB;
    private int columnB;

    private int factorMatrixA;
    private int factorMatrixB;
    private int[][] matrixResulting;

    private int[][] matrixA;
    private int[][] matrixB;

    public MatrixMultiplicationSerial(int... linesAndColumns){
        this.lineA = linesAndColumns[0];
        this.columnA = linesAndColumns[1];
        this.lineB = linesAndColumns[2];
        this.columnB = linesAndColumns[3];

        this.matrixResulting = new int[lineA][columnB];
    }

    public void setFactorMatrixA(int factorMatrixA){
        this.factorMatrixA = factorMatrixA;
    }

    public void setFactorMatrixB(int factorMatrixB){
        this.factorMatrixB = factorMatrixB;
    }

    public void execute(){

        matrixA = Util.generateRandomMatrix(factorMatrixA != 0 ? factorMatrixA : 100, lineA, columnA);
        matrixB = Util.generateRandomMatrix(factorMatrixB != 0 ? factorMatrixB : 200, lineB, columnB);

        for (int i = 0; i < lineA; i++){
            for (int j = 0; j < columnB; j++){
                for(int k = 0; k < columnA; k++){
                    matrixResulting[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
    }

    public void print(){
        System.out.println(" ===== SERIAL - Elements of Matrix A  =====");
        Util.printMatrix(lineA, columnA, matrixA);

        System.out.println(" ===== SERIAL - Elements of Matrix B  =====");
        Util.printMatrix(lineB, columnB, matrixB);

        System.out.println(" ===== SERIAL - Elements of Matrix Resulting (A X B)  =====");
        Util.printMatrix(lineA, columnB, matrixResulting);
    }
}