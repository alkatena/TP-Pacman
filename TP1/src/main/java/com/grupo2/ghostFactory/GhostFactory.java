package com.grupo2.ghostFactory;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghostState.HunterState;
import com.grupo2.ghost.Personality;

import com.grupo2.personality.OnlyRight;

/**
 *
 * @author fibrizo
 */
public class GhostFactory {

    /**
     * Creates a ghost with specific parameters.
     * @param state
     * @param pers
     * @param coord
     * @param dir
     * @return 
     */
    public static Ghost createGhost(GhostState state, Personality pers,
            Coordinate coord, Direction dir) {
        Ghost newGhost = Ghost.createEmptyGhost();
        newGhost.setState(state);
        newGhost.setPersonality(pers);
        newGhost.setDirection(dir);
        newGhost.setPosition(coord);
        return newGhost;
    }

    /**
     * Creates a ghost that only goes right.
     * @return 
     */
    public static Ghost createOnlyRightGhost() {
        Ghost aGhost = Ghost.createEmptyGhost();
        aGhost.setState(new HunterState());
        aGhost.setPersonality(new OnlyRight());
        aGhost.setDirection(new RightDirection());
        return aGhost;
    }

}
