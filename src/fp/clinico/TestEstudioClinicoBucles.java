package fp.clinico;

import java.util.List;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {

		EstudioClinico e1 = new EstudioClinicoBucles();
		EstudioClinico e2 = e1.of("data/estudio_clinico.csv");
		
		System.out.println("TEST NUMERO PACIENTES ==> "+e2.numeroPacientes());
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST PACIENTES DE TIPO URBANA ==> "+e2.todosPacienteSonDelTipo(TipoDeResidencia.URBANA));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST EXISTE ALGUN PACIENTE DE TIPO RURAL ==> "+e2.existeAlgunPacienteDelTipo(TipoDeResidencia.RURAL));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NUMERO PACIENTES FACTOR DE RIESGO ==> "+e2.numeroPacientesFactorRiesgo());
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST EDAD MEDIA PACIENTES FACTOR RIESGO ==> "+e2.edadMediaPacientesConFactorRiesgo());
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NUMERO PACIENTES CON 54 AÑOS ==> "+e2.filtraPacientesPorEdad(54D).size());
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST PACIENTES MAYORES DE 79 AÑOS MUJER");
		System.out.println("//===============================================================================================================//");
		for(PacienteEstudio e:e2.agruparPacientesEdadMayorQuePorGenero(79D).get("Female")) {
			System.out.println(e);
		}
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST PACIENTES MAYORES DE 84 AÑOS HOMBRE");
		for(PacienteEstudio e:e2.agruparPacientesEdadMayorQuePorGenero(80D).get("Male")) {
			System.out.println(e);
		}
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NUMERO PACIENTES MUJER ==> "+e2.numeroPacientesPorGenero().get("Female"));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NUMERO PACIENTES HOMBRE ==> "+e2.numeroPacientesPorGenero().get("Male"));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST EDAD MEDIA DE PACIENTES MUJER ==> "+e2.edadMediaPacientesPorPorGenero().get("Female"));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST EDAD MEDIA DE PACIENTES HOMBRE ==> "+e2.edadMediaPacientesPorPorGenero().get("Male"));
	}

}
