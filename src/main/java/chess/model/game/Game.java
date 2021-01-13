package chess.model.game;

import chess.model.account.Player;
import chess.model.game.rules.GameStatusRules;
import chess.model.piece.Piece;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final List<Move> listOfMoves;
    private final Board board;
    private int movesSinceLastCapture;
    private Player currentPlayer;
    private List<GameStatusRules> gameStatusRulesList;

    public Game(Player whitePlayer, Player blackPlayer, Board board) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.currentPlayer = whitePlayer;
        this.board = board;
        listOfMoves = new ArrayList<>();
        movesSinceLastCapture = 0;
        // TODO: initialize gameStatusRulesList
    }

    public GameStatus makeMove(Player player, int fromX, int fromY, int toX, int toY, Piece promotedPiece) throws Exception {
        if (!player.equals(currentPlayer)) throw new Exception("Invalid player moving!");
        Square from = board.getSquare(fromX, fromY);
        Square to = board.getSquare(toX, toY);
        Move move = new Move(player, from, to, promotedPiece);
        return makeMove(move, player);
    }

    private GameStatus makeMove(Move move, Player player) {
        // TODO: check if move can be made
        // TODO: if the move is possible then log the move
        // TODO: check all the rules for winning / drawing
        // TODO: if the player is under check then the piece should be king / any other piece stopping check
        return GameStatus.ONGOING;
    }
}
