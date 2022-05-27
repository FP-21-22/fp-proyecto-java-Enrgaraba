# Proyecto del Segundo Cuatrimestre Fundamentos de Programaci�n (Curso  \<21\>/\<22\>)
Autor: Enrique Garc�a Abad�a   uvus:enrgaraba

Aqu� debes a�adir la descripci�n del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
     * *fp.factoriamedicamentos*: Paquete que contiene los tipos del proyecto.
     * *fp.factoriavacunaciones*: Paquete que contiene los tipos del proyecto.
     * *fp.clinico*: Paquete que contiene los tipos del proyecto.
     * *fp.farmaceutico*: Paquete que contiene los tipos del proyecto.
     * *fp.farmaceutico.test*: Paquete que contiene las clases de test de "fp.farmacutico.
     * *fp.utiles*:  Paquete que contiene las clases de utilidad. 
     * *fp.vacunas*: Paquete que contiene el m�dulo "Vacunacion".

* **data**: Contiene el dataset o datasets del proyecto
     * *cca_vacunas_3.csv*: Informacion sobre la vacunacion detodas las comunidades aut�nomas.
     * *estudio_clinico.csv*: Estudio cl�nico de la poblaci�n.
     * *medicamentos.csv*: Informacion sobre medicamentos.
     
## Estructura de los datasets

Encontramos 3 datasets en este proyecto: ccaa_vacunas, compuesto por 7 columnas; estudio_clinico, compuesto por 7 columnas; y por ultimo medicamentos, compuesto por 7 columnas.

* **ccaa_vacunas_3.csv**:
     * *columna 1*: de tipo LocalDate (fecha_publicacion).
     * *columna 2*: de tipo String (CCAA).
     * *columna 3*: de tipo Integer (Pfizer).
     * *columna 4*: de tipo Integer (Moderna).
     * *columna 5*: de tipo Integer (AstraZeneca).
     * *columna 6*: de tipo Integer (Janssen).
     * *columna 7*: de tipo Integer (Personas_pauta_completa).

* **estudio_clinico.csv**:
     * *columna 1*: de tipo Integer (Id).
     * *columna 2*: de tipo String (Genero).
     * *columna 3*: de tipo Integer (Edad).
     * *columna 4*: de tipo Boolean (Hipertension).
     * *columna 5*: de tipo Boolean (FactordeRiesgo).
     * *columna 6*: de tipo Enum (TipoResidencia).
     * *columna 7*: de tipo Double (Glucosa).

* **medicamentos.csv**:
     * *columna 1*: de tipo String (Nombre_medicamento).
     * *columna 2*: de tipo String (Tipo_medicamento).
     * *columna 3*: de tipo String (Codigo_enfermedad).
     * *columna 4*: de tipo String (Farmaceutica).
     * *columna 5*: de tipo Double (Puntuacion).
     * *columna 6*: de tipo Integer (Indice_somatico).
     * *columna 7*: de tipo LocalDate (Fecha_catalogo).
	
## Tipos implementados

**Los tipos implementados son:**

* **Tipo Checkers:** Class.
* **Tipo EstudioClinico:** Interface.
* **Tipos EstudioClinicoBucles:** Class.
* **Tipos EstudioClinicoStream:** Class.
* **Tipo Paciente:** Record.
* **Tipo PacienteEstudio:** Record.
* **Tipo Persona:** Record.
* **Tipos TestEstudioClinicoBucles:** M�dulo test de la clase EstudioClinicoBucles.
* **Tipos TestEstudioClinicoStream:** M�dulo test de la clase EstudioClinicoStream.
* **Tipo TipoResidencia:** Enumerado.
* **Tipo FactoriaMedicamentos:** Clase, contiene el parseo de la clase Medicamento.
* **Tipo Medicamento:** Clase.
* **Tipo TipoMedicamento:** Enumerado.
* **Tipo TestMedicamentos:** Clase. Modulo test de la clase Medicamento y FactoriaMedicamentos.
* **Tipo Vacunacion:** Record

### Tipo Persona:
* **Persona:**
     * **Propiedades:**
      * nombre, de tipo String.
      * apellidos, de tipo String.
      * dni, de tipo String.
      * fecha de nacimiento, de tipo LocalDate.
      * edad, de tipo Integer. (Derivada a partir de la fecha de nacimiento).
     * **Restricciones:**
       * La fecha de nacimiento debe ser anterior a la fecha actual.
       * El dni debe ser una cadena con ocho d�gitos y seguidos de una letra.
     * **Representaci�n como cadena:** por defecto asociado al record.
     * **Criterio de igualdad:** por defecto asociado al record.
     * **Orden natural:** por dni.
     * **M�todos de factor�a adicionales:**
       * M�todo static of: Recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
       * M�todo static parse: Recibe una cadena con un formato espec�fico y devuelve una persona.Ejemplo de cadena: �Juan, Garc�a Rodr�guez, 12755078Z, 20/03/1965�.
       * Se incluye un metodo main para comprobar el funcionamiento del metodo parse.
     
     
