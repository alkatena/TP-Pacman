package com.grupo2.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.cell.Cell;

/**
 *
 * @author mauri
 */
public class UpDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.setCurrentCell(aCharacter.getCurrentCell().getUpperCell());
    }
    
    @Override
    public boolean isEqualTo(LeftDirection aDirection) {
        return false;
    }

    @Override
    public boolean isEqualTo(RightDirection aDirection) {
        return false;
    }

    @Override
    public boolean isEqualTo(UpDirection aDirection) {
        return true;
    }

    @Override
    public boolean isEqualTo(DownDirection aDirection) {
        return false;
    }
    
    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getUpperCell().isTransitable();
    }   

    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
    }
    
    @Override
    public boolean isOposedTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(RightDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(UpDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(DownDirection other) {
        return true;
    }      
}
