package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reclamo")
public class Reclamo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclamo;
	
	@Column(name="detalleReclamo", nullable = false, length = 200)
	private String detailReclamo;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaReclamo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date detailDateReclamo;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name="idLocal", nullable = false)
	private Local local;

	public Reclamo() {
		super();
	}

	public Reclamo(int idReclamo, String detailReclamo, Date detailDateReclamo, Cliente cliente) {
		super();
		this.idReclamo = idReclamo;
		this.detailReclamo = detailReclamo;
		this.detailDateReclamo = detailDateReclamo;
		this.cliente = cliente;
	}

	public int getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getDetailReclamo() {
		return detailReclamo;
	}

	public void setDetailReclamo(String detailReclamo) {
		this.detailReclamo = detailReclamo;
	}

	public Date getDetailDateReclamo() {
		return detailDateReclamo;
	}

	public void setDetailDateReclamo(Date detailDateReclamo) {
		this.detailDateReclamo = detailDateReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
