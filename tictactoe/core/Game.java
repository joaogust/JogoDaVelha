package core;

public class Game {

    private final Board board = new Board();
    private final Players[] players = new Players[2];

    public void start() {
        System.out.println("Jogo iniciado!");
        System.out.println(board);
    }
}
