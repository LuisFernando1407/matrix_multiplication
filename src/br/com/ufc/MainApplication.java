package br.com.ufc;

import br.com.ufc.matrix.MatrixMultiplicationParallel;
import br.com.ufc.matrix.MatrixMultiplicationSerial;

import java.time.Duration;
import java.time.Instant;

public class MainApplication {

    public static void main(String[] args) {

        /* Example of multiplication m.Parallel */
        //Order of line and column = A(2, 2) ... B(2, 2)
        MatrixMultiplicationParallel matrixMultiplicationParallel = new MatrixMultiplicationParallel(2, 2, 3, 4);

        /* ---- Calculation factor of matrix elements ---- */
        matrixMultiplicationParallel.setFactorMatrixA(10);
        matrixMultiplicationParallel.setFactorMatrixB(20);

        /* --- Execute multiplication m.A X m.B --- */
        Instant startMP = Instant.now();
            matrixMultiplicationParallel.execute();
        Instant finishMP = Instant.now();

        /* --- Print m.A, m.B, m.Resulting --- */
        //matrixMultiplicationParallel.print();

        /* --- Time of execution Parallel --- */
        System.out.println("Parallel - Time to perform multiplication: " + Duration.between(startMP, finishMP).toMillis() + " ms");


        /* Example of multiplication m.Serial */
        MatrixMultiplicationSerial matrixMultiplicationSerial = new MatrixMultiplicationSerial(2, 2, 3, 4);
        /* ---- Calculation factor of matrix elements ---- */
        matrixMultiplicationSerial.setFactorMatrixA(10);
        matrixMultiplicationSerial.setFactorMatrixB(20);

        /* --- Execute multiplication m.A X m.B --- */
        long startMS = System.currentTimeMillis();
            matrixMultiplicationSerial.execute();
        long finishMS = System.currentTimeMillis();

        /* --- Print m.A, m.B, m.Resulting --- */
        //matrixMultiplicationSerial.print();

        /* --- Time of execution Serial --- */
        System.out.println("Serial - Time to perform multiplication: " + (finishMS - startMS) + " ms");
    }
}