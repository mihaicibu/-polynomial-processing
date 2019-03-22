package operatie;

import java.util.ArrayList;
import java.util.List;

import stocare.*;

public class Scadere implements Operatie {

	ArrayList <Polinom> listaPolinoame = new ArrayList<Polinom>();
	
	public List<Polinom> calculeaza(Polinom ... polinom) {
		for(Polinom pol : polinom) {
			listaPolinoame.add(pol);
		}
		int numberOfArguments = polinom.length;
		Polinom polinomRezultat =  new Polinom();
		
		if(numberOfArguments == 2) {
			for(Monom monom : listaPolinoame.get(0).getPolinom().values()) {
				polinomRezultat.addMonom(monom);
				}
			for(Monom monom1 : listaPolinoame.get(1).getPolinom().values())
				polinomRezultat.addMonom(new Monom(-monom1.getCoeficient(), monom1.getExponent()));
		
			List<Polinom> list= new ArrayList<Polinom>();
			list.add(polinomRezultat);
			return list;
		}
		return null;
	}	
}
