package chess.model.piece;

import chess.model.exception.InvalidMoveExcepion;
import chess.model.exception.InvalidSqaureException;
import chess.model.game.Board;
import chess.model.game.Square;

public class King extends Piece {
    private boolean hasKingMoved;

    public King() {
        this.hasKingMoved = false;
    }

    @Override
    boolean canMove(Board board, Square from, Square to) throws InvalidSqaureException, InvalidMoveExcepion {
        // TODO: check square validity
        // TODO: check if moving king leads to check
        // TODO: check if it's long castle / short castle
        return false;
    }

    public boolean isShortCastle(Board board, Square from, Square to) {
        // TODO: valid short castle (rook & king have not moved)
        // TODO: no check in king's path to castle
        // TODO: no check after castle to king
        // TODO: cannot castle under check
        return false;
    }

    public boolean isLongCastle(Board board, Square from, Square to) {
        return false;
    }

    public void setHasKingMoved(boolean hasKingMoved) {
        this.hasKingMoved = hasKingMoved;
    }
}
