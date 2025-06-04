package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestExporter {
	private Socio socio1;
	private Socio socio2;
	private Socio socio3;
	private Biblioteca biblio;
	private jsonExporter export;
	private JSONParser parser;
	
	
	@BeforeEach
	public void setup() {
		socio1 = new Socio("Luca","lucagerace@hotmail.com","1234");
		socio2 = new Socio("Candela","nomeacuerdo@gmail.com","4321");
		socio3 = new Socio("anashe","asdasd@asdas.com","6531");
		biblio = new Biblioteca();
		biblio.agregarSocio(socio1);
		biblio.agregarSocio(socio2);
		biblio.agregarSocio(socio3);
		export = new jsonExporter();
		biblio.setExporter(export);
		parser = new JSONParser();
	}
	
	@Test
	public void testImprimir() throws ParseException  {
		String salida = "[\n"
		               	+ "		{\n"
		            	+ "				\"nombre\": \"Luca\",\n"
		            	+ "				\"email\": \"lucagerace@hotmail.com\",\n"
		            	+ "				\"legajo\": \"1234\"\n"
		            	+ " 	},\n"
		            	+ "		{\n"
		            	+ "				\"nombre\": \"Candela\",\n"
		            	+ "				\"email\": \"nomeacuerdo@gmail.com\",\n"
		            	+ "				\"legajo\": \"4321\"\n"
		            	+ " 	},\n"
		            	+ "		{\n"
		            	+ "				\"nombre\": \"anashe\",\n"
		            	+ "				\"email\": \"asdasd@asdas.com\",\n"
		            	+ "				\"legajo\": \"6531\"\n"
		            	+ "		}\n"
		            	+ "]\n"
		            	+ "";
		assertEquals(parser.parse(salida), parser.parse(biblio.exportarSocios()));
	}
}
