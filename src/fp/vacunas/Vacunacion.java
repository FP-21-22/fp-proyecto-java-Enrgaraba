package fp.vacunas;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna,
		Integer astrazeneca, Integer janseen, Integer numeroDePersonas) implements Comparable<Vacunacion>{


	//Propiedades derivadas
	public Integer numeroTotal() {
		Integer res = this.pfizer+this.moderna+this.astrazeneca+this.janseen;
		return res;
	}


	//Restricciones
	public Vacunacion {
		Checkers.check("La fecha de debe ser posterior al 01/01/2021", fecha.isAfter(LocalDate.of(2020, 01, 01)));
	}

	//Criterio de orden
	@Override
	public int compareTo(Vacunacion o) {
		int res = this.comunidad.compareTo(o.comunidad);
		if(res==0) {
			res = this.fecha.compareTo(fecha);
		}
		return res;
	}

	//Metodo static of
	public static Vacunacion of(LocalDate fecha, String comunidad, Integer pfizer, Integer moderna,
		Integer astrazeneca, Integer janseen, Integer numeroDePersonas) {
		Vacunacion res = new Vacunacion(fecha, comunidad, pfizer, moderna, astrazeneca, janseen, numeroDePersonas);
		return res;
	}
	
	//Metodo satatic parse
	public static Vacunacion parse(String text) {
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
	
	
	//TEST
	public static void main(String[] args) {
		Vacunacion v1 = Vacunacion.parse("04/01/2021;Andalucía;140295;0;0;0;0");
		System.out.println(v1);
		System.out.println("Numero Total v1: " + v1.numeroTotal());
	}




}
