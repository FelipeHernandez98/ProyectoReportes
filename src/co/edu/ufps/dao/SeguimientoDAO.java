package co.edu.ufps.dao;

import co.edu.ufps.entities.Seguimiento;
import co.edu.ufps.util.Conexion;

public class SeguimientoDAO extends Conexion<Seguimiento> 
implements GenericDao<Seguimiento>{
	
	public SeguimientoDAO  (){
		super(Seguimiento.class);
	}
}