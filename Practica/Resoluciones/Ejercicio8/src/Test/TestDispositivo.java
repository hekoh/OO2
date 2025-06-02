package Test;

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TestDispositivo {
	
	public Dispositivo dispositivo;
	public Adapter4G adaptador;
	public Conexion4g c4g;
	public WifiConn wifi;
	
	
	
	@BeforeEach
	public void setup() {
		c4g = new Conexion4g("4g");
		wifi = new WifiConn("wifi");
		adaptador = new Adapter4G(c4g);
		dispositivo = new Dispositivo(new CRC16_Calculator(),wifi);
	}
	
	
	@Test
	public void testSend() {
		System.out.println("//////////////////////////////////////////////////");
		System.out.println(dispositivo.send("probando"));
		System.out.println("//////////////////////////////////////////////////");
		assertTrue(dispositivo.send("probando").contains("22367"));
		dispositivo.configurarCRC(new CRC32_Calculator());
		System.out.println(dispositivo.send("probando"));
		System.out.println("//////////////////////////////////////////////////");
		assertTrue(dispositivo.send("probando").contains("-1741497163"));
	}
	
	@Test
	public void testConfigurarCRC() {
		dispositivo.configurarCRC(new CRC32_Calculator());
		assertEquals(dispositivo.getCalculator().getClass(), CRC32_Calculator.class);
		dispositivo.configurarCRC(new CRC16_Calculator());
		assertEquals(dispositivo.getCalculator().getClass(), CRC16_Calculator.class);
	}
	
	@Test
	public void conectarCon() {
		dispositivo.conectarCon(adaptador);
		assertEquals(dispositivo.getConnection().getClass(),Adapter4G.class);
		dispositivo.conectarCon(wifi);
		assertEquals(dispositivo.getConnection().getClass(),WifiConn.class);
	}
	
	
	
	
	
	
	
	
	
	
}
