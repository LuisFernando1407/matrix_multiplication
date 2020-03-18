package br.com.ufc.matrix;


import br.com.ufc.util.Util;
import br.com.ufc.util.WorkerThread;

public class MatrixMultiplicationParallel {

    private int lineA;
    private int columnA;

    private int lineB;
    private int columnB;

    private int factorMatrixA;
    private int factorMatrixB;
    private WorkerThread[][] threads;
    private int[][] matrixResulting;

    private int[][] matrixA;
    private int[][] matrixB;

    public MatrixMultiplicationParallel(int... linesAndColumns){
        this.lineA = linesAndColumns[0];
        this.columnA = linesAndColumns[1];
        this.lineB = linesAndColumns[2];
        this.columnB = linesAndColumns[3];

        this.threads = new WorkerThread[lineA][columnB];
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

        /* creates (lineA * columnB) Worker threads. Each thread Calculates a Matrix Value and sets it to matrixResulting */
        for (int i = 0; i < lineA; i++){
            for (int j = 0; j < columnB; j++){
                threads[i][j] = new WorkerThread(i, j, matrixA, matrixB, matrixResulting);
                threads[i][j].start();
            }
        }
    }

    public void print(){
        System.out.println(" ===== Parallel - Elements of Matrix A  =====");
        Util.printMatrix(lineA, columnA, matrixA);

        System.out.println(" ===== Parallel - Elements of Matrix B  =====");
        Util.printMatrix(lineB, columnB, matrixB);

        System.out.println(" ===== Parallel - Elements of Matrix Resulting (A X B)  =====");
        Util.printMatrix(lineA, columnB, matrixResulting);
    }
}