package com.grupo2.maze;

import com.grupo2.character.cell.RawCell;
import com.grupo2.character.cell.TransitableCell;
import com.grupo2.character.cell.UntransitableCell;
import com.grupo2.balls.Ball;
import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ivan
 */
public class MazeXMLBuilder implements MazeBuilder {

	private final File xmlFile;

	public MazeXMLBuilder(String path) {
		this.xmlFile = new File(path);
	}

	@Override
	public RawMaze buildMaze() {
		RawMaze maze = null;
		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc;
			doc = dBuilder.parse(this.xmlFile);
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			int width = Integer.parseInt(root.getAttribute("ancho"));
			int height = Integer.parseInt(root.getAttribute("alto"));
			maze = new RawMaze(height, width);
			NodeList nList = doc.getElementsByTagName("nodo");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int y = Integer.parseInt(eElement.getAttribute("fila"));
					int x = Integer.parseInt(eElement.getAttribute("columna"));
					String content = eElement.getAttribute("contenido");
					RawCell aCell;
					if ("".equals(content)) {
						aCell = new UntransitableCell(x, y);
					} else {
						aCell = new TransitableCell(x, y);
						Ball ball = (content.equals("bolita") ? new LittleBall() : new BigBall());
						((TransitableCell) aCell).setBall(ball);
					}
					maze.addCell(aCell);
				}
			}
			maze.connectCells();

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		}
		return maze;
	}

}