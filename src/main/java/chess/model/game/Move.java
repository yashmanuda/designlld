package chess.model.game;

import chess.model.account.Player;
import chess.model.piece.Piece;
import lombok.Getter;

@Getter
public class Move {
    private Player movePlayer;
    private Square from;
    private Square to;
    private Piece movedPiece;
    private Piece promotedPiece;
    private Castling castling;
    private Piece capturedPiece;

    Move(Player movePlayer, Square from, Square to, Piece promotedPiece) {
        this.movePlayer = movePlayer;
        this.movedPiece = from.getPiece();
        this.from = from;
        this.promotedPiece = promotedPiece;
        this.to = to;
    }

    public String getMoveNotation() {
        return "";
    }

    public void setCastling(Castling castling) {
        this.castling = castling;
    }
}
