package chess.model.game;

import chess.model.piece.Piece;
import lombok.Getter;

@Getter
public class Square {
    private Piece piece;
    private final Color squareColor;
    private final int row;
    private final int col;

    public Square(Piece piece, Color squareColor, int row, int col) {
        this.piece = piece;
        this.squareColor = squareColor;
        this.row = row;
        this.col = col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    @Override
    public String toString() {
        return "Square{" +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
