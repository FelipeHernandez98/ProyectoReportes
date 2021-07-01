package co.edu.ufps.dao;

import co.edu.ufps.entities.Connectiontoken;
import co.edu.ufps.util.Conexion;

public class ConnectiontokenDAO extends Conexion<Connectiontoken> 
implements GenericDao<Connectiontoken>{

	public ConnectiontokenDAO(){
		super(Connectiontoken.class);
	}
}
