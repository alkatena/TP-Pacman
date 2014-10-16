package com.grupo2.game;

import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.XMLController;
import com.grupo2.interfaces.IGhost;
import com.grupo2.map.Map;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.view.View;
import com.grupo2.view.XMLView;

/**
 *
 * @author mauri
 */
public class Game {

    //TODO: Builders should depend on pgm arguments or something like that
    public void startGame() {

        Map map = new Map(new MazeXMLBuilder("path"), new CharacterXMLBuilder("otherpath"));
        Controller controller = new XMLController("cpath");
        View view = new XMLView("vpath");
        boolean ended = false;

        while (!ended) {
            map.getPacman().changeDirection(controller.getPacmanNextDirection());
            map.getPacman().move();
            map.getGhosts().forEach((IGhost iGhost) -> {
                iGhost.move();
            });
            view.persistMaze(map.getMaze());
            view.persistPacman(map.getPacman());
            map.getGhosts().forEach((IGhost ghost) -> {
                view.persistGhost(ghost);
            });

        }
    }
}
