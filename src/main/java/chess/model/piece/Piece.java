package chess.model.piece;


import chess.model.exception.InvalidMoveExcepion;
import chess.model.exception.InvalidSqaureException;
import chess.model.game.Board;
import chess.model.game.Color;
import chess.model.game.Square;

public abstract class Piece {
    private Color pieceColor;
    protected boolean isKilled;

    abstract boolean canMove(Board board, Square from, Square to) throws InvalidSqaureException, InvalidMoveExcepion;

    boolean isEmptyOrOppositeColor(Square from, Square to) {
        return to.isEmpty() || !from.getPiece().pieceColor.equals(to.getPiece().pieceColor);
    }
}
