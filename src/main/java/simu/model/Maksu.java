package simu.model;
import eduni.distributions.ContinuousGenerator;
import simu.framework.Tapahtumalista;
public class Maksu extends Palvelupiste {
    private static int counters = 0;
    private static int customers = 0;
    public Maksu(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi, int x, int y) {
        super(generator, tapahtumalista, tyyppi, x,  y);
        counters++;
    }
    @Override
    public void aloitaPalvelu() {
        System.out.println("Check-IN: ");
        super.aloitaPalvelu();
    }

}
