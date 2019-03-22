package PT2019.tema.TemaProject;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Map;

import org.junit.Test;

import stocare.*;
import operatie.*;


public class AppTest {
	
	@Test
	public void testParsare() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("5x^2-7x+3");
		assertEquals(polinom.toString(),"+5,00x^2-7,00x+3,00");
	}
	
	@Test
	public void testParsareFalse() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("5x^2-7x+3");
		Map<Integer, Monom> polinomTest =  polinom.getPolinom();
		assertNotEquals(polinomTest.toString(),"5x^2-7x+3");
	}
	
	@Test
	public void testAdunare() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("5x^2-7x+3");
		polinom1.parsare("5x^2-7x+3");
		Operatie op = new Adunare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertEquals(p.toString(),"+10,00x^2-14,00x+6,00");
	}
	
	@Test
	public void testAdunareFals() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("5x^2-7x+3");
		polinom1.parsare("5x^3-7x+3");
		Operatie op = new Adunare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertNotEquals(p.toString(),"5.0x^2-14.0x+6.0");
	}
	
	@Test
	public void testScadere() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("3x^2-7x+3");
		polinom1.parsare("12x^4-2x+7");
		Operatie op = new Scadere();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		System.out.println();
		assertEquals(p.toString(),"-12,00x^4+3,00x^2-5,00x-4,00");
	}
	
	@Test
	public void testScadereFals() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("3x^2-7x+3");
		polinom1.parsare("12x^4-2x+7");
		Operatie op = new Scadere();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertNotEquals(p.toString(),"4.0x^3+12.0x-4.0");
	}
	
	@Test
	public void testInmultire() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("x^2+x");
		polinom1.parsare("12x");
		Operatie op = new Inmultire();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertEquals(p.toString(),"+12,00x^3+12,00x^2");
	}
	
	@Test
	public void testInmultireFals() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("2x^2-3x+1");
		polinom1.parsare("x");
		Operatie op = new Inmultire();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertNotEquals(p.toString(),"2.0x^3-3.0x+1.0");
	}
	
	@Test
	public void testImpartire() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("x^2+x");
		polinom1.parsare("x");
		Operatie op = new Impartire();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertEquals(p.toString(),"+x+1");
	}
	
	@Test
	public void testImpartireFals() {
		Polinom polinom = new Polinom();
		Polinom polinom1= new Polinom();
		polinom.parsare("x^2+4x+4");
		polinom1.parsare("x+2");
		Operatie op = new Impartire();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom, polinom1).get(0);
		assertNotEquals(p.toString(),"+2.0x+1");
	}
	
	@Test
	public void testDerivare() {
		Polinom polinom = new Polinom();
		polinom.parsare("-7x^4+2x^3-1");
		Operatie op = new Derivare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom).get(0);
		assertEquals(p.toString(),"-28,00x^3+6,00x^2");
	}
	
	@Test
	public void testDerivareFals() {
		Polinom polinom = new Polinom();
		polinom.parsare("23x^2-10x+1");
		Operatie op = new Derivare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom).get(0);
		assertNotEquals(p.toString(),"+23.0x^2-10.0x+1.0");
	}
	
	@Test
	public void testIntegrare() {
		Polinom polinom = new Polinom();
		polinom.parsare("3x^2+2x+1");
		Operatie op = new Integrare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom).get(0);
		assertEquals(p.toString(),"+x^3+x^2+x");
	}
	
	@Test
	public void testIntegrareFals() {
		Polinom polinom = new Polinom();
		polinom.parsare("-3x^2-2x");
		Operatie op = new Integrare();
		Polinom p = new Polinom();
		p = op.calculeaza(polinom).get(0);
		assertNotEquals(p.toString(),"+x^3+x^2");
	}

}

