package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento implements Comparable<Medicamento>{
	//Atributos
	private String nombre;
	private TipoMedicamento tipoMedicamento;
	private String codigoEnfermendad;
	private String farmaceutica;
	private Double puntuacion;
	private Integer indiceSomatico;
	private LocalDate fechaCatalogo;
	

	//Constructores
	public Medicamento(String nombre, TipoMedicamento tipoMedicamento, String codigoEnfermendad, String farmaceutica,
			Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		//Restricciones
		Checkers.check("La puntaci�n tiene que ser mayor estricta que cero", puntuacion>0);
		Checkers.check("El �ndice som�tico tiene que ser mayor o igual que 1000", indiceSomatico>=1000);
		Checkers.check("La fecha de cat�logo tiene que ser posterior al 01/01/2015", fechaCatalogo.isAfter(LocalDate.of(2015, 1, 1)));
		this.nombre = nombre;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermendad = codigoEnfermendad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
	}
	
	
	//M�todos propiedades - b�sicas
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}
	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		this.fechaCatalogo = fechaCatalogo;
	}
	public String getNombre() {
		return nombre;
	}
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	public String getCodigoEnfermendad() {
		return codigoEnfermendad;
	}
	public String getFarmaceutica() {
		return farmaceutica;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	
	//M�todos propiedades - derivadas + operaciones
	public Boolean getTratarEnfermedad(String texto) {
		Boolean res = texto==this.codigoEnfermendad;
		return res;
	}
	
	//M�todos adicionales:
	
	//(a) Representaci�n como cadena - (redefinici�n de toString de Object)
	@Override
	public String toString() {
		return "Medicamento [nombre=" + nombre + ", farmaceutica=" + farmaceutica + "]";
	}
	
	
	//(b) Criterio de igualdad - (redefinici�n de equals y hashCode de Object);
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica) && Objects.equals(nombre, other.nombre);
	}

	
	//(c) Orden natural - (a�adir m�todo de la interfaz Comparable<t>
	@Override
	public int compareTo(Medicamento o) {
		int res = this.nombre.compareTo(nombre);
		if(res==0) {
			res = this.farmaceutica.compareTo(farmaceutica);
		}
		return res;
	}

	
}
