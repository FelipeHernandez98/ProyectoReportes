package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.ufps.dao.UsuarioDao;

import java.util.List;



@Entity
@NamedQuery(name="Connectiontoken.findAll", query="SELECT c FROM Connectiontoken c")
public class Connectiontoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String db;
	private String host;
	private String pass;
	private short port;
	private short state;
	private String token;
	private String userdb;

	
	@ManyToOne
	@JoinColumn(name="type")
	private Typedb typedb;

	
	@ManyToOne
	@JoinColumn(name="user")
	private UsuarioDao usuario;

	
	@OneToMany(mappedBy="connectiontoken")
	private List<Reporte> reportes;

	public Connectiontoken() {
	}
	
	

	public Connectiontoken(int id, String db, String host, String pass, short port, short state, String token,
			String userdb, Typedb typedb, Usuario usuario, List<Reporte> reportes) {
		super();
		this.id = id;
		this.db = db;
		this.host = host;
		this.pass = pass;
		this.port = port;
		this.state = state;
		this.token = token;
		this.userdb = userdb;
		this.typedb = typedb;
		this.usuario = usuario;
		this.reportes = reportes;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public short getPort() {
		return this.port;
	}

	public void setPort(short port) {
		this.port = port;
	}

	public short getState() {
		return this.state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserdb() {
		return this.userdb;
	}

	public void setUserdb(String userdb) {
		this.userdb = userdb;
	}

	public Typedb getTypedb() {
		return this.typedb;
	}

	public void setTypedb(Typedb typedb) {
		this.typedb = typedb;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDao usuarioDao) {
		this.usuario = usuarioDao;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setConnectiontoken(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setConnectiontoken(null);

		return reporte;
	}

}