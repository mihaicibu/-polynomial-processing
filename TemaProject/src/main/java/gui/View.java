package gui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	
	private JTextField userInputPolinom1 = new JTextField(15);
	private JLabel labelPolinom1 = new JLabel("Introduceti primul polinom:");
	private JTextField userInputPolinom2 = new JTextField(15);
	private JLabel labelPolinom2 = new JLabel("Introduceti al doilea polinom:");
	private JLabel labelRezultat = new JLabel("Rezultat:");
	private JTextField labelAfisareRezultat = new JTextField(15);
	private JButton butonAdunare = new JButton("Adunare");
	private JButton butonScadere = new JButton("Scadere");
	private JButton butonInmultire = new JButton("Inmultire");
	private JButton butonImpartire = new JButton("Impartire");
	private JButton butonDerivare = new JButton("Derivare");
	private JButton butonIntegrare = new JButton("Integrare");
	

	
	public View(){
		this.setSize(500, 430);
		this.setLocation(300, 300); 
		
		labelAfisareRezultat.setEditable(false);
		
		JPanel content = new JPanel();
		JPanel content1 = new JPanel();
		JPanel content3 = new JPanel();
		
		content.setLayout(new BoxLayout(content,BoxLayout.X_AXIS));
		
		content1.setLayout(new BoxLayout(content1,BoxLayout.Y_AXIS));
		content3.setLayout(new BoxLayout(content3,BoxLayout.Y_AXIS));
		
		content1.add( Box.createRigidArea(new Dimension(0,20)));
		content1.add(labelPolinom1);
		content1.add(userInputPolinom1);
		
		content1.add( Box.createRigidArea(new Dimension(0,20)));
		content1.add(labelPolinom2);
		content1.add(userInputPolinom2);
		
		content1.add( Box.createRigidArea(new Dimension(0,20)));
		content1.add(labelRezultat);
		content1.add(labelAfisareRezultat);
		content1.add( Box.createRigidArea(new Dimension(0,20)));
		
		content3.add(butonAdunare);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		content3.add(butonScadere);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		content3.add(butonInmultire);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		content3.add(butonImpartire);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		content3.add(butonDerivare);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		content3.add(butonIntegrare);
		content3.add( Box.createRigidArea(new Dimension(0,20)));
		
		content.add( Box.createRigidArea(new Dimension(20,0)));
		content.add(content1);
		content.add( Box.createRigidArea(new Dimension(20,0)));
		content.add(content3);
		content.add( Box.createRigidArea(new Dimension(20,0)));
		
		this.setContentPane(content);
		
		this.setTitle("Calculator de polinoame");
      
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public String getPolinom1() {
		return userInputPolinom1.getText();
	}
	
	public String getPolinom2() {
		return userInputPolinom2.getText();
	}
	
	public void setResult(String text) {
		labelAfisareRezultat.setText(text);
	}
	
	public void addAdunareListener(ActionListener adunare) {
		butonAdunare.addActionListener(adunare);
	}
	
	public void addScadereListener(ActionListener scadere) {
		butonScadere.addActionListener(scadere);
	}
	
	public void addInmultireListener(ActionListener inmultire) {
		butonInmultire.addActionListener(inmultire);
	}
	
	public void addImpartireListener(ActionListener impartire) {
		butonImpartire.addActionListener(impartire);
	}
	
	public void addDerivareListener(ActionListener derivare) {
		butonDerivare.addActionListener(derivare);
	}
	
	public void addIntegrareListener(ActionListener integrare) {
		butonIntegrare.addActionListener(integrare);
	}
	
	public void showError(String string) {
		labelAfisareRezultat.setText(string);
	}

}
