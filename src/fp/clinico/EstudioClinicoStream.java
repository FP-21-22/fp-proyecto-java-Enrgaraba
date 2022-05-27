package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.utiles.Checkers;


public class EstudioClinicoStream implements EstudioClinico {

	public List<PacienteEstudio> pacientesEstudiosStream;
	//====================================================================================//
	
	//CONSTRUCTORES
	public EstudioClinicoStream(List<PacienteEstudio> paciente) {
		//
		this.pacientesEstudiosStream = paciente;
	}

	public EstudioClinicoStream() {

	}

	//====================================================================================//

	//PARSEA LINEA
	public static PacienteEstudio parseaLinea(String text) {
		//
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(";");
		Checkers.check("Faltan datos", partes.length==7);
		String id = partes[0].trim();
		String genero = partes[1].trim();
		Double edad = Double.parseDouble(partes[2].trim());
		Boolean hipertension = Boolean.parseBoolean(partes[3].trim());
		Boolean enfermedadCorazon = Boolean.parseBoolean(partes[4].trim());
		TipoDeResidencia tipoDeResidencia = TipoDeResidencia.valueOf(partes[5].trim());
		Double glucosa = Double.parseDouble(partes[6].trim());
		return PacienteEstudio.of(id, genero, edad, hipertension, enfermedadCorazon, tipoDeResidencia, glucosa);
	}

	//====================================================================================//

	@Override
	public Integer numeroPacientes() {
		//
		Integer res = this.pacientesEstudiosStream.size();
		return res;
	}

	//====================================================================================//

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		//
		this.pacientesEstudiosStream.add(paciente);

	}

	//====================================================================================//

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		//
		this.pacientesEstudiosStream.addAll(pacientes);

	}

	//====================================================================================//

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		//
		this.pacientesEstudiosStream.remove(paciente);

	}

	//====================================================================================//

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		//
		Boolean res = this.pacientesEstudiosStream.contains(paciente);
		return res;
	}

	//====================================================================================//

	@Override
	public void borraEstudio() {
		//
		this.pacientesEstudiosStream.clear();
	}

	//====================================================================================//

	@Override
	public EstudioClinico of(String nombreFichero) {
		//
		List<PacienteEstudio> pacientes = leeFichero(nombreFichero);
		return new EstudioClinicoStream(pacientes);
	}

	//====================================================================================//

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		//
		Stream<PacienteEstudio> aux = null;
		try {
			aux = Files.lines(Paths.get(nombreFichero)).map(x->parseaLinea(x));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<PacienteEstudio> res = new ArrayList<>(aux.toList());
		return res;
		
	}

	//====================================================================================//

	@Override
	public Boolean todosPacienteSonDelTipo(TipoDeResidencia tipo) {
		//
		return this.pacientesEstudiosStream.stream().
				allMatch(x->x.tipoDeResidencia().equals(tipo));
	}

	//====================================================================================//

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoDeResidencia tipo) {
		//
		return this.pacientesEstudiosStream.stream().
				anyMatch(x->x.tipoDeResidencia().equals(tipo));
	}

	//====================================================================================//

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//
		return (int)this.pacientesEstudiosStream.stream().
				filter(x->x.factorDeRiesgo().equals(true)).
				count();
	}

	//====================================================================================//

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		//
		return this.pacientesEstudiosStream.stream().
				filter(x->x.factorDeRiesgo().equals(true))
				.mapToDouble(x->x.edad()).
				average().
				orElse(0);
	}

	//====================================================================================//

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		//
		return this.pacientesEstudiosStream.stream().
				filter(x->x.edad().equals(edad)).
				toList();
	}

	//====================================================================================//

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//
		return this.pacientesEstudiosStream.stream().
				filter(x->x.edad()>edad).
				collect(Collectors.groupingBy(PacienteEstudio::genero));
	}

	//====================================================================================//

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		//
		return this.pacientesEstudiosStream.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero,
						Collectors.counting()
						));
	}

	//====================================================================================//

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		//
		return this.pacientesEstudiosStream.stream().
				collect(Collectors.groupingBy(
						PacienteEstudio::genero,
						Collectors.averagingDouble(PacienteEstudio::edad
								)));
	}

}
