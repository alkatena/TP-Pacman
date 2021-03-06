package com.grupo2.character;

import com.grupo2.directions.LeftDirection;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class CharacterBuilderTest {

    private CharacterBuilder charBuilder;

    public CharacterBuilderTest() {
    }

    @Before
    public void setUp() {
        try {
            charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
        } catch (Exception e) {
            assert (false);
        }
    }

    /**
     * Test of getPacman method, of class CharacterBuilder.
     */
    @Test
    public void getPacmanPosition() {

        Pacman builtPacman;
        try {
            builtPacman = charBuilder.getPacman();
            builtPacman.setCurrentCell(new Cell(9, 4, true));
        } catch (Exception e) {
            assert (false);
            return;
        }

        Coordinate builtPacPosition = builtPacman.getPosition();
        Direction builtPacDirection = builtPacman.getDirection();

        Coordinate expectedPacPosition = new Coordinate(9, 4);
        LeftDirection expectedPacDirection = new LeftDirection();

        boolean samePositions = builtPacPosition.isEqualTo(expectedPacPosition);
        boolean sameDirections = builtPacDirection.isEqualTo(expectedPacDirection);

        assertTrue(sameDirections && samePositions);
    }

}
