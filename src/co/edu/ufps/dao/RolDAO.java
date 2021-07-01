package co.edu.ufps.dao;

import co.edu.ufps.entities.Rol;
import co.edu.ufps.util.Conexion;

public class RolDAO extends Conexion<Rol>
implements GenericDao<Rol>{

	public RolDAO (){
		super(Rol.class);
	}
}