package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.entity.ImporteAlumnoObligaciones;

public interface IImporteAlumnoObligacionesDAO {
	
	List<ImporteAlumnoObligaciones> getAllImporteAlumnosObligaciones();
    
    void addImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
    
    void updateImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones);
    
    void deleteImporteAlumnoObligaciones(int cod_alumno);

}
