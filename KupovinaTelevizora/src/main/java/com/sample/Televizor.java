package com.sample;

public class Televizor {

	private enum TipEkrana{
		LED,
		OLED,
		QLED
	};
	
	private enum Internet{
		WiFi,
		BezWiFijaTEST,
		Ne
	};
	
	private String tuner;
	private Double dijagonala;
	private TipEkrana tipEkrana;
	private Double cena;
	private Boolean smart;
	private Internet internet;
	private int brojPortova;
	private String dodatneFunkcionalnosti;
	
	public Televizor() {
		super();
	}

	public Televizor(String tuner, Double dijagonala, TipEkrana tipEkrana,
			Double cena, Boolean smart, Internet internet, int brojPortova,
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

	public String getTuner() {
		return tuner;
	}

	public void setTuner(String tuner) {
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

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
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

}
