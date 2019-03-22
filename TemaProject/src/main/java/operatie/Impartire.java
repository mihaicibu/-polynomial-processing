package operatie;

import java.util.*;

import stocare.*;

public class Impartire implements Operatie{

	ArrayList <Polinom> listaPolinoame = new ArrayList<Polinom>();
	private Polinom restToShow;

	public Polinom getRestToShow() {
		return restToShow;
	}

	public List<Polinom> calculeaza(Polinom ... polinom) {
		for(Polinom pol : polinom) {
			listaPolinoame.add(pol);
		}
		
		int numberOfArguments = polinom.length;
		List<Monom> pol1 = listaPolinoame.get(0).mapToList();
		List<Monom> pol2 = listaPolinoame.get(1).mapToList();
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		Polinom transformareLista;
		
		if(numberOfArguments == 2) {
			if(pol2.isEmpty() != true) {
				while(Polinom.getGrad(pol1) >= Polinom.getGrad(pol2)) {
					Monom monom1 = pol1.get(0);
					Monom monom2 = pol2.get(0);
					Monom rezultat = monom1.imparteMonoame(monom2);
					cat.addMonom(rezultat);
					Polinom intermediar = listaPolinoame.get(1).inmultestePolinomCuMonom(rezultat);
					transformareLista = Polinom.listToPolinom(pol1);
					Operatie operatie = new Scadere();
					rest = operatie.calculeaza(transformareLista,intermediar).get(0);
					pol1= rest.mapToList();
				}
				
				List<Polinom> list= new ArrayList<Polinom>();
				list.add(cat);
				list.add(rest);
				return list;
			}
		}
		return null;
	}	
}
