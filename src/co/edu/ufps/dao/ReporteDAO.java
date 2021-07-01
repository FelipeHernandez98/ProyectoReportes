package co.edu.ufps.dao;

import co.edu.ufps.entities.Reporte;
import co.edu.ufps.util.Conexion;

public class ReporteDAO extends Conexion<Reporte>
implements GenericDao<Reporte>{

	public ReporteDAO(){
		super(Reporte.class);
	}
}