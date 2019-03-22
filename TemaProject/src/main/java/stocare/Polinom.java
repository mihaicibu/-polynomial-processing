package stocare;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import operatie.Inmultire;
import operatie.Operatie;

public class Polinom {
	private Map<Integer, Monom> polinom = new HashMap<Integer, Monom>(); 
	
	public Polinom() {
	}
	
	public Map<Integer, Monom> getPolinom() {
		return polinom;
	}

	public void setPolinom(Map<Integer, Monom> polinom) {
		this.polinom = polinom;
	}

	public boolean parsare(String polinomString) {
		if(this.verificaPolinomCitit(polinomString)) {
			String[] splitArray = polinomString.split("(?=[+-])");
			String[] monom;
			for(String iterare : splitArray) {
				String adaugaPlus = this.adaugaPlus(iterare);
				String replace = this.replaceCharacters(adaugaPlus);
				monom = replace.split("x\\^");
				if(monom.length > 1) {
					Monom m = new Monom(Float.parseFloat(monom[0]), Integer.parseInt(monom[1]));
					this.addMonom(m);
				}
			}
		}
		else {
			return false;
		}
		return true;
	}
	
	public String replaceCharacters(String polinom) {
		boolean caractereOk = true;
		
		String replaceString = polinom.replace(" ", "");
		replaceString = replaceString.replace("+x", "+1x");
		replaceString = replaceString.replace("-x", "-1x");
		replaceString = this.adaugaExponent1(replaceString);
		
		for(char caracter : replaceString.toCharArray())
			if(caracter < '0' || caracter > '9') 
				if(caracter != '+' && caracter != '-')
					caractereOk = false;
		if(caractereOk) replaceString = replaceString.replace(replaceString, replaceString + "x^0"); 
		return replaceString;
	}
	
	public String adaugaPlus(String text) {
		String newString = text;
			if(text.charAt(0) != '-' && text.charAt(0) != '+' ) 
				newString = "+" + text;
		return newString;
	}
	
	public String adaugaExponent1(String text){
		String newString = text;
		if(text.charAt(text.length() - 1) == 'x')
			newString = text + "^1";
		return newString;
	}
	
	public boolean verificaPolinomCitit(String polinomIntrodus) {
		boolean dateOk = true;
		for(char caracter : polinomIntrodus.toCharArray()) {
			if(caracter < '0' || caracter > '9')
				if(caracter != '+' && caracter != '-' && caracter != '^' && caracter != 'x' && caracter != '.')
					dateOk = false;
		}
		return dateOk;
	}
	
	public void addMonom(Monom m) {
		if(polinom.containsKey(m.getExponent())) {
			Monom nou = new Monom(this.getPolinom().get(m.getExponent()).getCoeficient() + m.getCoeficient() ,m.getExponent());
			polinom.put( m.getExponent(), nou);
		}
		else {
			polinom.put( m.getExponent(), m);
		}
	}
	
	public List<Monom> mapToList() {
		List<Monom> polinom  = new ArrayList<Monom>();
		for(Monom iter : this.getPolinom().values())
			if(iter.getCoeficient() != 0)
				polinom.add(iter);
		Collections.sort(polinom);
		return polinom;
	}
	
	public static Polinom listToPolinom(List<Monom> list) {
		Polinom pol = new Polinom();
		for(Monom iter : list )
			if(iter.getCoeficient() != 0)
				pol.addMonom(iter);
		return pol;
	}
	
	public static int getGrad(List<Monom> list) {
		int ordin = -1;
		for(Monom iter : list) {
			if (iter.getExponent() > ordin && iter.getCoeficient() != 0)
				ordin = iter.getExponent();	
		}
		return ordin;
	}
	
	public Polinom inmultestePolinomCuMonom(Monom monom) {
		Polinom polinom = new Polinom();
		polinom.addMonom(monom);
		Operatie op = new Inmultire();
		polinom = op.calculeaza(this, polinom).get(0);
		return polinom;
	}
	
	public String toString() {
		String polinomRezultat = "0.0";
		String polinomRez = "";
		int check = 0;
		List<Monom> polinom = this.mapToList();
		for(Monom entry : polinom) {
			polinomRez += entry.toString();
			check = 1;
		}
		if (check == 1 )
			return polinomRez;
		return polinomRezultat;
	}
	
 }

