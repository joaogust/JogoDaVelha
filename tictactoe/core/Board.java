package core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class Board {

    public static final int SIZE = 3;

    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];

    public Board() {
        for (Symbol[] symbols : matrix) {
            Arrays.fill(symbols, Symbol.NONE);
        }
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pw.print(matrix[i][j]);
                if(j < SIZE - 1) {
                    pw.print(" | ");
                }
            }
            if (i < SIZE -1) {
                pw.println("\n---------");
            }
        }
        return sw.toString();
    }
}
