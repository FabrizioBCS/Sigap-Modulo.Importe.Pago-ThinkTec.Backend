package edu.moduloalumno.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IUsuarioJOINAlumnoProgramaDAO;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

@Transactional
@Repository
public class UsuarioJOINAlumnoProgramaDAOImpl implements IUsuarioJOINAlumnoProgramaDAO{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String userName, String pass) {
	    System.out.println("pruebaaaa");
		String sql = "SELECT us.id_usuario, us.user_name, us.pass, ap.cod_alumno, ap.ape_paterno, ap.nom_alumno, ap.dni_m"+
				" from  usuario us join alumno_programa ap "+
			    " ON (us.user_name = ap.dni_m )"+
				" where (us.user_name ='"+ userName+"') and (us.pass ='"+pass+"' );";
	           System.out.println(sql);

		RowMapper<UsuarioJOINAlumnoPrograma> rowMapper = new BeanPropertyRowMapper<UsuarioJOINAlumnoPrograma>(UsuarioJOINAlumnoPrograma.class);
		UsuarioJOINAlumnoPrograma usuarioJOINAlumnoPrograma = jdbcTemplate.queryForObject(sql, rowMapper);
		System.out.println(usuarioJOINAlumnoPrograma);
		return usuarioJOINAlumnoPrograma;
	}
	
	//queryForObject
	/*
	 * "select usuario.id_usuario, usuario.user_name, usuario.pass, "+
	                 "alumno_programa.cod_alumno, alumno_programa.ape_paterno, alumno_programa.nom_alumno, alumno_programa.dni_m" + 
					"from usuario,alumno_programa" + 
					"and (usuario.user_name = alumno_programa.dni_m)" + 
					"where (usuario.user_name = ? and usuario.pass = ? )";
	 */
}
