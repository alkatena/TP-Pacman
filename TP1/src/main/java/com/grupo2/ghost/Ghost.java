package com.grupo2.ghost;

import com.grupo2.character.Character;
import com.grupo2.character.Direction;
import com.grupo2.ghostState.DeadState;
import com.grupo2.ghostState.HunterState;
import com.grupo2.interfaces.IGhost;
import com.grupo2.ghostState.Personality;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {

	private GhostState state;
        private Personality personality;

	/**
	 * Create a new instance of the class Ghost in the HunterState.
	 *
	 * @param x    CollidingArea in the X axis
	 * @param y    CollidingArea in the Y axis
	 * @param dir  Initial Direction
         * @param pers Initial personality of the Ghost
	 */
	/*public Ghost(final int x, final int y, Direction dir, Personality pers) {
		super(x, y, dir);
		this.state = new HunterState(pers);
	}*/
        
        private Ghost() {
            super();
            state = null;
        }
        
        
        public static Ghost createEmptyGhost() {
            return new Ghost();
        }
        

	/**
	 * Moves the Ghost in the direction specified and the Ghost behaves according to its actual
	 * state.
	 */
	@Override
	public void move() {
		this.state.getNewDirection(personality);
		this.state = state.returnNextState();
	}

	/**
	 * @return true if the Ghost is dead. False otherwise.
	 */
	@Override
	public boolean isDead() {
		return state.isDead();
	}

	@Override
	public void die() {
		this.state = new DeadState();
	}

	@Override
	public void convertToPrey() {
		this.state = state.convertToPrey();
	}

	@Override
	public void changeDirection(Direction theNewDirection) {
		this.direction = theNewDirection;
	}

	@Override
	public void onCollisionWithPacman() {
		this.state = state.collideWithPacman(); // Lo bueno de esto es que cuando muere un fantasma, en el constructor del DeadState (por ejemplo) podemos informar al juego y sumar puntos, etc.
	}

}
