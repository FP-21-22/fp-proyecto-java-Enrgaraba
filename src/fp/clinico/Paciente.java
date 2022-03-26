package fp.clinico;

import java.time.LocalDateTime;

import fp.utiles.Checkers;

public record Paciente(Persona persona, String codigoDeIngreso, LocalDateTime fechaYHora) {

	
	public Paciente {
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual",
				fechaYHora.isBefore(LocalDateTime.now()) || fechaYHora.isEqual(LocalDateTime.now()));
	}
	
	
}
