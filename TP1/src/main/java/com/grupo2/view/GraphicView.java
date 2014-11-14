package com.grupo2.view;

import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.balls.BigBall;
import com.grupo2.maze.Maze;
import com.grupo2.balls.LittleBall;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import java.awt.LayoutManager;
import javax.swing.JLayeredPane;

public class GraphicView extends View {

    private JFrame frame;
    private ArrayList<GraphicNode> gNodes;
    private JPanel p;
    private JLayeredPane lPane;
    
    
    private GraphicView(Maze maze) {
        this.frame = new JFrame("Pacman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(48*maze.getWidth(),48*maze.getHeight());
        //lPane = new JLayeredPane();
        //frame.setLayeredPane(lPane);
        frame.setLocationRelativeTo(null);
        this.maze = maze;
        p = new JPanel();
        p.setLayout(new OverlayLayout(p));
    }
    
    
    public static GraphicView createGraphicView(Maze maze) {
        return new GraphicView(maze);
    }
    

    public void drawAll() {
        ArrayList<DrawableNode> cells = this.maze.getNodes();
        Background bgPanel = new Background();
        bgPanel.setLayout(new GridLayout(19, 19));
        JPanel ballsPanel = new JPanel();
        ballsPanel.setPreferredSize(new Dimension(912, 912));
        ballsPanel.setLayout(new GridLayout(19, 19));
       // ballsPanel.setOpaque(false);
        //bgPanel.setOpaque(false);

        cells.forEach((cell) -> {

            boolean transitable = cell.isTransitable();
            GraphicNode node = new GraphicNode(48, 48, 0, 0, transitable);
            node.setOpaque(false);
            
            if (transitable) {
                if (cell.hasBigBall()) {
                    node.add(new GraphicBigBall((BigBall)cell.getBall(), 0, 0));
                }
                if (cell.hasLittleBall()) {
                    node.add(new GraphicLittleBall((LittleBall)cell.getBall(), 0, 0));
                }
            }
            bgPanel.add(node);
        });

        for(ObjectView view : views) {
            view.setOpaque(false);
            p.add(view, new Integer(1));
        }
        
        p.add(bgPanel, new Integer(0));

        frame.add(p);
        

        
        frame.pack();
        frame.setVisible(true);
        
        frame.revalidate();
        
    }

   
    
    
    public void setKeyListener(KeyListener kl) {
        this.frame.addKeyListener(kl);
    }

    @Override
    public void show() {
        this.frame.add(p);
    }

}
