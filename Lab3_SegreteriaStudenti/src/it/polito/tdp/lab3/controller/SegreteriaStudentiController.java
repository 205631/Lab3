package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.SegreteriaStudentiModel;
import it.polito.tdp.lab3.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private SegreteriaStudentiModel model;
	
	
    public void setModel(SegreteriaStudentiModel model) {
		this.model = model;
		
		cmbCorso.getItems().addAll(model.popolaTendina());
		
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmbCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btmSpunta;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btmCerca;

    @FXML
    private Button btmIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btmReset;

    @FXML
    void doCerca(ActionEvent event) {
    	//metodo per ricerca studenti iscritti ad un corso
    	//controllo che il campo matricola sia vuoto e che ci sia un corso scelto
    	Corso c=cmbCorso.getValue();
    	
    	if(c!=null && txtMatricola.getText().compareTo("")==0){
    		List<Studente> l=model.listaStudentiIscritti(c);
    		if(l==null){
    			txtResult.setText("Nessuno studente iscritto al corso");
    			return;
    		}
    		String st="";
    		for(Studente s:l){
    			st+=s.toString()+"\n";
    		}
    		txtResult.setText(st);
    		return;
    	}
    	//implemento metodo di ricerca dei corsi frequentati da uno studente
    	//controllo matricola se presente nel db e che il corso non sia selezionato
    	//e stampo la lista di corsi frequentati
    	String matr=txtMatricola.getText();
    	
    	if(c==null && matr.compareTo("")!=0){
    		Studente s=model.cercaStudente(matr);
    		if(s==null){
    			txtResult.setText("Studente inesistente");
    			return;
    		}else{
    			//chiamo funzione model per stampare lista corsi frequentati dallo studente
    			List<Corso> l=model.listaCorsiFrequentati(s);
        		if(l==null){
        			txtResult.setText("Nessun corso frequentato dallo studente");
        			return;
        		}
        		String st="";
        		for(Corso cc:l){
        			st+=cc.toString()+"\n";
        		}
        		txtResult.setText(st);
        		return;
    			
    		}
    	}else{
    		// implementare punto 2.5 dato matricola e corso verificare se lo studente frequentq
    		//il corso e stampare un messaggio
    		
    		//1) controllare se esiste lo studente
    		Studente s=model.cercaStudente(matr);
    		
    		if(s==null){
    			txtResult.setText("Studente inesistente");
    			return;
    		}else{
        		//2)controllare se frequenta il corso tramite metodo del model
    			if(model.frequentaCorso(s, c)==true){
    				txtResult.setText(s.getNome()+" "+s.getCognome()+" ("+s.getMatricola()+") "+"e' iscritto al corso \""+c.getNomeCorso()+"\"");
    				return;
    			}else{
    				txtResult.setText(s.getNome()+" "+s.getCognome()+" ("+s.getMatricola()+") "+"non e' iscritto al corso \""+c.getNomeCorso()+"\"");
    				return;
    			}
    		}
    	}
    	
    	
    }

    @FXML
    void doCompletamentoAuto(ActionEvent event) {
    	//preme la spunta
    	String s=txtMatricola.getText();
    	
    	if(s.compareTo("")==0){
    		txtResult.setText("ERRORE: Campo matricola vuoto");
    		return;
    	}else{
    		Studente st=model.cercaStudente(s);
    		if(st==null){
    			txtResult.setText("Studente assente");
    			return;
    		}
    		txtNome.setText(st.getNome());
    		txtCognome.setText(st.getCognome());
    	}
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	cmbCorso.setValue(null);
    	txtMatricola.setText("");
    	txtNome.setText("");
    	txtCognome.setText("");
    	txtResult.setText("");
    	btmSpunta.setDisable(false);
    }

    @FXML
    void initialize() {
        assert cmbCorso != null : "fx:id=\"cmbCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btmSpunta != null : "fx:id=\"btmSpunta\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btmCerca != null : "fx:id=\"btmCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btmIscrivi != null : "fx:id=\"btmIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btmReset != null : "fx:id=\"btmReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

    }
}
