package com.grupo2.graphicView;

import com.grupo2.board.Board;
import com.grupo2.controller.Controller;
import com.grupo2.fruit.Fruit;
import com.grupo2.ghost.Ghost;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.GraphicView;
import com.grupo2.view.ObjectView;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author fibrizo
 */
public class ViewsFactory {

    private static JFrame frame = new JFrame("Pacman Game");
    private static JFrame start;

    public static void createStartGame() throws InterruptedException {
        start = new JFrame("Start");
        start.setSize(640, 480);
        start.setLocationRelativeTo(null);
        start.add(new GameStartView());
        start.pack();
        start.setVisible(true);
        start.repaint();
        start.revalidate();
        Thread.sleep(1000);
    }

    private static void createEndGame() {
        start.getContentPane().removeAll();
        start.setTitle("Game Over");
        start.setSize(600, 600);
        start.setLocationRelativeTo(null);
        start.add(new GameEndView());
        start.pack();
        start.setVisible(false);
        start.repaint();
        start.revalidate();
    }

    public static void showEndGame() throws InterruptedException {
        start.setVisible(true);
        frame.setVisible(false);
        start.repaint();
        start.revalidate();
        Thread.sleep(3000);
        frame.dispose();
        start.dispose();
    }

    public static GraphicView createGraphicView(Board board, Controller controller) {
        List<Ghost> ghosts = board.getGhosts();
        Pacman pacman = Pacman.getPacman();
        Fruit fruit = board.getTheFruit();

        List<ObjectView> objectViews = new ArrayList<>();

        for (Ghost ghost : ghosts) {
            objectViews.add(new GhostView(ghost));
        }
        objectViews.add(new PacmanView(pacman));
        objectViews.add(new FruitView(fruit));

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();

        GraphicView theView = GraphicView.createGraphicView(board.getMaze(), frame);
        theView.addObjectViews(objectViews);
        theView.setKeyListener((KeyListener) controller.getReader());
        theView.initialize();
        start.setVisible(false);
        createEndGame();
        return theView;
    }

    private ViewsFactory() {
    }

}
