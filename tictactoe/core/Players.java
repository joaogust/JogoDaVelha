package core;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static int round;

    private final List<Symbol> players = new ArrayList<>(2);
    private int currentPlayerIndex = 1;

    public Players() {
        players.add(Symbol.X);
        players.add(Symbol.O);
    }

    public static int getRound() {
        return round;
    }

    public static void addRound() {
        round++;
    }

    public Symbol next() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(currentPlayerIndex);
    }

    public Symbol getActualPlayer() {
        int temp = (currentPlayerIndex + 1) % players.size();
        return players.get(temp);
    }
}
