/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;
import com.grupo2.view.GraphicView;
import com.grupo2.board.Board;
import com.grupo2.ghost.Ghost;
import com.grupo2.pacman.Pacman;
import com.grupo2.fruit.Fruit;
import java.util.ArrayList;
import java.util.List;
import com.grupo2.view.ObjectView;

/**
 *
 * @author fibrizo
 */
public class ViewsFactory {
    
    
    public static GraphicView createGraphicView(Board board) {
        List<Ghost> ghosts = board.getGhosts();
        Pacman pacman = Pacman.getPacman();
        Fruit fruit = board.getTheFruit();
        
        List<ObjectView> objectViews = new ArrayList<>();
        
       // for (Ghost ghost : ghosts)
         //   objectViews.add(new GhostView(ghost));
        objectViews.add(new PacmanView(pacman));
        //objectViews.add(new FruitView(fruit));
        
        GraphicView theView = GraphicView.createGraphicView(board.getMaze());
        theView.addObjectViews(objectViews);
        return theView;
    }
    
    private ViewsFactory() {
    }
    
}
