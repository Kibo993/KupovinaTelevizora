package com.televizor;

import com.televizor.Enums.*;

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
	
	private String ime;
	private Tuner tuner;
	private int dijagonala;
	private TipEkrana tipEkrana;
	private Smart smart;
	private int brojPortova;
	private Rezolucija rezolucija;
	private String komentar = "";
	
	
	public Televizor() {
		super();
	}

	public Televizor(int cena, NacinPrijema nacinPrijema,
			PrijemKablovska prijemKablovska, PrijemSatelitska prijemSatelitska,
			MestoStanovanja mestoStanovanja, Boolean sekundarniPrijem,
			Boolean noveMogucnosti, Internet internet, Pozicija pozicija,
			Double udaljenostOdTV, String dodatniUredjaji,
			String neklasicanSadrzaj, Tuner tuner, int dijagonala,
			TipEkrana tipEkrana, Smart smart, int brojPortova,
			Rezolucija rezolucija, String komentar) {
		super();
		this.cena = cena;
		this.nacinPrijema = nacinPrijema;
		this.prijemKablovska = prijemKablovska;
		this.prijemSatelitska = prijemSatelitska;
		this.mestoStanovanja = mestoStanovanja;
		SekundarniPrijem = sekundarniPrijem;
		NoveMogucnosti = noveMogucnosti;
		this.internet = internet;
		this.pozicija = pozicija;
		this.udaljenostOdTV = udaljenostOdTV;
		this.dodatniUredjaji = dodatniUredjaji;
		this.neklasicanSadrzaj = neklasicanSadrzaj;
		this.tuner = tuner;
		this.dijagonala = dijagonala;
		this.tipEkrana = tipEkrana;
		this.smart = smart;
		this.brojPortova = brojPortova;
		this.rezolucija = rezolucija;
		this.komentar = komentar;
	}


	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Tuner getTuner() {
		return tuner;
	}

	public void setTuner(Tuner tuner) {
		this.tuner = tuner;
	}

	public int getDijagonala() {
		return dijagonala;
	}

	public void setDijagonala(int dijagonala) {
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

	public Smart getSmart() {
		return smart;
	}

	public void setSmart(Smart smart) {
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
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public Rezolucija getRezolucija() {
		return rezolucija;
	}
	public void setRezolucija(Rezolucija rezolucija) {
		this.rezolucija = rezolucija;
	}
	@Override
	public String toString() {
		return "Maksimalna cena: " + cena + ",\n nacinPrijema=" + nacinPrijema
				+ ",\n prijemKablovska=" + prijemKablovska
				+ ",\n prijemSatelitska=" + prijemSatelitska
				+ ",\n mestoStanovanja=" + mestoStanovanja
				+ ",\n SekundarniPrijem=" + SekundarniPrijem
				+ ",\n NoveMogucnosti=" + NoveMogucnosti + ",\n internet="
				+ internet + ",\n pozicija=" + pozicija + ",\n udaljenostOdTV="
				+ udaljenostOdTV + ",\n dodatniUredjaji=" + dodatniUredjaji
				+ ",\n neklasicanSadrzaj=" + neklasicanSadrzaj + ",\n tuner="
				+ tuner + ",\n dijagonala=" + dijagonala + ",\n tipEkrana="
				+ tipEkrana + ",\n smart=" + smart + ",\n brojPortova="
				+ brojPortova + ",\n rezolucija="
				+ rezolucija + ",\n komentar=" + komentar + "]";
	}
	
	public String ispisNaFormi() {
		return "Maksimalna cena: " + cena + " RSD\nMoguænost prijema interneta: "
				+ internet.getValue() + "\nTjuner: "
				+ tuner.getValue() + "\nDijagonala: " + dijagonala + "\"\nTip Ekrana: "
				+ tipEkrana + "\nSmart televizor: " + smart.getValue() + "\nMinimalni broj portova: "
				+ brojPortova + "\nRezolucija slike: "
				+ rezolucija.getValue();
	}
	
	public String ispisKomentara() {
		return komentar;
	}
	
	public String ispisOdabranogTelevizora() {
		return "Model televizora: "+ ime +"\nCena: " + cena + " RSD\nMoguænost prijema interneta: "
				+ internet.getValue() + "\nTjuner: "
				+ tuner.getValue() + "\nDijagonala: " + dijagonala + "\"\nTip Ekrana: "
				+ tipEkrana + "\nSmart televizor: " + smart.getValue() + "\nBroj portova: "
				+ brojPortova + "\nRezolucija slike: "
				+ rezolucija.getValue();
	}


}
