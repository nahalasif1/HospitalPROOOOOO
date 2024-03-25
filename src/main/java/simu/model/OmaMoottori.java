package simu.model;

import javafx.scene.input.DataFormat;
import simu.framework.*;
import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import controller.IKontrolleriForM;


import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;

public class OmaMoottori extends Moottori{
	
	private Saapumisprosessi saapumisprosessi;

	private Palvelupiste[] palvelupisteet;

	//private simulaatio simulaatio;

	private int [] servicePointConfigurations = {0,0,0,0};


	public OmaMoottori(IKontrolleriForM kontrolleri){

		super(kontrolleri);

		palvelupisteet = new Palvelupiste[9];

		palvelupisteet[0]=new Vuoronumero(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.VUORONUMERO1, 313,260);

		palvelupisteet[1]=new Vastaanotto(new Normal(10,6), tapahtumalista, TapahtumanTyyppi.VASTAANOTTO1, 140,279);
		palvelupisteet[2]=new Vastaanotto(new Normal(10,10), tapahtumalista, TapahtumanTyyppi.VASTAANOTTO2, 91,245);

		palvelupisteet[3]=new Laakari(new Normal(15,5), tapahtumalista, TapahtumanTyyppi.LAAKARI1,59,163);
		palvelupisteet[4]=new Laakari(new Normal(15,5), tapahtumalista, TapahtumanTyyppi.LAAKARI2,126,69);

		palvelupisteet[5]=new Rontgenhoitaja(new Normal(20,5), tapahtumalista, TapahtumanTyyppi.RONTGEN1,291,37);
		palvelupisteet[6]=new Rontgenhoitaja(new Normal(20,5), tapahtumalista, TapahtumanTyyppi.RONTGEN2,135,71);

		palvelupisteet[7]=new Maksu(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.MAKSU1,427,127);
		palvelupisteet[8]=new Maksu(new Normal(5,3), tapahtumalista, TapahtumanTyyppi.MAKSU2,393,109);



		saapumisprosessi = new Saapumisprosessi(new Negexp(15,5), tapahtumalista, TapahtumanTyyppi.ARR1);

	}


	public void setServicePointConfigurations(int[] servicePointConfigurations) {
		this.servicePointConfigurations = servicePointConfigurations;
	}

	public int[] getServicePointConfigurations() {
		return servicePointConfigurations;
	}

	@Override
	protected void alustukset() {
		saapumisprosessi.generoiSeuraava(); // Ensimmäinen saapuminen järjestelmään
		Date date = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String strDate = df.format(date);
		//simulaatio = new simulaatio(servicePointConfigurations, strDate);
		//Simudao persist ( This operation saves the simulation data, including the settings and the timestamp, into the database.)
		//Simulaatio
		//AsiakasDAO
	}

	@Override
	public int getSimulointiaika (){
		return 0;
	}
	@Override
	protected void suoritaTapahtuma(Tapahtuma t){  // B-vaiheen tapahtumat

		Asiakas a;
		boolean continueLoop;
		int j;
		switch ((TapahtumanTyyppi)t.getTyyppi()){

			case ARR1:
				continueLoop = true;
				j=0;
				while (continueLoop) {
					for (int i = 0; i < servicePointConfigurations[0]; i++) {
						if (palvelupisteet[i].GetJonoSize() == j) {
							palvelupisteet[i].lisaaJonoon(new Asiakas());
							saapumisprosessi.generoiSeuraava();
							//kontrolleri.visualisoiAsiakas(); // UUSI
							System.out.println("Asiakas saapui palvelupisteeseen " + i);
							continueLoop = false;
							break;
						}
					}
					j ++;
				}
				saapumisprosessi.generoiSeuraava();
				break;

			/*case VUORONUMERO1:
				a = (Asiakas)palvelupisteet[0].otaJonosta();
				palvelupisteet[1].lisaaJonoon(a);
				palvelupisteet[2].lisaaJonoon(a);
				break;*/

			case VASTAANOTTO1:
				a = (Asiakas)palvelupisteet[1].otaJonosta();
				continueLoop = true;
				j = 0;
				while (continueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[1].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}

			case VASTAANOTTO2:
				a = (Asiakas)palvelupisteet[2].otaJonosta();
				continueLoop = true;
				j = 0;
				while (continueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[2].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}


			case LAAKARI1:
				a = (Asiakas)palvelupisteet[3].otaJonosta();;
				continueLoop = true;
				j = 0;
				while (continueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[i].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}
				break;
			case LAAKARI2:
				a = (Asiakas)palvelupisteet[4].otaJonosta();
				continueLoop = true;
				j = 0;
				while (continueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[i].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}
				break;

			case RONTGEN1:
				a = (Asiakas)palvelupisteet[5].otaJonosta();
				if (a.isneedsMri()) {
					continueLoop = true;
					j = 0;
					while (continueLoop) {
						for (int i = 2; i < servicePointConfigurations[1]; i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								continueLoop = false;
								break;
							}
						}
						j++;
					}
				}	 else { palvelupisteet[7].lisaaJonoon(a);}

				break;
			case RONTGEN2:
				a = (Asiakas)palvelupisteet[6].otaJonosta();
				if (a.isneedsMri()) {
					continueLoop = true;
					j = 0;
					while (continueLoop) {
						for (int i = 2; i < servicePointConfigurations[1]; i++) {
							if (palvelupisteet[i].GetJonoSize() == j) {
								palvelupisteet[i].lisaaJonoon(a);
								continueLoop = false;
								break;
							}
						}
						j++;
					}
				}	 else { palvelupisteet[8].lisaaJonoon(a);

				}
				break;
			/*case MAKSU1:
				a = (Asiakas)palvelupisteet[7].otaJonosta();
				continueLoop = true;
				j = 0;
				while (coninueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[i].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}
				break;*/
			/*case MAKSU2:
				a = (Asiakas)palvelupisteet[8].otaJonosta();
				continueLoop = true;
				j = 0;
				while (continueLoop)
				{
					for (int i = 2; i < servicePointConfigurations[1]; i++)
					{
						if (palvelupisteet[i].GetJonoSize() == j)
						{
							palvelupisteet[i].lisaaJonoon(a);
							continueLoop = false;
							break;
						}
					}
					j++;
				}
				break;*/



			case MAKSU1: a = (Asiakas)palvelupisteet[7].otaJonosta();
				   	   	a.tulos();
						a.setPoistumisaika(Kello.getInstance().getAika());

			case MAKSU2:
				       a = (Asiakas)palvelupisteet[8].otaJonosta();
					   a.setPoistumisaika(Kello.getInstance().getAika());
			           a.tulos();
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

	public Palvelupiste[] getPalvelupisteet() {
		return palvelupisteet;
	}
}
