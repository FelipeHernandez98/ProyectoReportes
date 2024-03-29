package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name="Typedb.findAll", query="SELECT t FROM Typedb t")
public class Typedb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String aditional;
	private String description;
	private String driver;

	
	@OneToMany(mappedBy="typedb")
	private List<Connectiontoken> connectiontokens;

	public Typedb() {
	}

	
	public Typedb(String id, String aditional, String description, String driver,
			List<Connectiontoken> connectiontokens) {
		super();
		this.id = id;
		this.aditional = aditional;
		this.description = description;
		this.driver = driver;
		this.connectiontokens = connectiontokens;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAditional() {
		return this.aditional;
	}

	public void setAditional(String aditional) {
		this.aditional = aditional;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public List<Connectiontoken> getConnectiontokens() {
		return this.connectiontokens;
	}

	public void setConnectiontokens(List<Connectiontoken> connectiontokens) {
		this.connectiontokens = connectiontokens;
	}

	public Connectiontoken addConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().add(connectiontoken);
		connectiontoken.setTypedb(this);

		return connectiontoken;
	}

	public Connectiontoken removeConnectiontoken(Connectiontoken connectiontoken) {
		getConnectiontokens().remove(connectiontoken);
		connectiontoken.setTypedb(null);

		return connectiontoken;
	}

}