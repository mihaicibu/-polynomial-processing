package operatie;

import java.util.ArrayList;
import java.util.List;

import stocare.*;

public class Adunare implements Operatie {

	List <Polinom> listaPolinoame = new ArrayList<Polinom>();
	
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
				polinomRezultat.addMonom(monom1);
		
			List<Polinom> list= new ArrayList<Polinom>();
			list.add(polinomRezultat);
			return list;
			
		}
		return null;
	}	
}
