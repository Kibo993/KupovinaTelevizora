package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	//SREDITI DUGMI�E NAZAD I DALJE NA FORMI!!!!!!!!
	//PREPRAVITI TELEVIZOR, DODAVATI POLJA KAKO DODAJE� NOVA PITANJA!!!!!!!!!! VE� IMA CENA, NA�IN PRIJEMA, INTERNET!!!
//televizori specifikacije:
//	-DVB - T/C/S analogni tjuneri
//	-rezolucija
//	-smart ili ne - android ili drugi
//	-veli�ina ekrana
//	-tip ekrana led, oled, plazma, katodni
//	-cena
//  -Wi-fi
//  -Broj portova
//  -Odnos kontrasta (contrast ratio) (pozicioniranje televizora)
//  -dodatne funkcionalnosti (dvd, 3D, usb (ako �e da gleda samo filmove i slike), ...)
// 
	// Ekspert je prose�an �ovek koji ve� poseduje televizor koji se pokvario ili �eli da ga zameni novijim i koji se donekle razume.
	// blizina tv to uti�e na veli�inu ekrana a mo�e posredno i na rezoluciju (�ta �e nam mali tv sa velikom rezolucijom)
	// veza sa internetom i mesto prijema signala i na�in prijema uti�u na tjuner i Wi-fi (neki nemaju wifi a mogu na net)
	// za �ta �e televizor biti kori��en - da se vidi da li treba smart ili obi�ni da li �e gledati filmove ili samo sa kompa
	// ako gleda sadr�aj sa kompjutera (tipa youtube, ili skype) mo�da je bolje da uzme smart
	// Ako gleda programe susednih zemalja, potreban mu je tv sa jakim tjunerom dakle skuplji
	// Da li postoje u prodaji �isto analogni televizori, da li ponuditi polovne, da li korigovati cene u prvom pitanju???
	// Za odabir cene i razdaljine staviti slider!!!
	// Kako je bolje, da budu enumi ili stringovi jer ako su stringovi, onda je dovoljna jedna metoda za odgovore???
	// Kad je bolje popuniti objekat televizor, da li redom posle svakog pitanja ili na kraju???
	// 
	//pitanja:
	//
	//- Koliko mo�ete da izdvojite za televizor: do 15000,do 40000,do 90000, do 150000, do 200000;
	//- Za kakav sadr�aj naj�e��e koristite televizor: gledanje filmova, gledanje vesti, igranje igrica, gledanje zabavnog sadr�aja, sport;
	//- Na koji na�in primarno primate televizijski program: Kablovska, Satelitska, Zemaljska(preko antene), ne pratim klasi�ni tv program;
	//- (Ako prima zemaljsku televiziju)Na kojem podru�ju �ivite: Gradsko, Prigradsko, Seosko;
	//- (Ako ima kablovsku)Na koji na�in primate signal sa kablovske: Direktno (analogna), set top box, CI kartica;
	//- (Nadovezuje se na prethodno)Da li biste uzeli dodatne mogu�nosti koje nudi provajder: Da, Ne;
	//- (Ako ima satelitsku)Da li program pratite preko provajdera ili gledate slobodne kanale: Preko provajdera, Slobodno;
	//- (ako je ozna�io kablovska ili satelitska)Da li imate jo� neki na�in za prijem tv signala: Zemaljska(preko antene), Nemam;
	//- Da li imate internet: Da sa WiFi-jem, Da bez WiFi-ja, Ne;
	//- (Ako gleda samo filmove)(ili ako ne prati klasi�an tv program onda takvo pitanje npr. sport-Sa kojeg ure�aja gledate sportske doga�aje?)Sa kojeg ure�aja gledate filmove: Sa dvd-ja, sa ra�unara, streaming-om, sa usb-a;
	//- Kako je pozicioniran televizor u prostoriji: Naspram prozora, pored prozora, prozor je sa strane;
	//- Sa koje razdaljine gledate televiziju: 1m, 2m, 3m, 4m;
	//- (Mo�da i razli�ita pitanja u zavisnosti od toga �ta ima a �ta nema)Da li �elite nove mogu�nosti (uvo�enje interneta, kablovske,...): Da, Ne;

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	Televizor tv = new Televizor();
        	
        	FrmKupovinaTelevizora form = new FrmKupovinaTelevizora(tv);
        	form.setVisible(true);
        	while(form.isVisible()){
        	}
            kSession.insert(tv);
            kSession.fireAllRules();
            
            System.out.println("Max cena: "+tv.getCena());
        	System.out.println("Na�in prijema: "+tv.getNacinPrijema());
        	System.out.println("Prijem kablovske: "+tv.getPrijemKablovska());
        	System.out.println("Prijem satelitske: "+tv.getPrijemSatelitska());
        	System.out.println("Sekundarni prijem: "+tv.getSekundarniPrijem());
        	System.out.println("Nove mogu�nosti: "+tv.getNoveMogucnosti());
        	System.out.println("Internet: "+tv.getInternet());
        	System.out.println("Pozicija: "+tv.getPozicija());
        	System.out.println("Udaljenost: "+tv.getUdaljenostOdTV());
        	System.out.println("Dodatni ure�aji: "+tv.getDodatniUredjaji());
        	System.out.println("Mesto stanovanja: "+tv.getMestoStanovanja());
        	System.out.println("Za �ta se koristi: "+tv.getNeklasicanSadrzaj());
        	System.out.println("Smart: "+tv.getSmart());
        	System.out.println("Tuner: "+tv.getTuner());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
