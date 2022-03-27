package fp.clinico;

import fp.utiles.Checkers;

public record PacienteEstudio(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadCorazon,
		TipoDeResidencia tipoDeResidencia, Double glucosa) implements Comparable<PacienteEstudio>{
	
	//Propiedad derivada
	public Boolean factorDeRiesgo() {
		Boolean res = null;
		if(hipertension==true && edad>40) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	//Restricciones
	public PacienteEstudio {
		Checkers.check("La edad tiene que ser mayor o igual que cero y menor o igual que 130", edad>=0 && edad<=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", glucosa>=0);
	}
	
	//Representacion como cadena
	public String toString(String id, Double edad) {
		return "PacienteEstudio [id()=" + id + " ,edad="+ edad+"]";
	}

	//Criterio de orden
	@Override
	public int compareTo(PacienteEstudio o) {
		int res = this.edad.compareTo(o.edad);
		if(res==0);{
			res = this.id.compareTo(o.id);
		}
		return res;
	}
	
	//Metodo staic of
	public static PacienteEstudio of(String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadCorazon,
			TipoDeResidencia tipoDeResidencia, Double glucosa) {
		PacienteEstudio res = new PacienteEstudio(id, genero, edad, hipertension, enfermedadCorazon, tipoDeResidencia, glucosa);
		return res;
	}
	
	//Metodo static parse
	public static PacienteEstudio parse(String text) {
		Checkers.checkNoNull("Cadena vacia", text);
		String[] partes = text.split(";");
		Checkers.check("Faltan datos", partes.length==7);
		String id = partes[0];
		String genero = partes[1];
		Double edad = Double.parseDouble(partes[2]);
		Boolean hipertension = Boolean.parseBoolean(partes[3]);
		Boolean enfermedadCorazon = Boolean.parseBoolean(partes[4]);
		TipoDeResidencia tipoDeResidencia = TipoDeResidencia.valueOf(partes[5]);
		Double glucosa = Double.parseDouble(partes[6]);
		return PacienteEstudio.of(id, genero, edad, hipertension, enfermedadCorazon, tipoDeResidencia, glucosa);
	}
	
	
	//TEST
	public static void main(String[] args) {
		PacienteEstudio pe1 = PacienteEstudio.parse("6306;Male;80;false;false;RURAL;83.84");
		System.out.println(pe1);
	}
	
	
	
}
