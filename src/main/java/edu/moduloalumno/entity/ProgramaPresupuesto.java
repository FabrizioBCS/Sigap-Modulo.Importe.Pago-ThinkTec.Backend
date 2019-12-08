package edu.moduloalumno.entity;

import java.io.Serializable;

public class ProgramaPresupuesto implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    private Integer id_programa_presupuesto;
    
    private Integer id_programa;
    
    private Integer id_programacion_pagos;
    
    private Integer costo_credito;
    
    private Integer costo_total;
    
    private Integer id_tipo_presupuesto;
    
    public ProgramaPresupuesto () {
    	
    }
    
    public ProgramaPresupuesto (Integer id_programa_presupuesto) {
    	
    }

}
