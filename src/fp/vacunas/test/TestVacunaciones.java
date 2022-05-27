package fp.vacunas.test;

import java.time.LocalDate;
import java.util.List;

import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;
import fp.vacunas.Vacunaciones;

public class TestVacunaciones {
	
	public static void main(String[] args) {
		//
		List<Vacunacion> list =FactoriaVacunaciones.leeFichero("data/ccaa_vacunas_3.csv");		
		Vacunaciones v1 = new Vacunaciones(list.stream());
		System.out.println("TEST VACUNACIONES ENTRE FECHAS");
		for(Vacunacion v:v1.vacunacionesEntreFechas(LocalDate.of(2021,01,03), LocalDate.of(2021,01,06))) {
			System.out.println(v);
		}
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST EXISTE NUMERO DE PERSONAS POR ENCIMA DE N CON PAUTA COMPLETA ==> " + v1.existeNumPersonasPautaCompletaPorEncimaDe("Andalucía", 100000000));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST DIA MAS VACUNACIONES EN ==> "+ v1.diaMasVacunacionesEn("Andalucía"));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST VACUNACIONES POR FECHA");
		v1.vacunacionesPorFecha().entrySet().stream().forEach(x->System.out.println(x));
		System.out.println("//===============================================================================================================//");
		System.out.println("TEST MAXIMO NUMERO DE VACUNAS POR COMUNIDAD");
		v1.maximoNumTotalVacunasporComunidad().entrySet().stream().forEach(x->System.out.println(x));
		
		
		
	}
}
