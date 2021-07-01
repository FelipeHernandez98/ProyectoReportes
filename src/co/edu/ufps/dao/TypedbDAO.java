package co.edu.ufps.dao;

import co.edu.ufps.entities.Typedb;
import co.edu.ufps.util.Conexion;

public class TypedbDAO extends Conexion<Typedb>
implements GenericDao<Typedb>{
	
	public TypedbDAO(){
		super(Typedb.class);
	}
}