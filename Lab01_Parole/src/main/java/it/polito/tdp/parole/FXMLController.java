package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	int tentativi = 0;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;
    
    @FXML
    void doCancella(ActionEvent event) {
    	String daCancellare = txtResult.getSelectedText();
    	elenco.cancellaParola(daCancellare);
    	txtResult.setText(elenco.toString());
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String parola = txtParola.getText().trim();
    	tentativi++;
    	
    	if(parola.length()==0) {
    		if(tentativi == 1)
    			txtResult.appendText("DEVI INSERIRE UNA PAROLA");
    		else
    			txtResult.appendText("\nDEVI INSERIRE UNA PAROLA");
    		txtParola.clear();
    		return;
    	}
   
    	for(int i=0; i<parola.length(); i++) 
    		if(Character.isLetter(parola.charAt(i)) == false) {
    			if(tentativi == 1)
        			txtResult.appendText("LA PAROLA DEVE CONTENERE SOLO LETTERE");
        		else
        			txtResult.appendText("\nLA PAROLA DEVE CONTENERE SOLO LETTERE");
        		txtParola.clear();
        		
        		return;
    		}
    	
    	elenco.addParola(parola);
    	txtResult.setText(elenco.toString());
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtParola.clear();
    	txtResult.clear();
    	tentativi = 0;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
