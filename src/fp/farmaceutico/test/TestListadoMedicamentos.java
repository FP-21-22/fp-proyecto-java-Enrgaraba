package fp.farmaceutico.test;

import java.time.LocalDate;
import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.ListadoMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;

public class TestListadoMedicamentos {

	public static void main(String[] args) {
		//
		List<Medicamento> list = FactoriaMedicamentos.leeFichero("data/medicamentos.csv");
		ListadoMedicamentos lm1 = new ListadoMedicamentos(list.stream());
		System.out.println("TEST EXISTE MEDICAMENTO SEGUN TIPO ANTERIOR A ==> " + lm1.existeMedicamentoSegunTipoAnteriorA(TipoMedicamento.QUIMICO, LocalDate.of(2019, 12, 02)));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NOMBRE MEDICAMENTO PUNTUACION MAYOR A ==>" + lm1.nombreMedicamentosPuntuacionMayorA(120D));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST NOMBRE DE MEDICAMENTO MAYOR INDICE SEGUN TIPO DE MEDICAMENTO ==> " + lm1.nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento.ANATOMICO));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST AGRUPAR TIPO DE MEDICAMENTO SEGUN PUNTUACION MEDIA");
		lm1.agrupaTipoMedicamentoSegunPuntuacionMedia().entrySet().stream().forEach(x->System.out.println(x));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST FECHA CATALOGO MAS FRECUENTE ==> " + lm1.fechaCatalogoMasFrecuente());
		
		
		
	}

}
