/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.personality;
import com.grupo2.character.Direction;
import com.grupo2.ghostState.Personality;
import com.grupo2.constants.Constants;

/**
 *
 * @author fibrizo
 */
public class TemperamentalSeeker extends Personality {
    
    public TemperamentalSeeker() {
        vision = Constants.VISION4;
    }

    @Override
    public Direction getNewDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beginPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}