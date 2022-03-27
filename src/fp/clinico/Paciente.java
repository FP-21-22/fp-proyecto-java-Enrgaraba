package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoDeIngreso, LocalDateTime fechaYHora) {
	
	
	//Popiedades derivada
	public LocalDate fechaDeIngreso() {
		LocalDate res = LocalDate.of(fechaYHora.getYear(), fechaYHora.getMonth(), fechaYHora.getDayOfMonth());
		return res;
	}
	
	public String horaDeIngreso() {
		String res = fechaYHora.getHour() + ":" + fechaYHora.getMinute();
		return res;
	}
	
	//Restricciones
	public Paciente {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual",
				fechaYHora.isBefore(LocalDateTime.now()) || fechaYHora.isEqual(LocalDateTime.now()));
	}
	
	//Metodo static of 1
	public static Paciente of(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String codigoDeIngreso, LocalDateTime fechaYHora) {
		Persona p = Persona.of(nombre, apellidos, dni, fechaNacimiento);
		Paciente res = new Paciente(p, codigoDeIngreso, fechaYHora);
		return res;
	}
	
	
	//Metodo static of 2
	public static Paciente of(Persona persona, String codigoDeIngreso, LocalDateTime fechaYHora) {
		Paciente res = new Paciente(persona, codigoDeIngreso, fechaYHora);
		return res;
		
	}
	
	
	
	//TEST
	public static void main(String[] args) {
		Persona p1 = Persona.of("Enrique", "Garcia Abadia", "12755078Z", LocalDate.of(2003, 12, 31));
		Paciente pc1 = Paciente.of(p1, "123456789", LocalDateTime.of(2021, 12, 31, 19, 40));
		System.out.println(pc1);
		Paciente pc2 = Paciente.of("Alvaro", "Jimenez Osuna", "12755078Z", LocalDate.of(2003, 01, 15), "987654321", LocalDateTime.of(2020, 03, 15, 12, 15));
		System.out.println(pc2);
	}
}




