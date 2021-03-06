package com.grupo2.scenarios;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.controller.Controller;
import com.grupo2.directions.RightDirection;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fibrizo
 */
public class SecondScenarioTest {

    private Pacman thePacman;
    private Maze maze;
    private Board map;

    public SecondScenarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParserConfigurationException {
        MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
        CharacterBuilder charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajePacmanSolo.xml"));
        map = Board.createBoard(mazeBuilder, charBuilder);
        map.subscribeSubscribers();
        thePacman = map.getPacman();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PacmanEatsBallsAndRespectsPortals() throws UnsupportedOperationException {

        Controller controller = new Controller(() -> new RightDirection());
        for (int i = 0; i < 13; i++) {
            map.updateModel(controller);
        }

        int ballsEaten = 0;

        for (int i = 0; i < 11; i++) {
            if (map.getMaze().getCellFromCoordinates(new Coordinate(i, 1)).isEmpty()) {
                ballsEaten++;
            }
        }

        Coordinate expectedPosition = new Coordinate(4, 1);
        boolean positionOK = expectedPosition.isEqualTo(thePacman.getPosition());

        assertTrue(positionOK && ballsEaten == 11);

    }
}
