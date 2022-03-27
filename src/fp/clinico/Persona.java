package fp.clinico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import fp.utiles.Checkers;


public record Persona(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) implements Comparable<Persona> {

	//Metodo auxiliar para las restricciones
	public static Boolean sonDigitos(String codigo) {
		Boolean res = true;
		for(int i=0; i<codigo.length();i++) {
			res=Character.isDigit(codigo.charAt(i));
			if(!res) {
				break;
			}
		}
		return res;
	}

	//Propiedades derivadas
	public Integer edad() {
		LocalDate hoy = LocalDate.now();
		Integer res = this.fechaNacimiento.until(hoy).getYears();
		return res;
	}


	//Orden natural por dni
	@Override
	public int compareTo(Persona o) {
		int res = this.dni.compareTo(o.dni);
		if(res==0);{}
		return res;
	}


	//Metodo static of
	public static Persona of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento) {
		//Restricciones
		Character ultimoNumero = dni.charAt(dni.length()-1);
		Boolean esLetra = Character.isLetter(ultimoNumero);
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual", !fechaNacimiento.isAfter(LocalDate.now()));
		Checkers.check("El dni debe ser una cadena con ocho dígitos y seguidos de una letra", dni.length()==9 && esLetra && sonDigitos(dni.substring(0, dni.length()-1)));
		//----------------------------------------
		Persona res = new Persona(nombre, apellidos, dni, fechaNacimiento);
		return res;
	}

	//Metodo static parse
	public static Persona parse(String text) {
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(",");
		Checkers.check("Faltan datos", partes.length==4);
		String nombre = partes[0];
		String apellidos = partes[1];
		String dni = partes[2].strip();
		String fecha = partes[3].strip();
		LocalDate fechaNacimiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return Persona.of(nombre, apellidos, dni, fechaNacimiento);
	}


	//TEST
	public static void main(String[] args) {
		Persona p1 = Persona.of("Enrique", "Garcia Abadia", "12755078Z", LocalDate.of(2003, 12, 31));
		System.out.println(p1);
		Persona p2 = Persona.of("Alvaro", "Jimenez Osuna", "12755078Z", LocalDate.of(2003, 01, 15));
		System.out.println(p2);
		System.out.println("Edad p2: "+p2.edad());
		Persona p3 = Persona.parse("Juan, García Rodríguez, 12755078Z, 26/10/1995");
		System.out.println(p3);
	}

}
