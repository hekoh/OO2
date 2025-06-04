package ar.edu.unlp.info.oo2.biblioteca;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


public class jacksonExporter {
	
	
	public String exportar(List<Socio> socios) {
		 ObjectMapper mapper = new ObjectMapper();
		 String data = "";

		 try {
			   data = mapper.writeValueAsString(socios);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 return data;
	}
}
