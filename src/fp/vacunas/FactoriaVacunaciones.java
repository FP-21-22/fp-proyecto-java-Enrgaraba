package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import fp.utiles.Checkers;


public class FactoriaVacunaciones {
	
	//====================================================================================//
	
	public static List<Vacunacion> leeFichero(String fichero) {
		List<Vacunacion> res = new ArrayList<>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(fichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				Vacunacion p = parseaLinea(e);
				res.add(p);
			}
			cont++;
		}
		return res;
		
	}
	
	//====================================================================================//
	
	public static Vacunacion parseaLinea(String text) {
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(";");
		Checkers.check("Faltan datos", partes.length==7);
		LocalDate fecha = LocalDate.parse(partes[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad = partes[1].trim();
		Integer pfizer = Integer.parseInt(partes[2].trim());
		Integer moderna = Integer.parseInt(partes[3].trim());
		Integer astrazeneca = Integer.parseInt(partes[4].trim());
		Integer janseen = Integer.parseInt(partes[5].trim());
		Integer numeroDePersonas = Integer.parseInt(partes[6].trim());
		return Vacunacion.of(fecha, comunidad, pfizer, moderna, astrazeneca, janseen, numeroDePersonas);

	}
}
