package fp.vacunas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Vacunaciones {
	
	public List<Vacunacion> vacunaciones;
	
	//====================================================================================//

	//CONSTRUCTORES
	public Vacunaciones(Stream<Vacunacion> lst) {
		//
		this.vacunaciones = lst.collect(Collectors.toList());
	}
	
	public Vacunaciones() {
		
	}
	
	//====================================================================================//

	public void anaydeVacunacion(Vacunacion vacuna) {
		//
		this.vacunaciones.add(vacuna);
	}
	
	//====================================================================================//

	public List<Vacunacion> vacunacionesEntreFechas(LocalDate fecha1, LocalDate fecha2) {
		//
		return this.vacunaciones.stream().
				filter(x->(x.fecha().isAfter(fecha1) && x.fecha().isBefore(fecha2))).
				toList();
	}
	
	//====================================================================================//

	public Boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad, Integer n) {
		//
		return this.vacunaciones.stream().
				anyMatch(x->x.comunidad().equals(comunidad) && x.numeroDePersonas() > n);
	}
	
	//====================================================================================//

	public LocalDate diaMasVacunacionesEn(String comunidad) {
		//
		return this.vacunaciones.stream().
				filter(x->x.comunidad().equals(comunidad)).
				max(Comparator.comparing(Vacunacion::numeroTotal)).
				get().
				fecha();
	}
	
	//====================================================================================//

	public Map<LocalDate, List<Vacunacion>> vacunacionesPorFecha() {
		//
		return this.vacunaciones.stream().
				collect(Collectors.groupingBy(
						Vacunacion::fecha));
	}
	
	//====================================================================================//

	public Map<String, Integer> maximoNumTotalVacunasporComunidad() {
		//
		return this.vacunaciones.stream().
				collect(Collectors.groupingBy(
						Vacunacion::comunidad,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Vacunacion::numeroTotal)),
								x->x.get().numeroTotal()
								)
						));
	}
	
	
	
}
