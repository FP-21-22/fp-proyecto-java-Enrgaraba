package fp.farmaceutico.test;

import java.time.LocalDate;
import java.util.List;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;


public class TestFactoriaMedicamento {

	public static void main(String[] args) {
	Medicamento m1 = new Medicamento("efavirenz", TipoMedicamento.ANATOMICO, "Y212XXA",
			"Actavis Mid Atlantic LLC", 90.0, 1848, LocalDate.of(2019, 12, 4));
	System.out.println(m1);
	System.out.println(m1.getTipoMedicamento());
	System.out.println(m1.getCodigoEnfermendad());
	System.out.println(m1.getFechaCatalogo());
	System.out.println(m1.getPuntuacion());
	System.out.println(m1.getIndiceSomatico());
	System.out.println(m1.getTratarEnfermedad("Y212XXA"));
	m1.setFechaCatalogo(LocalDate.of(2019, 5, 12));
	System.out.println(m1.getFechaCatalogo());
	Medicamento m2 = FactoriaMedicamentos.parseaMedicamente("efavirenz,quimico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019");
	System.out.println(m2);
	
	//====================================================================================//
	
	String ruta = "data/medicamentos.csv";
	List<Medicamento> lista = FactoriaMedicamentos.leeFichero(ruta);
	for(Medicamento e:lista) {
		System.out.println(e);
	}
	}


}
