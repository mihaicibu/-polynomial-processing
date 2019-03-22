package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gui.View;
import stocare.Polinom;
import operatie.Adunare;
import operatie.Derivare;
import operatie.Impartire;
import operatie.Inmultire;
import operatie.Integrare;
import operatie.Operatie;
import operatie.Scadere;

public class ControllerCalcPolinoame {
	private Polinom polinomModel;
	private View view;
	
	public ControllerCalcPolinoame(Polinom polinom , View view) {
		this.polinomModel = polinom;
		this.view = view;
		this.view.setResult("0.0");
		view.addAdunareListener(new AdunareButton());
		view.addScadereListener(new ScadereButton());
		view.addInmultireListener(new InmultireButton());
		view.addImpartireListener(new ImpartireButton());
		view.addDerivareListener(new DerivareButton());
		view.addIntegrareListener(new IntegrareButton());
	}
	
	class AdunareButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			String userInputPolinom2 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				userInputPolinom2 = view.getPolinom2();
				
				if(userInputPolinom1.equals("")  || userInputPolinom2.equals("")) {
				
					view.setResult("Introduceti date in ambele campuri!");
				}
				else {
					Polinom polinom1 = new Polinom();
					boolean bol = polinom1.parsare(userInputPolinom1);
					polinom1.mapToList();
					
					Polinom polinom2 = new Polinom();
					boolean bol2 =polinom2.parsare(userInputPolinom2);
					
					if(bol && bol2) {
						Operatie adunare = new Adunare();
						
						polinomModel = adunare.calculeaza(polinom1, polinom2).get(0);
						
						view.setResult(polinomModel.toString());
					}
					else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
	
	class ScadereButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			String userInputPolinom2 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				userInputPolinom2 = view.getPolinom2();
				
				if(userInputPolinom1.equals("")  || userInputPolinom2.equals("")) {
					
					view.setResult("Introduceti date in ambele campuri!");
				}
				else {
				
				Polinom polinom1 = new Polinom();
				boolean bol = polinom1.parsare(userInputPolinom1);
				
				Polinom polinom2 = new Polinom();
				boolean bol2 = polinom2.parsare(userInputPolinom2);
				if(bol &&bol2) {
					Operatie scadere = new Scadere();
					
					polinomModel = scadere.calculeaza(polinom1, polinom2).get(0);
					
					view.setResult(polinomModel.toString());
					}
				else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
	
	class InmultireButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			String userInputPolinom2 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				userInputPolinom2 = view.getPolinom2();
				
				if(userInputPolinom1.equals("")  || userInputPolinom2.equals("")) {
					
					view.setResult("Introduceti date in ambele campuri!");
				}
				else {
				
				Polinom polinom1 = new Polinom();
				boolean bol = polinom1.parsare(userInputPolinom1);
				
				Polinom polinom2 = new Polinom();
				boolean bol2 = polinom2.parsare(userInputPolinom2);
				if(bol && bol2) {
					Operatie inmultire = new Inmultire();
					
					polinomModel = inmultire.calculeaza(polinom1, polinom2).get(0);
					
					view.setResult(polinomModel.toString());
					}
				else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
	
	class ImpartireButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			String userInputPolinom2 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				userInputPolinom2 = view.getPolinom2();
				
				if(userInputPolinom1.equals("")  || userInputPolinom2.equals("")) {
					
					view.setResult("Introduceti date in ambele campuri!");
				}
				else {
				
				Polinom polinom1 = new Polinom();
				boolean bol = polinom1.parsare(userInputPolinom1);
				
				Polinom polinom2 = new Polinom();
				boolean bol2 = polinom2.parsare(userInputPolinom2);
				
				if(bol && bol2) {
					Operatie impartire = new Impartire();
					
					List<Polinom> list = impartire.calculeaza(polinom1, polinom2);
					
					if(list != null) {
						polinomModel = list.get(0);
						Polinom rest = list.get(1);
						
						view.setResult("Cat: " + polinomModel.toString() + " Rest: " + rest.toString());
					}
					else 
						view.setResult("Impartire la 0!!!");
					}
				else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
	
	class DerivareButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				
				if(userInputPolinom1.equals("")) {
					
					view.setResult("Introduceti date in primul camp pentru derivare!");
				}
				else {
				Polinom polinom1 = new Polinom();
				boolean bol = polinom1.parsare(userInputPolinom1);
				if(bol) {
					Operatie derivare = new Derivare();
					
					polinomModel = derivare.calculeaza(polinom1).get(0);
					
					view.setResult(polinomModel.toString());
					}
				else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
	
	class IntegrareButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String userInputPolinom1 = "";
			try {
				userInputPolinom1 = view.getPolinom1();
				
				if(userInputPolinom1.equals("")) {
					view.setResult("Introduceti date in primul camp pentru integrare!");
				}
				else {
				Polinom polinom1 = new Polinom();
				boolean bol = polinom1.parsare(userInputPolinom1);
				if(bol) {
					Operatie integrare = new Integrare();
					
					polinomModel = integrare.calculeaza(polinom1).get(0);
					
					view.setResult(polinomModel.toString());
					}
				else view.setResult("Bad Input");
				}
			} catch(NumberFormatException nfex) {
				view.showError("Bad input: '" + userInputPolinom1 + "'");
			}
			
		}
	}
}
