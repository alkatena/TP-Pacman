/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public interface ICharacter {

    public abstract void move();

    public abstract boolean isDead();

    public CollidingArea getPosition();
}
