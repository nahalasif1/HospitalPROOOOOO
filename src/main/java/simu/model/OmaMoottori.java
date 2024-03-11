package simu.model;

import simu.framework.*;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import controller.IKontrolleriForM;

public class OmaMoottori extends Moottori{
	
	private Saapumisprosessi saapumisprosessi;

	private Palvelupiste[] palvelupisteet;


	public OmaMoottori(IKontrolleriForM kontrolleri){

		super(kontrolleri);

		palvelupisteet = new Palvelupiste[3];

		palvelupisteet[0]=new Vastaanotto(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.VASTAANOTTO1, 140,279);
		palvelupisteet[1]=new Vastaanotto(new Normal(10,10), tapahtumalista, TapahtumanTyyppi.VASTAANOTTO2, 91,245);

		palvelupisteet[2]=new Maksu(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.MAKSU1,427,127);
		palvelupisteet[3]=new Maksu(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.MAKSU2,393,109);

		palvelupisteet[4]=new Laakari(new Normal(15,5), tapahtumalista, TapahtumanTyyppi.LAAKARI1,59,163);
		palvelupisteet[5]=new Laakari(new Normal(15,5), tapahtumalista, TapahtumanTyyppi.LAAKARI2,126,69);

		palvelupisteet[6]=new Rontgenhoitaja(new Normal(20,5), tapahtumalista, TapahtumanTyyppi.RONTGEN1,291,37);
		palvelupisteet[7]=new Rontgenhoitaja(new Normal(20,5), tapahtumalista, TapahtumanTyyppi.RONTGEN2,135,71);

		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);

	}


	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
	}

	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat

		Asiakas a;
		switch ((TapahtumanTyyppi)t.getTyyppi()){

			case ARR1: palvelupisteet[0].lisaaJonoon(new Asiakas());
				       saapumisprosessi.generoiSeuraava();
					   kontrolleri.visualisoiAsiakas(); // UUSI
				break;
			case DEP1: a = (Asiakas)palvelupisteet[0].otaJonosta();
				   	   palvelupisteet[1].lisaaJonoon(a);
				break;
			case DEP2: a = (Asiakas)palvelupisteet[1].otaJonosta();
				   	   palvelupisteet[2].lisaaJonoon(a);
				break;
			case DEP3:
				       a = (Asiakas)palvelupisteet[2].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
			           a.raportti();
		}
	}

	@Override
	protected void yritaCTapahtumat(){
		for (Palvelupiste p: palvelupisteet){
			if (!p.onVarattu() && p.onJonossa()){
				p.aloitaPalvelu();
			}
		}
	}

	@Override
	protected void tulokset() {
		System.out.println("Simulointi päättyi kello " + Kello.getInstance().getAika());
		System.out.println("Tulokset ... puuttuvat vielä");

		// UUTTA graafista
		kontrolleri.naytaLoppuaika(Kello.getInstance().getAika());
	}

	
}
