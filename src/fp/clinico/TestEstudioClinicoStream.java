package fp.clinico;

public class TestEstudioClinicoStream {

	public static void main(String[] args) {
		EstudioClinico e1 = new EstudioClinicoStream();
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
		System.out.println("TESTPACIENTES MAYORES DE 81 AÑOS");
		e2.agruparPacientesEdadMayorQuePorGenero(81D).entrySet().stream().forEach(x->System.out.println(x));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST PACIENTES MAYORES DE 79 AÑOS MUJER");
		for(PacienteEstudio e:e2.agruparPacientesEdadMayorQuePorGenero(79D).get("Female")) {
			System.out.println(e);
		}
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST PACIENTES MAYORES DE 80 AÑOS HOMBRE");
		for(PacienteEstudio e:e2.agruparPacientesEdadMayorQuePorGenero(80D).get("Male")) {
			System.out.println(e);
		}
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NUMERO PACIENTES");
		e2.numeroPacientesPorGenero().entrySet().stream().forEach(x->System.out.println(x));
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


