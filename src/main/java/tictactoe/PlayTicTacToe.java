package tictactoe;

import java.util.Scanner;

public class PlayTicTacToe {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(game.isPlayerOneTurn() ? "Player one turn!" : "Player two turn!");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            try {
                int winner = game.move(game.isPlayerOneTurn(), row, col);
                if (winner == 1 || winner == -1) {
                    System.out.println("Winner is player : " + ((winner == 1) ? "one" : "two"));
                    break;
                }
                if (winner == 2) {
                    System.out.println("It's a draw!");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