### Tipo Paciente:
* **Paciente:**
     * **Propiedades:**
      * persona, de tipo Persona.
      * c�digo de ingreso, de tipo String.
      * fecha y hora de ingreso, de tipo LocalDateTime.
      * fecha de ingreso, de tipo LocalDate. (Derivada a partir de la fecha y hora de ingreso)
      * hora de ingreso, de tipo String. (Derivada a partir de la fecha y hora de ingreso).Ejemplo de cadena: �15:03�. Es decir, la hora y los minutos tienen que tener dos d�gitos. No valdr�a escribir �15:3�.
     * **Restricciones:**
       * La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.
     * **Representaci�n como cadena:** por defecto asociado al record.
     * **Criterio de igualdad:** por defecto asociado al record.
     * **M�todos de factor�a adicionales:**
       * M�todo static of: Recibe nombre, apellidos, dni, fecha de nacimiento, c�digo y fecha y hora de ingreso y devuelve un paciente.
       * M�todo static of: Recibe un objeto persona, un c�digo y una fecha y hora de ingreso y devuelve un paciente.

### Tipo PacienteEstudio:
* **PacienteEstudio:**
     * **Propiedades:**
      * id, de tipo String.
      * genero, de tipo String.
      * edad, de tipo Double.
      * hipertensi�n, de tipo Boolean.
      * enfermedad del coraz�n, de tipo Boolean.
      * tipo de residencia, enumerado TipoResidencia, cuyos valores son rural o urbana.
      * nivel medio de glucosa, de tipo Double.
      * factor de riesgo, de tipo Boolean. (Derivada, si tiene hipertensi�n y m�s de 40 a�os se considerar� que tiene factor de riesgo).
     * **Restricciones:**
      * La edad tiene que ser mayor o igual que cero y menor o igual que 130.
      * El nivel medio de glucosa tiene que ser mayor o igual que cero.
     * **Representaci�n como cadena:** informa del id y la edad del paciente.
     * **Criterio de igualdad:** por defecto asociado al record.
     * **Criterio de orden:** seg�n la edad y el id.
     * **M�todos de factor�a adicionales:**
       * M�todo static of: Recibe valores para cada propiedad b�sica y devuelve un objeto del tipo.
       * M�todo static parse: Recibe una cadena con un formato especificado y y devuelve un objeto del tipo. Ejemplo de cadena: �6306;Male;80;false;false;URBANA;83.84�
       * Se incluye un metodo main para comprobar el funcionamiento del metodo parse.

### Tipo Vacunacion:
* **Vacunacion:**
     * **Propiedades:**
      * fecha, de tipo LocalDate.
      * comunidad, de tipo String.
      * pfizer, de tipo Integer.
      * moderna, de tipo Integer.
      * astrazeneca, de tipo Integer.
      * janssen de tipo Integer.
      * n�mero de personas, de tipo Integer.
      * n�mero total, de tipo Integer. (Derivada, siendo la suma de dosis de Pfizer, moderna, astrazeneca y janssen).
     * **Restricciones:**
      * La fecha de debe ser posterior al 01/02/2021.
     * **Representaci�n como cadena:** por defecto asociado al record.
     * **Criterio de igualdad:** por defecto asociado al record.
     * **Orden natural:** por comunidad y en caso de igualdad por fecha.
     * **M�todos de factor�a adicionales:**
       * M�todo static of: Recibe valores para cada propiedad b�sica y devuelve un objeto del tipo.
       * M�todo static parse: Recibe una cadena con un formato espec�fico y devuelve un objeto del tipo. Ejemplo de cadena: �04/01/2021;Andaluc�a;140295;0;0;0;0�.
       * Se incluye un metodo main para comprobar el funcionamiento del metodo parse.
				
				
				
## Tipo Medicamento: (Clase)
* **Medicamento:**
     * **Propiedades:**
      * nombre del medicamento, de tipo String, observable.
      * tipo de medicamento, enumerado de tipo TipoMedicamento, observable. Los valores del enumerado son anat�mico, qu�mico y terap�utico.
      * c�digo de la enfermedad, de tipo String, observable.
      * farmac�utica, de tipo String, observable.
      * puntaci�n, de tipo Double, observable.
      * �ndice som�tico, de tipo Integer, observable.
      * fecha de cat�logo, de tipo LocalDate, observable y modificable.
      * tratar enfermedad, de tipo Boolean. (Derivada, siendo cierta si el c�digo de la enfermedad coincide con un par�metro de tipo cadena que reciben como argumento la propiedad).
     * **Restricciones:**
        * La puntaci�n tiene que ser mayor estricta que cero.
        * El �ndice som�tico tiene que ser mayor o igual que 1000.
        * La fecha de cat�logo tiene que ser posterior al 01/01/2015.
     * **Representaci�n como cadena:** seg�n el nombre del medicamento y de la farmac�utica.
     * **Criterio de igualdad:** por nombre del medicamento y farmac�utica.
     * **Orden natural:** por nombre del medicamento y en caso de igualdad por la farmac�utica.
		
