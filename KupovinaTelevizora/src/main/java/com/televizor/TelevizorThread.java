package com.televizor;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class TelevizorThread  extends Thread{
	
	Boolean pokrenuta=false;
	
@Override
	public void run() {
		if(pokrenuta){
			try {
				pokrenuta = false;
				// load up the knowledge base
				KieServices ks = KieServices.Factory.get();
				KieContainer kContainer = ks.getKieClasspathContainer();
				KieSession kSession = kContainer.newKieSession("ksession-rules");

				Televizor tv = new Televizor();
				FrmKupovinaTelevizora form = new FrmKupovinaTelevizora(tv);
				form.setVisible(true);
				while(form.isVisible()){
					System.out.print("");
				}
				if(!form.isClosed()){
					kSession.insert(tv);
					kSession.fireAllRules();
					FrmTelevizorOdgovor answerForm = new FrmTelevizorOdgovor(tv);
					answerForm.setVisible(true);
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

public void pokreni(){
	pokrenuta = true;
}
}
