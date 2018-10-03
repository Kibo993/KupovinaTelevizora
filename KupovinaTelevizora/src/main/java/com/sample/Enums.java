package com.sample;

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
		DVB_C,
		DVB_T2,
		DVB_S2,
		ANALOGNI
	};

	protected enum TipEkrana{
		LED,
		OLED,
		QLED
	};

	protected enum Internet{
		WIFI,
		BEZWIFIJA,
		NE
	};
}
