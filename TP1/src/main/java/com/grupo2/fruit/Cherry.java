/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.fruit;

import com.grupo2.maze.Maze;

/**
 *
 * @author mauri
 */
public class Cherry extends Fruit {

    public Cherry(Maze maze) {
        super(maze);
    }

    @Override
    public void die() {
        //To do
        this.alive = false;
    }

    @Override
    public void eat() {
        if (this.alive) // Add points and dissapear
        {
            return;
        }
    }

    @Override
    public boolean isDead() {
        if (this.alive) {
            return false;
        }
        return true;
    }

}
