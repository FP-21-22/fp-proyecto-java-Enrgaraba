package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaMedicamentos {
	
	//====================================================================================//
	
	public static List<Medicamento> leeFichero(String fichero) {
		List<Medicamento> res = new ArrayList<>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(fichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cont = 0;
		for(String e:aux) {
			if(cont>0) {
				Medicamento p = parseaMedicamente(e);
				res.add(p);
			}
			cont++;
		}
		return res;
		
	}
	
	//====================================================================================//
	
	public static Medicamento parseaMedicamente(String text) {
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(",");
		Checkers.check("Faltan datos", partes.length==7);
		String nombre = partes[0].trim();
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(partes[1].toUpperCase().trim());
		String codigoEnfermedad = partes[2].trim();
		String farmaceutica = partes[3].trim();
		Double puntuacion = Double.parseDouble(partes[4].trim());
		Integer indiceSomatico = Integer.parseInt(partes[5].trim());
		LocalDate fechaCatalogo = LocalDate.parse(partes[6].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Medicamento res = new Medicamento(nombre, tipoMedicamento, codigoEnfermedad, farmaceutica,
				puntuacion, indiceSomatico, fechaCatalogo);
		return res;
	}
}
