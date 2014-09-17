/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.constants.Constants;
import com.grupo2.character.IGhost;
import com.grupo2.movementStrategies.DeadStrategy;

/**
 *
 * @author fibrizo
 */
public class DeadState extends GhostState {

    float time;
    DeadMovement movement;

    public DeadState() {
        time = 0;
        movement = new DeadStrategy();
    }

    @Override
    public void move() {
        time++;
        movement.move();
    }

    /**
     * @return True, because the State of the Ghost is "Dead".
     */
    @Override
    public boolean isDead() {
        return true;
    }

    /* @return the next state of the Ghost. returns this, except that the time
     * has passed. In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.getDEAD_LIMIT_TIME()) {
            return new HunterState();
        }
        return this;
    }

    /**
     * Nothing happen, the state keeps the same.
     * @param ghost is the ghost that is colliding with this.
     */
    @Override
    public void beEaten(IGhost ghost) {
        // Do nothing
    }
    
    @Override
    public GhostState convertToPrey() {
        throw new AssertionError("A dead Ghost can't be converted to Prey");
    }
    
    @Override
    public GhostState die() {
        throw new AssertionError("A dead Ghost can't die again");
    }

}
