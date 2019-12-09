package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IImporteAlumnoObligacionesDAO;
import edu.moduloalumno.entity.ImporteAlumnoObligaciones;
import edu.moduloalumno.rowmapper.ImporteAlumnoObligacionesRowMapper;

@Transactional    
@Repository
public class ImporteAlumnoObligacionesDAOImpl implements IImporteAlumnoObligacionesDAO{	
		@Autowired
	private JdbcTemplate jdbcTemplate;
    
        @Override
	public List<ImporteAlumnoObligaciones> getAllImporteAlumnosObligaciones() {
		String sql = "SELECT cod_alumno, cod_programa, cod_concepto, importe, id_tipo_obligacion, id_moneda, id_tobligacion_estado, descripcion FROM importe_alumno";
		
		RowMapper<ImporteAlumnoObligaciones> rowMapper = new ImporteAlumnoObligacionesRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
        
        @Override
    	public ImporteAlumnoObligaciones getImporteAlumnoObligacionesImporte(int cod_alumno,int cod_programa, int id_tobligacion_estado) {
    		String sql = "SELECT cod_alumno, cod_programa, cod_concepto, importe, id_tipo_obligacion, id_moneda, id_tobligacion_estado, descripcion FROM importe_alumno WHERE cod_alumno = ? and cod_programa = ? and id_tobligacion_estado = ?";
    		RowMapper<ImporteAlumnoObligaciones> rowMapper = new BeanPropertyRowMapper<ImporteAlumnoObligaciones>(ImporteAlumnoObligaciones.class);
    		ImporteAlumnoObligaciones importealumnoobligaciones = jdbcTemplate.queryForObject(sql, rowMapper, cod_alumno,cod_programa,id_tobligacion_estado);
    		return importealumnoobligaciones;
    	}
        
        @Override
	public void addImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones) {
		// Add ImporteAlumno
		String sql = "INSERT INTO importe_alumno (cod_alumno, cod_programa, cod_concepto, importe, id_tipo_obligacion, id_moneda, id_tobligacion_estado, descripcion) values (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,importealumnoobligaciones.getCod_alumno(),importealumnoobligaciones.getCod_programa(),importealumnoobligaciones.getCod_concepto(),importealumnoobligaciones.getImporte(),importealumnoobligaciones.getId_tipo_obligacion(),importealumnoobligaciones.getId_moneda(),importealumnoobligaciones.getId_tobligacion_estado(),importealumnoobligaciones.getDescripcion());
	}
        
        @Override
	public void updateImporteAlumnoObligaciones(ImporteAlumnoObligaciones importealumnoobligaciones) {
		String sql = "UPDATE importe_alumno SET importe = ?, id_tipo_obligacion = ?, id_moneda = ?, id_tobligacion_estado = ?, descripcion = ? WHERE cod_alumno = ? and cod_programa = ? and cod_concepto = ?";
		jdbcTemplate.update(sql,importealumnoobligaciones.getImporte(),importealumnoobligaciones.getId_tipo_obligacion(),importealumnoobligaciones.getId_moneda(),importealumnoobligaciones.getId_tobligacion_estado(),importealumnoobligaciones.getDescripcion(),importealumnoobligaciones.getCod_alumno(),importealumnoobligaciones.getCod_programa(),importealumnoobligaciones.getCod_concepto());
    }
        
        @Override
	public void deleteImporteAlumnoObligaciones(int cod_alumno) {
		String sql = "DELETE FROM importe_alumno WHERE cod_alumno = ?";
		jdbcTemplate.update(sql, cod_alumno);
	}
}
