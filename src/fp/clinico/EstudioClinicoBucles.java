package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fp.utiles.Checkers;



public class EstudioClinicoBucles implements EstudioClinico {
	
	public List<PacienteEstudio> pacientesEstudios;
	
	//====================================================================================//
	
	//CONSTRUCTORES
	public EstudioClinicoBucles(List<PacienteEstudio> paciente) {
		this.pacientesEstudios = paciente;
	}
	
	public EstudioClinicoBucles() {
		
	}
	
	//====================================================================================//

	//PARSEA LINEA
	public static PacienteEstudio parseaLinea(String text) {
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
		Integer res = this.pacientesEstudios.size();
		return res;
	}

	//====================================================================================//

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		this.pacientesEstudios.add(paciente);

	}

	//====================================================================================//

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		this.pacientesEstudios.addAll(pacientes);

	}

	//====================================================================================//

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		this.pacientesEstudios.remove(paciente);

	}

	//====================================================================================//

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		Boolean res = this.pacientesEstudios.contains(paciente);
		return res;
	}

	//====================================================================================//

	@Override
	public void borraEstudio() {
		this.pacientesEstudios.clear();
	}

	//====================================================================================//

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		List<PacienteEstudio> res = new ArrayList<>();
		List<String> aux = null;
		try {
			aux = Files.readAllLines(Paths.get(nombreFichero));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(String e:aux) {
			PacienteEstudio p = parseaLinea(e);
			res.add(p);
					
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Boolean todosPacienteSonDelTipo(TipoDeResidencia tipo) {
		Boolean res = true;
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(!e.tipoDeResidencia().equals(tipo)) {
				res = false;
			}
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoDeResidencia tipo) {
		Boolean res = false;
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.tipoDeResidencia().equals(tipo)) {
				res = true;
			}
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		Integer res = 0;
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.factorDeRiesgo().equals(true)) {
				res = res+1;
			}
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		Double edad = 0.0;
		Integer aux = 0;
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.factorDeRiesgo()) {
				edad = edad + e.edad();
				aux = aux+1;
			}
		}
		return edad/aux;
	}

	//====================================================================================//

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> res = new ArrayList<>();
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.edad().equals(edad)) {
				res.add(e);
			}
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		Map<String, List<PacienteEstudio>> res = new HashMap<>();
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.edad()>edad) {
				if(res.containsKey(e.genero())) {
					res.get(e.genero()).add(e);
				}else {
					List<PacienteEstudio> aux = new ArrayList<>();
					aux.add(e);
					res.put(e.genero(), aux);
				}
			}
		}
		return res;
	}

	//====================================================================================//

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		Map<String, Long> res = new HashMap<>();
		Long mujer = 0L;
		Long hombre = 0L;
		Long otro = 0L;
		for(PacienteEstudio e:this.pacientesEstudios) {
			if(e.genero().equals("Female")) {
				mujer = mujer+1;
			}else if(e.genero().equals("Male")){
				hombre = hombre+1;
			}else {
				otro = otro+1;
			}
		}
		res.put("Female", mujer);
		res.put("Male", hombre);
		res.put("Other", otro);
		return res;
	}

	//====================================================================================//

	//FUNCION AUX PARA CALCULAR MEDIAS DE FUNCION EDADMEDIAPACIENTESPORGENERO
	
	public Double mediaAux(List<PacienteEstudio> list) {
		Double suma = 0.0;
		for(PacienteEstudio e:list) {
			suma = suma+e.edad();
		}
		Double res = suma/list.size();
		return res;
	}
	
	//====================================================================================//
	
	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		Map<String, Double> res = new HashMap<>();
		Map<String, List<PacienteEstudio>> auxMap = this.agruparPacientesEdadMayorQuePorGenero(0.0);
		Double mujer = mediaAux(auxMap.get("Female"));
		Double hombre = mediaAux(auxMap.get("Male"));
		res.put("Female", mujer);
		res.put("Male", hombre);
		return res;
	}
	
	//====================================================================================//

	@Override
	public EstudioClinico of(String nombreFichero) {
		List<PacienteEstudio> pacientes = leeFichero(nombreFichero);
		return new EstudioClinicoBucles(pacientes);
	}
}
