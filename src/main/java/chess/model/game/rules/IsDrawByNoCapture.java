package chess.model.game.rules;

import chess.model.game.Game;
import chess.model.game.GameStatus;

public class IsDrawByNoCapture implements GameStatusRules {
    @Override
    public GameStatus getGameStatus(Game game) {
        if (game.getMovesSinceLastCapture() > 50) return GameStatus.DRAW;
        return GameStatus.ONGOING;
    }
}
