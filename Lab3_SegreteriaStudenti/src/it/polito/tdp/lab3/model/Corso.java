package it.polito.tdp.lab3.model;

public class Corso {

	private String codiceCorso;
	private int crediti;
	private String nomeCorso;
	private String pD;
	
	public Corso(String codiceCorso, int crediti, String nomeCorso, String pD) {

		this.codiceCorso = codiceCorso;
		this.crediti = crediti;
		this.nomeCorso = nomeCorso;
		this.pD = pD;
	}

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public int getCrediti() {
		return crediti;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public String getpD() {
		return pD;
	}

	@Override
	public String toString() {
		return codiceCorso+" "+crediti+" "+nomeCorso+" pd:"+pD;
	}
	
	
}
