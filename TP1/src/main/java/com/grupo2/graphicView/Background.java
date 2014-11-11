package com.grupo2.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ivan
 */
public class Background extends JPanel {

	private final Image bImage;

	public Background() {
		ImageIcon boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "board.png").toString());
		this.bImage = boardBackground.getImage();
		int w = this.bImage.getWidth(this);
		int h = this.bImage.getHeight(this);
		this.setPreferredSize(new Dimension(800, 600));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.bImage, 0, 0, 800, 600, null);
	}
}
