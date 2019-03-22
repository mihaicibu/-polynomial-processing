package operatie;

import java.util.ArrayList;
import java.util.List;

import stocare.*;

public class Derivare implements Operatie {

	ArrayList <Polinom> listaPolinoame = new ArrayList<Polinom>();
		
	public List<Polinom> calculeaza(Polinom ... polinom) {
		for(Polinom pol : polinom) {
			listaPolinoame.add(pol);
		}
		
		int numberOfArguments = polinom.length;
		Polinom polinomRezultat =  new Polinom();
		
		if(numberOfArguments == 1) {
			
			for(Monom monom : listaPolinoame.get(0).getPolinom().values()){
					polinomRezultat.addMonom(new Monom(monom.getCoeficient() * monom.getExponent(), monom.getExponent() - 1));
			}
			
			List<Polinom> list= new ArrayList<Polinom>();
			list.add(polinomRezultat);
			return list;
			}
		return null;
	}	
}