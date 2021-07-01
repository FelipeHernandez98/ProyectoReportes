package co.edu.ufps.dao;

import java.io.Serializable;
import javax.persistence.*;

import co.edu.ufps.entities.Connectiontoken;
import co.edu.ufps.entities.Rol;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String pass;

	private short state;

	private String usuario;

	//bi-directional many-to-one association to Connectiontoken
	@OneToMany(mappedBy="usuario")
	private List<Connectiontoken> connectiontokens;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="role")
	private Rol rol;

	public UsuarioDao() {
	}
	
	public UsuarioDao(int id, String email, String pass, short state, String usuario,
			List<Connectiontoken> connectiontokens, Rol rol) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.state = state;
		this.usuario = usuario;
		this.connectiontokens = connectiontokens;
		this.rol = rol;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public short getState() {
		return this.state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Connectiontoken> getConnectiontokens() {
		return this.connectiontokens;
	}

	public void setConnectiontokens(List<Connectiontoken> connectiontokens) {
		this.connectiontokens = connectiontokens;
	}

	public Connectiontoken addConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().add(connectiontoken);
		connectiontoken.setUsuario(this);

		return connectiontoken;
	}

	public Connectiontoken removeConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().remove(connectiontoken);
		connectiontoken.setUsuario(null);

		return connectiontoken;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public UsuarioDao buscar(UsuarioDao u) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(UsuarioDao us) {
		// TODO Auto-generated method stub
		
	}

	public UsuarioDao log(UsuarioDao u) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(UsuarioDao u) {
		// TODO Auto-generated method stub
		
	}

}