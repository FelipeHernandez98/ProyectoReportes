package co.edu.ufps.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private Timestamp dategenerate;
	private String detailrequest;
	private String filegenerate;
	private String result;
	private short state;
	private String type;

	
	@ManyToOne
	@JoinColumn(name="report")
	private Reporte reporte;

	public Seguimiento() {
	}
	
	public Seguimiento(int id, Timestamp dategenerate, String detailrequest, String filegenerate, String result,
			short state, String type, Reporte reporte) {
		super();
		this.id = id;
		this.dategenerate = dategenerate;
		this.detailrequest = detailrequest;
		this.filegenerate = filegenerate;
		this.result = result;
		this.state = state;
		this.type = type;
		this.reporte = reporte;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDategenerate() {
		return this.dategenerate;
	}

	public void setDategenerate(Timestamp dategenerate) {
		this.dategenerate = dategenerate;
	}

	public String getDetailrequest() {
		return this.detailrequest;
	}

	public void setDetailrequest(String detailrequest) {
		this.detailrequest = detailrequest;
	}

	public String getFilegenerate() {
		return this.filegenerate;
	}

	public void setFilegenerate(String filegenerate) {
		this.filegenerate = filegenerate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public short getState() {
		return this.state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Reporte getReporte() {
		return this.reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

}