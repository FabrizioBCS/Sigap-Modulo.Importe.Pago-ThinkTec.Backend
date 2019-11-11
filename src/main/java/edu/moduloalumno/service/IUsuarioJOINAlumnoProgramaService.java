package edu.moduloalumno.service;

import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

public interface IUsuarioJOINAlumnoProgramaService {
	
	UsuarioJOINAlumnoPrograma getUsuarioJOINAlumnoProgramaByUserPass(String userName, String pass);

}
