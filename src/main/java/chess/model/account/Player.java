package chess.model.account;

import chess.model.game.Color;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Player extends Account {
    private Color color;
}
