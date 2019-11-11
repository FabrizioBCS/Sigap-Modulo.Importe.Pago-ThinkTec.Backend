package edu.moduloalumno.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.component.FloatFormat;
import edu.moduloalumno.entity.UsuarioJOINAlumnoPrograma;

import edu.moduloalumno.service.IUsuarioJOINAlumnoProgramaService;

@RestController
@RequestMapping("/usuario/alumnoprograma")
public class UsuarioJOINAlumnoProgramaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUsuarioJOINAlumnoProgramaService usuarioJOINAlumnoProgramaService;
	
	@Autowired
	@Qualifier("floatformat")
	private FloatFormat floatformat;
	
	@RequestMapping(value = "/buscar/{userName}/{pass}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioJOINAlumnoPrograma> getUsuarioJOINAlumnoProgramaByUserPass(@PathVariable("userName") String userName, @PathVariable("pass") String pass) {
		logger.info("> getUsuarioJOINAlumnoProgramaByUserPass [UsuarioJOINAlumnoPrograma]");

		UsuarioJOINAlumnoPrograma usuario = null;
		try {	
			
			usuario = usuarioJOINAlumnoProgramaService.getUsuarioJOINAlumnoProgramaByUserPass(userName, pass);
			System.out.println(usuario);
			if (usuario == null) {
				usuario = new UsuarioJOINAlumnoPrograma();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<UsuarioJOINAlumnoPrograma>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getUsuarioJOINAlumnoProgramaByUserPass [UsuarioJOINAlumnoPrograma]");
		return new ResponseEntity<UsuarioJOINAlumnoPrograma>(usuario, HttpStatus.OK);
	}

}
