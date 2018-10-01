package com.sample;

public class Enums {
	public enum NacinPrijema{
		KABLOVSKA,
		SATELITSKA,
		ZEMALJSKA,
		NEPRATIKLASICAN
	};

	public enum NacinPrijemaKablovska{
		ANALOGNA,
		SETTOPBOX,
		CAMMODUL
	};

	public enum Pozicija{
		NASPRAM,
		ISPRED,
		PORED
	};

	public enum Tuner{
		DVB_C,
		DVB_T2,
		DVB_S2
	};

	public enum TipEkrana{
		LED,
		OLED,
		QLED
	};

	public enum Internet{
		WIFI,
		BEZWIFIJA,
		NE
	};
}
