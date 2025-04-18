package core;

import static io.Output.*;
import static io.Input.*;

public class Game {

    private final Board board = new Board();
    private final Players players = new Players();
    private Symbol winner;

    public void start() {
        write("-------------\nJOGO DA VELHA\n-------------");
        while (true) {
            writeNewLine();
            write(board);
            writeNewLine();

            Coord coord;
            write("Player '" + players.getActualPlayer() + "', it's your round!");
            while (true) {
                String play = read("Play =>");
                try {
                    coord = Coord.parse(play);
                    if (board.verifyUpdate(players.getActualPlayer(), coord)) {
                        board.update(players.next(), coord);
                        break;
                    }

                } catch (IllegalArgumentException e) {
                    write("ERROR: " + e.getMessage() + "\n");
                    write("Player " + players.getActualPlayer() + ", try again");
                }

            }
            if (board.availability()) {
                write("\n---------------------");
                write("      End Game");
                write("---------------------\n");
                write(board + "\n");
                winner = board.verifyWinner();
                write("The winner was: '" + winner + "'");
                write("End Game.");
                break;
            }

        }
    }
}
