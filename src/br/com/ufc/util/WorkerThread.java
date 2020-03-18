package br.com.ufc.util;

public class WorkerThread extends Thread {
    private int line;
    private int column;
    private int [][] matrixB;
    private int [][] matrixA;
    private int [][] matrixResulting;

    public WorkerThread(int row, int column, int[][] matrixA,
                        int[][] matrixB, int[][] matrixResulting) {
        this.line = row;
        this.column = column;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixResulting = matrixResulting;
    }

    @Override
    public void run() {
        matrixResulting[line][column] = (matrixA[line][0] * matrixB[0][column])+ (matrixA[line][1] * matrixB[1][column]);
    }
}