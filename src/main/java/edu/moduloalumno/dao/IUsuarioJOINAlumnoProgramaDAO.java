package edu.moduloalumno.dao;

import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

public interface IUsuarioJOINAlumnoProgramaDAO {
	
	UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String userName, String pass);

}
