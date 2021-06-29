package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Detalle")
public class Detalle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	@ManyToOne
	@JoinColumn(name="idPrenda", nullable = false)
	private Prenda prenda;
	
	@ManyToOne
	@JoinColumn(name="idServicio", nullable = false )
	private Servicio servicio;

	@Column(name="montod", nullable=false)
	private double monto;

	public Detalle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detalle(int idDetalle, Prenda prenda, Servicio servicio, double monto) {
		super();
		this.idDetalle = idDetalle;
		this.prenda = prenda;
		this.servicio = servicio;
		this.monto = monto;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	

}