package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {

    void stepForward(ICharacter character);
    
    public boolean EqualTo(Direction other);

    boolean isEqualTo(LeftDirection other);

    boolean isEqualTo(RightDirection other);

    boolean isEqualTo(UpDirection other);

    boolean isEqualTo(DownDirection other);

    boolean canGoForward(Cell cell);

    boolean isOposedTo(Direction other);

}
