package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
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
            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
