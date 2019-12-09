package edu.moduloalumno.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.dao.impl.ImporteAlumnoObligacionesDAOImpl;
import edu.moduloalumno.entity.Alumno;
import edu.moduloalumno.entity.ImporteAlumnoObligaciones;
import edu.moduloalumno.service.IImporteAlumnoObligacionesService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/importealumnoobligaciones")
public class ImporteAlumnoObligacionesController {
		
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IImporteAlumnoObligacionesService service;
	private ImporteAlumnoObligacionesDAOImpl dao;
    		
        @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImporteAlumnoObligaciones>> getAllImporteAlumnosObligaciones() {
		logger.info("> getAllImporteAlumnosObligaciones [ImporteAlumnoObligaciones]");

		List<ImporteAlumnoObligaciones> list = null;
		try {
			list = service.getAllImporteAlumnosObligaciones();

			if (list == null) {
				list = new ArrayList<ImporteAlumnoObligaciones>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllImporteAlumnosObligaciones [ImporteAlumnoObligaciones]");
		return new ResponseEntity<List<ImporteAlumnoObligaciones>>(list, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/search/{cod_alumno}/{cod_programa}/{id_tobligacion_estado}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<ImporteAlumnoObligaciones> getImporteAlumnoObligacionesImporte(@PathVariable("cod_alumno") Integer cod_alumno,@PathVariable("cod_programa") Integer cod_programa,@PathVariable("id_tobligacion_estado") Integer id_tobligacion_estado) {
    		logger.info("> getImporteAlumnoObligacionesImporte [ImporteAlumnoObligaciones]");

    		ImporteAlumnoObligaciones importe = null;

    		try {
    			importe = service.getImporteAlumnoObligacionesImporte(cod_alumno, cod_programa, id_tobligacion_estado);
    			
    			if (importe == null) {
    				importe = new ImporteAlumnoObligaciones();
    			}
    		} catch (Exception e) {
    			logger.error("Unexpected Exception caught.", e);
    			return new ResponseEntity<ImporteAlumnoObligaciones>(importe, HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    		

    		logger.info("< getImporteAlumnoObligacionesImporte [ImporteAlumnoObligaciones]");
    		return new ResponseEntity<ImporteAlumnoObligaciones>(importe, HttpStatus.OK);
    	} 
        
        @PostMapping(value = "/add", consumes = "application/json",produces = "application/json")
    	public ImporteAlumnoObligaciones add(@RequestBody ImporteAlumnoObligaciones importealumnoobligaciones){
        	
        	service.addImporteAlumnoObligaciones(importealumnoobligaciones);
        	return importealumnoobligaciones;
    	}
        
        @PostMapping(value = "/update", consumes = "application/json",produces = "application/json")
    	public ImporteAlumnoObligaciones update(@RequestBody ImporteAlumnoObligaciones newimportealumnoobligaciones){
        	
        	service.updateImporteAlumnoObligaciones(newimportealumnoobligaciones);
        	return newimportealumnoobligaciones;
    	}

        @RequestMapping(value = "/addsin", method = RequestMethod.POST)
    	public ResponseEntity<ImporteAlumnoObligaciones> addImporteAlumnoObligaciones(){
    		
    		ImporteAlumnoObligaciones newimportealumnoobligaciones = new ImporteAlumnoObligaciones(404,44,44,1200.0,1,"108",1,"casi");
    		
    		try {
                        service.addImporteAlumnoObligaciones(newimportealumnoobligaciones);
    		} catch (Exception e) {
    			return new ResponseEntity<ImporteAlumnoObligaciones>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}

    		return new ResponseEntity<ImporteAlumnoObligaciones>(newimportealumnoobligaciones, HttpStatus.CREATED);
    	}
        
        @RequestMapping(value = "/addu", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<ImporteAlumnoObligaciones> addImporteAlumnoObligaciones(@RequestBody ImporteAlumnoObligaciones newimportealumnoobligaciones){

    		logger.info("> addImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
    		
    		int coalu = newimportealumnoobligaciones.getCod_alumno();
    		int copro = newimportealumnoobligaciones.getCod_programa();
    		int cocon = newimportealumnoobligaciones.getCod_concepto();
    		double im = newimportealumnoobligaciones.getImporte();
    		int idtipoo = newimportealumnoobligaciones.getId_tipo_obligacion();
    		String idmo = String.valueOf(newimportealumnoobligaciones.getId_moneda());
    		int idtoest = newimportealumnoobligaciones.getId_tobligacion_estado();
    		String desc = String.valueOf(newimportealumnoobligaciones.getDescripcion());
    		
    		ImporteAlumnoObligaciones importealumnoobligaciones = new ImporteAlumnoObligaciones(coalu,copro,cocon,im,idtipoo,idmo,idtoest,desc);
    		
    		try {
                        service.addImporteAlumnoObligaciones(importealumnoobligaciones);
    		} catch (Exception e) {
    			return new ResponseEntity<ImporteAlumnoObligaciones>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}

    		logger.info("> addImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
    		return new ResponseEntity<ImporteAlumnoObligaciones>(importealumnoobligaciones, HttpStatus.CREATED);
    	}
        
        @RequestMapping(value = "/addi", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImporteAlumnoObligaciones> addImporteAlumnoObligaciones(
			@RequestParam(value = "cod_alumno") Integer coalu,
			@RequestParam("cod_programa") Integer copro,
			@RequestParam("cod_concepto") Integer cocon,
			@RequestParam("importe") double im,
			@RequestParam("id_tipo_obligacion") Integer idtipoo,
			@RequestParam("id_moneda") String idmo,
			@RequestParam("id_tobligacion_estado") Integer idtoest,
			@RequestParam("descripcion") String desc){

		logger.info("> addImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
			
		ImporteAlumnoObligaciones importealumnoobligaciones = new ImporteAlumnoObligaciones(coalu,copro,cocon,im,idtipoo,idmo,idtoest,desc);
		
		try {
                    service.addImporteAlumnoObligaciones(importealumnoobligaciones);
		} catch (Exception e) {
			return new ResponseEntity<ImporteAlumnoObligaciones>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("> addImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
		return new ResponseEntity<ImporteAlumnoObligaciones>(importealumnoobligaciones, HttpStatus.CREATED);
	}
        
        @RequestMapping(value = "/updato", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<ImporteAlumnoObligaciones> updateImporteAlumnoObligaciones(@RequestBody ImporteAlumnoObligaciones newimportealumnoobligaciones) {

    		logger.info("> updateImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
    		
    		int coalu = newimportealumnoobligaciones.getCod_alumno();
    		int copro = newimportealumnoobligaciones.getCod_programa();
    		int cocon = newimportealumnoobligaciones.getCod_concepto();
    		double im = newimportealumnoobligaciones.getImporte();
    		int idtipoo = newimportealumnoobligaciones.getId_tipo_obligacion();
    		String idmo = newimportealumnoobligaciones.getId_moneda();
    		int idtoest = newimportealumnoobligaciones.getId_tobligacion_estado();
    		String desc = newimportealumnoobligaciones.getDescripcion();
    		
    		ImporteAlumnoObligaciones importealumnoobligaciones = new ImporteAlumnoObligaciones(coalu,copro,cocon,im,idtipoo,idmo,idtoest,desc);
    		
    		try {
    			service.updateImporteAlumnoObligaciones(importealumnoobligaciones);
                        
           
    		} catch (Exception e) {
    			return new ResponseEntity<ImporteAlumnoObligaciones>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}

    		logger.info("> updateImporteAlumnoObligaciones [ImporteAlumnoObligaciones]");
    		return new ResponseEntity<ImporteAlumnoObligaciones>(importealumnoobligaciones, HttpStatus.CREATED);
    	}

}
