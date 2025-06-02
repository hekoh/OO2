package ar.edu.unlp.info.oo2.biblioteca;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.List;

public class jsonExporter extends VoorheesExporter{
	
	
	
	public String exportar(List<Socio> socios) {
		JSONArray lista = new JSONArray();
		socios.stream().forEach(socio -> lista.add(crearObjeto(socio)));
		return socios.toString();
	}
	
	private JSONObject crearObjeto(Socio socio) {
		JSONObject objeto = new JSONObject();
		objeto.put("nombre", socio.getNombre());
		objeto.put("Legajo", socio.getLegajo());
		objeto.put("Email", socio.getEmail());
		return objeto;
	}
}
