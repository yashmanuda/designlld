package chess.model.piece;

import chess.model.exception.InvalidMoveExcepion;
import chess.model.exception.InvalidSqaureException;
import chess.model.game.Board;
import chess.model.game.Square;

public class Knight extends Piece {

    @Override
    boolean canMove(Board board, Square from, Square to) throws InvalidSqaureException, InvalidMoveExcepion {
        if (!board.isValidSquare(from) || !board.isValidSquare(to)) {
            throw new InvalidSqaureException("Invalid board square!");
        }

        if (!isKnightMove(from, to) || !isEmptyOrOppositeColor(from, to)) {
            throw new InvalidMoveExcepion("Knight cannot move from " + from + " to " + to);
        }

        // TODO: the move doesn't lead to self check


        return true;
    }

    private boolean isKnightMove(Square from, Square to) {
        int xDiff = Math.abs(from.getRow() - to.getRow());
        int yDiff = Math.abs(from.getCol() - to.getCol());
        return xDiff > 0 && yDiff > 0 && xDiff + yDiff == 3;
    }
}
