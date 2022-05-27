package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class ListadoMedicamentos {

	public List<Medicamento> medicamentos;
	
	//====================================================================================//

	//CONSTRUCTORES
	public ListadoMedicamentos(Stream<Medicamento> lst) {
		//
		this.medicamentos = lst.collect(Collectors.toList());
	}
	
	public ListadoMedicamentos() {
		
	}
	//====================================================================================//
	
	public Boolean existeMedicamentoSegunTipoAnteriorA(TipoMedicamento tipo, LocalDate fecha) {
		//
		return this.medicamentos.stream().
				anyMatch(x->x.getTipoMedicamento().equals(tipo) && x.getFechaCatalogo().isBefore(fecha));
	}
	
	//====================================================================================//
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion) {
		//
		return this.medicamentos.stream().
				filter(x->x.getPuntuacion()>puntuacion).
				map(Medicamento::getNombre).
				collect(Collectors.toSet());
	}
	
	//====================================================================================//
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento tipo) {
		//
		return this.medicamentos.stream().
				filter(x->x.getTipoMedicamento().equals(tipo)).
				max(Comparator.comparing(Medicamento::getIndiceSomatico)).
				get().
				getNombre();
	}
	
	//====================================================================================//
	
	public Map<TipoMedicamento, Double> agrupaTipoMedicamentoSegunPuntuacionMedia() {
		//
		return this.medicamentos.stream().
				collect(Collectors.groupingBy(
						Medicamento::getTipoMedicamento,
						Collectors.averagingDouble(
								Medicamento::getPuntuacion
								)));
	}
	
	//====================================================================================//
	
	public LocalDate fechaCatalogoMasFrecuente() {
		//
		Map<LocalDate, Long> mapAux =  this.medicamentos.stream().
				collect(Collectors.groupingBy(
						Medicamento::getFechaCatalogo,
						Collectors.counting()
						));
		
		Comparator<Map.Entry<LocalDate, Long>> cmp = (x,y)->x.getValue().
				compareTo(y.getValue());
		
		return mapAux.entrySet().stream().
				max(cmp).
				get().
				getKey();
	}
	

}
