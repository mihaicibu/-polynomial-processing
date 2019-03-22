package operatie;

import java.util.List;

import stocare.Polinom;

public interface Operatie {
	
	public List<Polinom> calculeaza(Polinom ... polnom1);
}
