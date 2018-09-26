package com.sample;

enum NacinPrijema{
	KABLOVSKA,
	SATELITSKA,
	ZEMALJSKA,
	NEPRATIKLASICAN
};

enum Tuner{
	DVB_C,
	DVB_T2,
	DVB_S2
};

enum TipEkrana{
	LED,
	OLED,
	QLED
};

enum Internet{
	WIFI,
	BEZWIFIJA,
	NE
};

public class Televizor {
	
	
	private int cena;
	private NacinPrijema nacinPrijema;
	private Internet internet;
	
	private Tuner tuner;
	private Double dijagonala;
	private TipEkrana tipEkrana;
	private Boolean smart;
	private int brojPortova;
	private String dodatneFunkcionalnosti;
	
	public Televizor() {
		super();
	}
	//NAMESTI KONSTRUKTOR DA IMA SVA POLJA
	public Televizor(Tuner tuner, Double dijagonala, TipEkrana tipEkrana,
			int cena, Boolean smart, Internet internet, int brojPortova,
			String dodatneFunkcionalnosti) {
		super();
		this.tuner = tuner;
		this.dijagonala = dijagonala;
		this.tipEkrana = tipEkrana;
		this.cena = cena;
		this.smart = smart;
		this.internet = internet;
		this.brojPortova = brojPortova;
		this.dodatneFunkcionalnosti = dodatneFunkcionalnosti;
	}

	public Tuner getTuner() {
		return tuner;
	}

	public void setTuner(Tuner tuner) {
		this.tuner = tuner;
	}

	public Double getDijagonala() {
		return dijagonala;
	}

	public void setDijagonala(Double dijagonala) {
		this.dijagonala = dijagonala;
	}

	public TipEkrana getTipEkrana() {
		return tipEkrana;
	}

	public void setTipEkrana(TipEkrana tipEkrana) {
		this.tipEkrana = tipEkrana;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Boolean getSmart() {
		return smart;
	}

	public void setSmart(Boolean smart) {
		this.smart = smart;
	}

	public Internet getInternet() {
		return internet;
	}

	public void setInternet(Internet internet) {
		this.internet = internet;
	}

	public int getBrojPortova() {
		return brojPortova;
	}

	public void setBrojPortova(int brojPortova) {
		this.brojPortova = brojPortova;
	}

	public String getDodatneFunkcionalnosti() {
		return dodatneFunkcionalnosti;
	}

	public void setDodatneFunkcionalnosti(String dodatneFunkcionalnosti) {
		this.dodatneFunkcionalnosti = dodatneFunkcionalnosti;
	}

	@Override
	public String toString() {
		return "Televizor [tuner=" + tuner + ", dijagonala=" + dijagonala
				+ ", tipEkrana=" + tipEkrana + ", cena=" + cena + ", smart="
				+ smart + ", internet=" + internet + ", brojPortova="
				+ brojPortova + ", dodatneFunkcionalnosti="
				+ dodatneFunkcionalnosti + "]";
	}

	public NacinPrijema getNacinPrijema() {
		return nacinPrijema;
	}

	public void setNacinPrijema(NacinPrijema nacinPrijema) {
		this.nacinPrijema = nacinPrijema;
	}

}
