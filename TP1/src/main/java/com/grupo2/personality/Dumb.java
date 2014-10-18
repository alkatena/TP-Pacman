/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.personality;
import com.grupo2.maze.MazePublisher;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.movementStrategies.MovementStrategy;
import com.grupo2.movementStrategies.RandomStrategy;
import com.grupo2.movementStrategies.ChaseStrategy;
import com.grupo2.ghostState.Personality;
import com.grupo2.command.HunterStartsChaseOfPacman;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class Dumb extends Personality {
    
    private MovementStrategy movement;
    
    public Dumb() {
        Subscriber sub = new HunterStartsChaseOfPacman(this);
        MazePublisher.getInstance().subscribe(MazePublisher.MazeEvent.GHOSTISCLOSETOPACMAN, this);
        movement = new RandomStrategy();
    }
    
    @Override
    public Direction getNewDirection() {
        return movement.getNewDirection();
        
    }
    
    public void beginPacmanChase() {
        this.movement = new ChaseStrategy();
    }
}
