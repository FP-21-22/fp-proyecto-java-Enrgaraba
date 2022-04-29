package fp.clinico;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class EstudioClinicoStream implements EstudioClinico {

	public List<PacienteEstudio> pacientesEstudiosStream;
	
	@Override
	public Integer numeroPacientes() {
		Integer res = this.pacientesEstudiosStream.size();
		return res;
	}

	//====================================================================================//

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		this.pacientesEstudiosStream.add(paciente);

	}

	//====================================================================================//

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		this.pacientesEstudiosStream.addAll(pacientes);

	}

	//====================================================================================//

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.pacientesEstudiosStream.remove(paciente);

	}

	//====================================================================================//

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		Boolean res = this.pacientesEstudiosStream.contains(paciente);
		return res;
	}

	//====================================================================================//

	@Override
	public void borraEstudio() {
		this.pacientesEstudiosStream.clear();
	}

	//====================================================================================//

	@Override
	public EstudioClinico of(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoDeResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoDeResidencia tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
