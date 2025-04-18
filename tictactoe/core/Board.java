package core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import static java.util.Objects.requireNonNull;

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

        pw.println("  | 1 | 2 | 3");
        pw.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            pw.print(i + 1 + " | ");
            for (int j = 0; j < SIZE; j++) {
                pw.print(matrix[i][j]);
                if(j < SIZE - 1) {
                    pw.print(" | ");
                }
            }
            if (i < SIZE -1) {
                pw.println("\n- | ---------");
            }
        }
        return sw.toString();
    }

    public void update(Symbol symbol, Coord coord) {
        matrix[coord.i()][coord.j()] = symbol;
    }

    public boolean verifyUpdate(Symbol symbol, Coord coord) {
        requireNonNull(symbol);
        requireNonNull(coord);

        if (symbol == Symbol.NONE) {
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if (matrix[coord.i()][coord.j()] != Symbol.NONE) {
            throw new IllegalArgumentException("Plays is not possible");
        }

        return true;
    }

    public boolean availability() {

        // Caso 1: linhas horizontais
        Symbol symbol = null;
        for (int i = 0; i < SIZE; i++) {
            boolean ganhou = true;
            for (int j = 0; j < SIZE; j++) {
                if(j == 0) {
                    symbol = matrix[i][j];
                }
                if(!symbol.equals(matrix[i][j]) || symbol.equals(Symbol.NONE)) {
                    ganhou = false;
                }
            }
            if (ganhou) {
                return true;
            }

        // Caso 2: linhas verticais
            ganhou = true;
            for (int j = 0; j < SIZE; j++) {
                if(j == 0) {
                    symbol = matrix[j][i];
                }
                if(!symbol.equals(matrix[j][i]) || symbol.equals(Symbol.NONE)) {
                    ganhou = false;
                }
            }
            if (ganhou) {
                return true;
            }
        }

        // Caso 3: linhas diagonais
        if (matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2]) && !matrix[0][0].equals(Symbol.NONE)) {
            return true;
        }
        return matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0]) && !matrix[0][2].equals(Symbol.NONE);
    }

    public Symbol verifyWinner() {

        // Caso 1: linhas horizontais
        Symbol symbol = null;
        for (int i = 0; i < SIZE; i++) {
            boolean ganhou = true;
            for (int j = 0; j < SIZE; j++) {
                if (j == 0) {
                    symbol = matrix[i][j];
                }
                if (!symbol.equals(matrix[i][j]) || symbol.equals(Symbol.NONE)) {
                    ganhou = false;
                }
            }
            if (ganhou) {
                return symbol;
            }

            // Caso 2: linhas verticais
            ganhou = true;
            for (int j = 0; j < SIZE; j++) {
                if (j == 0) {
                    symbol = matrix[j][i];
                }
                if (!symbol.equals(matrix[j][i]) || symbol.equals(Symbol.NONE)) {
                    ganhou = false;
                }
            }
            if (ganhou) {
                return symbol;
            }
        }

        // Caso 3: linhas diagonais
        if (matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2]) && !matrix[0][0].equals(Symbol.NONE)) {
            return matrix[0][0];
        }

        if (matrix[0][2].equals(matrix[1][1]) && matrix[0][2].equals(matrix[2][0]) && !matrix[0][2].equals(Symbol.NONE)) {
            return matrix[0][2];
        }

        return null;
    }
}
