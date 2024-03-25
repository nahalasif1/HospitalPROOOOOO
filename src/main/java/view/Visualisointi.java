package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simu.model.Asiakas;
import simu.model.Palvelupiste;

public class Visualisointi implements IVisualisointi {
	Kontrolleri kontrolleri;
	private final Canvas canvas;
	private final GraphicsContext gc;

	double i = 0;
	double j = 10;

	public Visualisointi(Kontrolleri kontrolleri, Canvas canvas) {
		this.kontrolleri = kontrolleri;
		this.canvas = canvas;
		gc = this.canvas.getGraphicsContext2D();
	}

	public GraphicsContext getGc() {
		return gc;
	}
	public void tyhjennaNaytto() {
		gc.setFill(Color.YELLOW);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void uusiAsiakas() {
		int x = 0;
		int y = 0;

		//Platform.runLater(() -> {
			for (Palvelupiste p : kontrolleri.getPalvelupisteet()) {
				for (Asiakas asiakas : p.getJononAsiakkaat()) {
					//double x = p.getX();  // Get the x coordinate of the service point
					//double y = p.getY();  // Get the y coordinate of the service point
					asiakas.draw(gc, p.getX() + x, p.getY() + y);
					x+= 8;
					y+= 3;
					asiakas.removeDraw(gc, p.getX() + x, p.getY() + y);
				}
			}
		};

}
