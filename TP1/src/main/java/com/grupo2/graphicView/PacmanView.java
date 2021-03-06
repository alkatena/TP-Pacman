package com.grupo2.graphicView;

import com.grupo2.constants.ViewConstants;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.ObjectView;
import java.awt.Dimension;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**
 *
 * @author fibrizo
 */
public class PacmanView extends ObjectView {

    private Pacman object;
    private int count;

    public PacmanView(Pacman pacman) {
        this.object = pacman;
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = new ImageIcon(ViewConstants.PACMAN_RIGHT);
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
        this.count = 1;
    }

    private ImageIcon chooseImage() {
        String directionString = object.getDirection().toString();
        this.changeSpriteNumber();
        return new ImageIcon(Paths.get("src", "main", "graphicResources", "Pacman" + directionString + String.valueOf(count) + ".png").toString());
    }

    @Override
    public void update() {
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = chooseImage();
        if (boardBackground != null) {
            this.image = boardBackground.getImage();
        }
    }

    private void changeSpriteNumber() {
        count = (count + 1) % 2;
    }

}
