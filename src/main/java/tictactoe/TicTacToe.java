package tictactoe;

public class TicTacToe {
    private Integer[][] board;
    private int squaresFilled;
    private int gridSize;
    private int[] rowSum;
    private int[] colSum;
    private int diagonalSum;
    private int reverseDiagonalSum;
    private boolean isPlayerOneTurn;

    public TicTacToe(int n) {
        if (n <= 1) throw new RuntimeException("Incorrect board size, should be at least 2!");
        gridSize = n;
        squaresFilled = 0;
        board = new Integer[n][n];
        rowSum = new int[n];
        colSum = new int[n];
        diagonalSum = 0;
        reverseDiagonalSum = 0;
        isPlayerOneTurn = true;
    }

    /**
     * @param isPlayerOne is it player one move
     * @param row         to mark the row
     * @param col         to mark the col
     * @return 1, 0, -1 and 2 if player one wins, no winner yet, if player two wins and ends in a draw respectively
     * @throws Exception if it's an illegal move
     */
    public int move(boolean isPlayerOne, int row, int col) throws Exception {
        // check square validity
        if (!isValidSquare(row, col)) throw new IllegalArgumentException("Incorrect square location!");

        // check if square is already filled
        if (board[row][col] != null) throw new IllegalArgumentException("Square square is already filled!");

        // check correct player move
        if (isPlayerOne ^ isPlayerOneTurn) throw new IllegalArgumentException("Incorrect player moved!");

        // player will be 1 or -1
        int player = isPlayerOne ? 1 : -1;
        markAndUpdateSums(row, col, player);

        // switch player for next turn
        isPlayerOneTurn = !isPlayerOneTurn;

        return isWinner(row, col, player);
    }

    private void markAndUpdateSums(int row, int col, int player) {
        board[row][col] = player;
        squaresFilled += 1;

        // mark the respective cols and rows
        rowSum[row] += player;
        colSum[col] += player;

        // mark the diagonal
        if (row == col) {
            diagonalSum += player;
        }

        // mark the reverse diagonal
        if (row + col == gridSize - 1) {
            reverseDiagonalSum += player;
        }
    }

    private boolean isValidSquare(int row, int col) {
        return (row >= 0 && col >= 0 && row < gridSize && col < gridSize);
    }

    /**
     * @param row    current row
     * @param col    current col
     * @param player current player 1 or -1
     * @return 1, 0, -1 and 2 if player one wins, no winner yet, if player two wins and ends in a draw respectively
     */
    private int isWinner(int row, int col, int player) {
        // check row or col sum
        if (rowSum[row] == gridSize * player || colSum[col] == gridSize * player) return player;

        // check diagonal sums
        if (reverseDiagonalSum == gridSize * player || diagonalSum == gridSize * player) return player;

        // check if all squares are filled, in which case it's a draw
        if (squaresFilled == gridSize * gridSize) return 2;

        return 0;
    }

    public boolean isPlayerOneTurn() {
        return isPlayerOneTurn;
    }
}
