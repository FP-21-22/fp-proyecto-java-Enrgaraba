package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class FactoriaMedicamentos {
	
	public static Medicamento parseaMedicamente(String text) {
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(",");
		Checkers.check("Faltan datos", partes.length==7);
		String nombre = partes[0];
		TipoMedicamento tipoMedicamento = TipoMedicamento.valueOf(partes[1].toUpperCase());
		String codigoEnfermedad = partes[2];
		String farmaceutica = partes[3];
		Double puntuacion = Double.parseDouble(partes[4]);
		Integer indiceSomatico = Integer.parseInt(partes[5]);
		LocalDate fechaCatalogo = LocalDate.parse(partes[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Medicamento res = new Medicamento(nombre, tipoMedicamento, codigoEnfermedad, farmaceutica,
				puntuacion, indiceSomatico, fechaCatalogo);
		return res;
	}
}