### Otras operaciones:

*   Clase FactoriaMedicamentos: Se ha programado una clase FactoriaMedicamentos que incluye, de momento, un metodo static de nombre parseaMedicamento, que recibe una cadena con un formato especifico y devuelve un objeto del tipo Medicamento.
*   Clase TestFactoriaMedicamentos: Se ha implementado tambien una clase de nombre TestFactoriaMedicamentos que comprueba el correcto funcionamiento del metodo anterior.




## Tipo EstudioClinico: (Interfaz)
* **EstudioClinico:**
     * Estos son los m�todos/operaciones a realizar:
		
	 public interface EstudioClinico { // Propiedades de lista
			Integer numeroPacientes();
			void incluyePaciente(PacienteEstudio paciente);
			void incluyePacientes(Collection<PacienteEstudio> pacientes);
			void eliminaPaciente(PacienteEstudio paciente);
			Boolean estaPaciente(PacienteEstudio paciente);
			void borraEstudio();
	
			// M�todo de factor�a
			EstudioClinico of(String nombreFichero);
			List<PacienteEstudio> leeFichero(String nombreFichero);
	
			// Tratamientos secuenciales: implementaci�nn funcional vs. imperativa
			//existe, paraTodo
			Boolean todosPacienteSonDelTipo(TipoResidencia tipo);
			Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo);
	
			//contador, suma, media
			Integer numeroPacientesFactorRiesgo();
			Double edadMediaPacientesConFactorRiesgo();
			
			//filtrado
			List<PacienteEstudio> filtraPacientesPorEdad(Double edad);
	
			//devuelve Map que agrupa
			Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad); //devuelve Map que realiza un c�lculo
			Map< ,Long> numeroPacientesPorGenero();
			Map< ,Double> edadMediaPacientesPorPorGenero();

## Tipo EstudioClinicoBucles: (Clase)
* **EstudioClinicoBucles:**
     * M�todos de propiedades de listas.
     * M�todos de tratamientos secuenciales.
     * M�todos para la construcci�n de diccionarios o mapas
	
## Tipo EstudioClinicoStream: (Clase)
* **EstudioClinicoStream:**
     * M�todos de propiedades de listas.
		
## Tipo FactoriaMedicamentos: (Clase)
* **FactoriaMedicamentos:**
     * Contiene un m�todo de nombre leeFichero que, dada una cadena con el nombre del fichero, devuelve una lista de objetos Medicamento.
	
## Tipo FactoriaVacunacion: (Clase)
* **FactoriaVacunacion:**
     * Contiene un m�todo de nombre leeFichero que, dada una cadena con el nombre del fichero, devuelve una lista de objetos Vacunacion.
		

##  Vacunaciones: (Clase)
* **Clase implementada en fp.vancunas**
* **Se pide programar los siguientes m�todos:**
     * **anyadeVacunacion:** dado un objeto del tipo Vacunacion lo a�ade al atributo de List<Vacunacion>.
     * **vacunacionesEntreFechas:** dadas dos fechas como par�metros de entrada, devuelve una lista con aquellas vacunaciones entre dichas fechas.
     * **existeNumPersonasPautaCompletaPorEncimaDe:** dada una comunidad y un valor entero, indica si existen o no vacunaciones con un n�mero de personas con la pauta completa de vacunaci�n por encima del valor entero dado.
     * **diaMasVacunacionesEn:** dada una comunidad, devuelve la fecha en la que hubo m�s personas vacunadas.
     * vacunacionesPorFecha: devuelve un mapa, o diccionario, en el que las claves son las fechas y los valores son listas de vacunaciones asociadas a dichas fechas.
     * **maximoNumTotalVacunasporComunidad:** devuelve un mapa, o diccionario, en el que las claves son las comunidades y los valores son el m�ximo para el n�mero total de vacunas puestas para cada comunidad.
	
##  ListadoMedicamentos: (Clase)
* **Clase implementada en fp.farmaceutico**
* **Se pide programar los siguientes m�todos:**
     * **existeMedicamentoSegunTipoAnteriorA:** dado un tipo de medicamento y una fecha, indica si existe un medicamento de dicho tipo posterior a la fecha dada.
     * **nombreMedicamentosPuntuacionMayorA:** dada una puntuaci�n, devuelve un conjunto con los nombres de los medicamentos con una puntuaci�n mayor a la dada.
     * **nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento:** dado un tipo de medicamento, devuelve el nombre del medicamento con mayor �ndice som�tico. En caso de no haber ninguno, se eleva una excepci�n.
    * **agrupaTipoMedicamentoSegunPuntuacionMedia:** devuelve un diccionario que asocia a cada tipo de medicamento su puntuaci�n media.
    * **fechaCatalogoMasFrecuente:** devuelve la fecha del cat�logo m�s frecuente, es decir, la que aparece m�s veces.
  
