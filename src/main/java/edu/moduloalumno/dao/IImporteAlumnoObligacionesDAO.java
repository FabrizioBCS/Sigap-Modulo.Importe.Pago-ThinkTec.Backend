package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.ImporteAlumnoObligaciones;

public interface IImporteAlumnoObligacionesDAO {
	
	List<ImporteAlumnoObligaciones> getAllImporteAlumnosObligaciones();
	
	List<ImporteAlumnoObligaciones> getImporteAlumnoObligacionesImporte(int cod_alumno,int cod_programa, int id_tobligacion_estado);
    
    void addImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
    
    void updateImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
    
    void deleteImporteAlumnoObligaciones(int cod_alumno);

}
