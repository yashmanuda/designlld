package chess.model.game.rules;

import chess.model.game.Game;
import chess.model.game.GameStatus;

public interface GameStatusRules {
    GameStatus getGameStatus(Game game);
}
