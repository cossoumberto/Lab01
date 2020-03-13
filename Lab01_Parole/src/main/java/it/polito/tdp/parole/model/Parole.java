package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List<String> parole;
	
	public Parole() {
		//parole = new ArrayList <String> (1);
		parole = new LinkedList <String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole, new ComparatoreParoleAlfabetico());
		return this.parole;
	}
	
	public void reset() {
		this.parole.clear();
	}
	
	public String toString() {
		
		String elencoS = "";
		
    	for(String s : this.getElenco()) {
    		elencoS += s;
    		if(this.getElenco().indexOf(s)<this.getElenco().size()-1)
    			elencoS += "\n";
    	}
    	return elencoS.trim();
	}
	
	public void cancellaParola(String p) {
		for(String s : parole)
			if(s.equals(p)) {
				this.parole.remove(s);
				return;
			}
	}

}
