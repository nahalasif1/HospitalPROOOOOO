package simu.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simu.framework.Trace;

public class Asiakas {
	private int id;
	private static int i = 1;
	private double saapumisaika;
	private double poistumisaika;
	private static long sum = 0;
	public boolean needsMri = true;
	public boolean isneedsMri() {
		return needsMri;
	}

	public Asiakas() {
		id = i++;
		saapumisaika = System.currentTimeMillis();
		System.out.println("Uusi asiakas: " + id + ", saapumisaika: " + saapumisaika);
		needsMri = true;
	}

	public int getId() {
		return id;
	}

	public void setPoistumisaika(double poistumisaika) {
		this.poistumisaika = poistumisaika;
	}

	public double getSaapumisaika() {
		return saapumisaika;
	}

	public void draw(GraphicsContext gc, double x, double y) {
		if (needsMri) {
			gc.setFill(Color.GREEN);
		} else {
			gc.setFill(Color.RED);
		}
		gc.fillOval(x, y, 10, 10);
	}

	public void removeDraw(GraphicsContext gc, double x, double y) {
		gc.setFill(Color.TRANSPARENT);
		gc.fillOval(x, y, 1, 1);
		gc.setFill(Color.TRANSPARENT);
	}

	public double tulos () {
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " saapui :" + saapumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " poistui :" + poistumisaika);
		Trace.out(Trace.Level.INFO, "Asiakas " + id + " viipyi simulaatiossa :" + (poistumisaika - saapumisaika));
		double keskiarvo = sum / id;
		sum += (poistumisaika  - saapumisaika);
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo " + keskiarvo);
		return keskiarvo;

	}



}
