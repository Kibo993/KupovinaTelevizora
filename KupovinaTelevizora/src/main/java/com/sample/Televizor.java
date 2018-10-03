package com.sample;

import com.sample.Enums.*;

public class Televizor {
	
	
	private int cena;
	private NacinPrijema nacinPrijema;
	private PrijemKablovska prijemKablovska;
	private PrijemSatelitska prijemSatelitska;
	private MestoStanovanja mestoStanovanja;
	private Boolean SekundarniPrijem;
	private Boolean NoveMogucnosti;
	private Internet internet;
	private Pozicija pozicija;
	private Double udaljenostOdTV;
	private String dodatniUredjaji;
	private String neklasicanSadrzaj;
	
	private Tuner tuner;
	private Double dijagonala;
	private TipEkrana tipEkrana;
	private Boolean smart;
	private int brojPortova;
	
	
	public Televizor() {
		super();
	}
	//NAMESTI KONSTRUKTOR DA IMA SVA POLJA
	public Televizor(Tuner tuner, Double dijagonala, TipEkrana tipEkrana,
			int cena, Boolean smart, Internet internet, int brojPortova,
			String dodatniUredjaji) {
		super();
		this.tuner = tuner;
		this.dijagonala = dijagonala;
		this.tipEkrana = tipEkrana;
		this.cena = cena;
		this.smart = smart;
		this.internet = internet;
		this.brojPortova = brojPortova;
		this.dodatniUredjaji = dodatniUredjaji;
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

	public String getDodatniUredjaji() {
		return dodatniUredjaji;
	}

	public void setDodatniUredjaji(String dodatniUredjaji) {
		this.dodatniUredjaji = dodatniUredjaji;
	}

	@Override
	public String toString() {
		return "Televizor [tuner=" + tuner + ", dijagonala=" + dijagonala
				+ ", tipEkrana=" + tipEkrana + ", cena=" + cena + ", smart="
				+ smart + ", internet=" + internet + ", brojPortova="
				+ brojPortova + ", dodatneFunkcionalnosti="
				+ dodatniUredjaji + "]";
	}

	public NacinPrijema getNacinPrijema() {
		return nacinPrijema;
	}

	public void setNacinPrijema(NacinPrijema nacinPrijema) {
		this.nacinPrijema = nacinPrijema;
	}
	public PrijemKablovska getPrijemKablovska() {
		return prijemKablovska;
	}
	public void setPrijemKablovska(PrijemKablovska prijemKablovska) {
		this.prijemKablovska = prijemKablovska;
	}
	public Boolean getSekundarniPrijem() {
		return SekundarniPrijem;
	}
	public void setSekundarniPrijem(Boolean sekundarniPrijem) {
		SekundarniPrijem = sekundarniPrijem;
	}
	public Boolean getNoveMogucnosti() {
		return NoveMogucnosti;
	}
	public void setNoveMogucnosti(Boolean noveMogucnosti) {
		NoveMogucnosti = noveMogucnosti;
	}
	public Pozicija getPozicija() {
		return pozicija;
	}
	public void setPozicija(Pozicija pozicija) {
		this.pozicija = pozicija;
	}
	public Double getUdaljenostOdTV() {
		return udaljenostOdTV;
	}
	public void setUdaljenostOdTV(Double udaljenostOdTV) {
		this.udaljenostOdTV = udaljenostOdTV;
	}
	public PrijemSatelitska getPrijemSatelitska() {
		return prijemSatelitska;
	}
	public void setPrijemSatelitska(PrijemSatelitska prijemSatelitska) {
		this.prijemSatelitska = prijemSatelitska;
	}
	public MestoStanovanja getMestoStanovanja() {
		return mestoStanovanja;
	}
	public void setMestoStanovanja(MestoStanovanja mestoStanovanja) {
		this.mestoStanovanja = mestoStanovanja;
	}
	public String getNeklasicanSadrzaj() {
		return neklasicanSadrzaj;
	}
	public void setNeklasicanSadrzaj(String neklasicanSadrzaj) {
		this.neklasicanSadrzaj = neklasicanSadrzaj;
	}

}
