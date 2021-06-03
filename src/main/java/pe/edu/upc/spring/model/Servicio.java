package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idServicio;
	
	@Column(name="tipoServicio", nullable=false, length=100)
	private String tipoServicio;
	
	@Column(name="montoServicio", nullable=false)
	private int montoServicio;

	public Servicio() {
		super();
	}
	
	public Servicio(int idServicio, String tipoServicio, int montoServicio) {
		super();
		this.idServicio = idServicio;
		this.tipoServicio = tipoServicio;
		this.montoServicio = montoServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public int getMontoServicio() {
		return montoServicio;
	}

	public void setMontoServicio(int montoServicio) {
		this.montoServicio = montoServicio;
	}
}
