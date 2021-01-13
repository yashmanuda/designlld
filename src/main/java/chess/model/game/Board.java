package chess.model.game;

import chess.model.exception.InvalidSqaureException;
import chess.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Square[][] boardGrid;
    private List<Piece> killedPieces;

    public void initializeBoard() {
        killedPieces = new ArrayList<>();
        // TODO: initialize board grid
    }

    private int getNumOfRows() {
        return boardGrid.length;
    }

    private int getNumOfCols() {
        return boardGrid[0].length;
    }

    public boolean isValidSquare(Square square) {
        int row = square.getRow(), col = square.getCol();
        return row >= 0 && col >= 0 && row < getNumOfRows() && col < getNumOfCols();
    }

    public Square getSquare(int x, int y) throws InvalidSqaureException {
        if (x >= 0 && y >= 0 && x < getNumOfRows() && y < getNumOfCols())
            return boardGrid[x][y];
        throw new InvalidSqaureException("Invalid square " + x + ", " + y);
    }
}
