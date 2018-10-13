package com.televizor;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class TelevizorMain {
	// U FORMI ZA ODGOVOR STAVI SAMO ONE ATRIBUTE KOJI SU BITNI ZA EKSPERTA I KOMENTAR STAVI POSEBNO DA SE PRIKAZUJE!!!
	// U FORMI ZA ODGOVOR DODAJ DVA DUGMETA - JEDNO VRAÆA NA PRVU FORMU, DRUGO ZATVARA I ZAVRŠAVA SVE!!!
	// SLAJDER ZA PITANJE CENE DA LI DA IDE DO 1 000 000 RSD I DA LI STAVITI 2 SLAJDERA GDE BI DRUGI BIRAO OPSEG CENA!!!
//televizori specifikacije:
//	-DVB - T/C/S analogni tjuneri
//	-rezolucija
//	-smart ili ne - android ili drugi
//	-velièina ekrana
//	-tip ekrana led, oled, plazma, katodni
//	-cena
//  -Wi-fi
//  -Broj portova
//  -Odnos kontrasta (contrast ratio) (pozicioniranje televizora)
//  -dodatne funkcionalnosti (dvd, 3D, usb (ako æe da gleda samo filmove i slike), ...)
// 
	// Ekspert je proseèan èovek koji veæ poseduje televizor koji se pokvario ili želi da ga zameni novijim i koji se donekle razume.
	// blizina tv to utièe na velièinu ekrana a može posredno i na rezoluciju (šta æe nam mali tv sa velikom rezolucijom)
	// veza sa internetom i mesto prijema signala i naèin prijema utièu na tjuner i Wi-fi (neki nemaju wifi a mogu na net)
	// za šta æe televizor biti korišæen - da se vidi da li treba smart ili obièni da li æe gledati filmove ili samo sa kompa
	// ako gleda sadržaj sa kompjutera (tipa youtube, ili skype) možda je bolje da uzme smart
	// Ako gleda programe susednih zemalja, potreban mu je tv sa jakim tjunerom dakle skuplji
	// Da li postoje u prodaji èisto analogni televizori, da li ponuditi polovne, da li korigovati cene u prvom pitanju???
	// Za odabir cene i razdaljine staviti slider!!!
	// Kako je bolje, da budu enumi ili stringovi jer ako su stringovi, onda je dovoljna jedna metoda za odgovore???
	// Kad je bolje popuniti objekat televizor, da li redom posle svakog pitanja ili na kraju???
	// Smart TV nema analogni tjuner - vodi raèuna o tome!!!!
	// 
	//pitanja:
	//
	//- Koliko možete da izdvojite za televizor: do 15000,do 40000,do 90000, do 150000, do 200000;
	//- Za kakav sadržaj najèešæe koristite televizor: gledanje filmova, gledanje vesti, igranje igrica, gledanje zabavnog sadržaja, sport;
	//- Na koji naèin primarno primate televizijski program: Kablovska, Satelitska, Zemaljska(preko antene), ne pratim klasièni tv program;
	//- (Ako prima zemaljsku televiziju)Na kojem podruèju živite: Gradsko, Prigradsko, Seosko;
	//- (Ako ima kablovsku)Na koji naèin primate signal sa kablovske: Direktno (analogna), set top box, CI kartica;
	//- (Nadovezuje se na prethodno)Da li biste uzeli dodatne moguænosti koje nudi provajder: Da, Ne;
	//- (Ako ima satelitsku)Da li program pratite preko provajdera ili gledate slobodne kanale: Preko provajdera, Slobodno;
	//- (ako je oznaèio kablovska ili satelitska)Da li imate još neki naèin za prijem tv signala: Zemaljska(preko antene), Nemam;
	//- Da li imate internet: Da sa WiFi-jem, Da bez WiFi-ja, Ne;
	//- (Ako gleda samo filmove)(ili ako ne prati klasièan tv program onda takvo pitanje npr. sport-Sa kojeg ureðaja gledate sportske dogaðaje?)Sa kojeg ureðaja gledate filmove: Sa dvd-ja, sa raèunara, streaming-om, sa usb-a;
	//- Kako je pozicioniran televizor u prostoriji: Naspram prozora, pored prozora, prozor je sa strane;
	//- Sa koje razdaljine gledate televiziju: 1m, 2m, 3m, 4m;
	//- (Možda i razlièita pitanja u zavisnosti od toga šta ima a šta nema)Da li želite nove moguænosti (uvoðenje interneta, kablovske,...): Da, Ne;

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

            //System.out.println(tv);
            FrmTelevizorOdgovor answerForm = new FrmTelevizorOdgovor(tv);
            answerForm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
