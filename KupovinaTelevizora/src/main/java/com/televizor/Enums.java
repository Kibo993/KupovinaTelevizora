package com.televizor;

public class Enums {
	protected enum NacinPrijema{
		KABLOVSKA,
		SATELITSKA,
		ZEMALJSKA,
		NEPRATIKLASICAN
	};

	protected enum PrijemKablovska{
		ANALOGNA,
		SETTOPBOX,
		CAMMODUL
	};
	
	protected enum PrijemSatelitska{
		PROVAJDER,
		SLOBODNO
	};
	
	protected enum MestoStanovanja{
		GRADSKO,
		PRIGRADSKO,
		SEOSKO
	};

	protected enum Pozicija{
		NASPRAM,
		ISPRED,
		PORED
	};

	protected enum Tuner{
		DVB_C("DVB C"),
		DVB_T2("DVB T2"),
		DVB_S2("DVB S2"),
		DVB_T2_S2("DVB T2/S2"),
		DVB_T2_C("DVB T2/C"),
		DVB_T2_C_S2("DVB T2/C/S2"),
		ANALOGNI("Analogni");
		private final String tuner;

	    private Tuner(String value) {
	        tuner = value;
	    }

	    public String getValue() {
	        return tuner;
	    }
	};


	protected enum TipEkrana{
		LED,
		OLED,
		QLED
	};
	
	protected enum Rezolucija{
		HD("HDReady"),
		FULLHD("Full HD"),
		UHD("Ultra HD");
		private final String rezolucija;

	    private Rezolucija(String value) {
	    	rezolucija = value;
	    }

	    public String getValue() {
	        return rezolucija;
	    }
	};

	protected enum Internet{
		WIFI("Da - sa WiFi-jem"),
		BEZWIFIJA("Da - bez WiFi-ja"),
		NE("Ne");
		private final String internet;

	    private Internet(String value) {
	    	internet = value;
	    }

	    public String getValue() {
	        return internet;
	    }
	};
	
	protected enum Smart{
		SMART("Da - Smart"),
		SEMISMART("Da - Semi-Smart"),
		NE("Ne");
		private final String smart;

	    private Smart(String value) {
	    	smart = value;
	    }

	    public String getValue() {
	        return smart;
	    }
	};
}
