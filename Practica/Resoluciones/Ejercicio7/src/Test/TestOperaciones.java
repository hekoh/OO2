package Test;

import Clases.*;
import Clases.Error;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TestOperaciones {
	public Calculadora calc;
	
	@BeforeEach
	public void setup() {
		calc = new Calculadora();
	}
	
	@Test
	public void testValor() {
		calc.setValor(10.0);
		assertEquals(calc.getResultado(),"10.0");
	}
	
	
	@Test
	public void testSuma() {
		calc.setValor(5);
		calc.mas();
		calc.setValor(5);
		assertEquals(calc.getResultado(),"10.0");
	}
	
	@Test
	public void testResta() {
		calc.setValor(13);
		calc.menos();
		calc.setValor(5);
		assertEquals(calc.getResultado(),"8.0");
	}
	
	@Test
	public void testMultiplicacion() {
		calc.setValor(5);
		calc.por();
		calc.setValor(3);
		assertEquals(calc.getResultado(),"15.0");
	}
	
	@Test
	public void testDivicion() {
		calc.setValor(25);
		calc.dividido();
		calc.setValor(10);
		assertEquals(calc.getResultado(),"2.5");
	}
	
	@Test
	public void testBorrar() {
		calc.setValor(20);
		calc.borrar();
		assertEquals(calc.getResultado(),"0.0");
	}
	
	@Test
	public void testError() {
		calc.mas();
		calc.menos();
		assertEquals(calc.getEstado().getClass(),Error.class);
		assertEquals(calc.getResultado(),"error");
	}
	
	@Test
	public void testOperaciones() {
		calc.setValor(10);
		calc.menos();
		calc.setValor(5);
		calc.por();
		calc.setValor(4);
		calc.dividido();
		calc.setValor(5);
		calc.dividido();
		calc.setValor(3);
		assertEquals(calc.getResultado().substring(0,5) ,"1.333");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
