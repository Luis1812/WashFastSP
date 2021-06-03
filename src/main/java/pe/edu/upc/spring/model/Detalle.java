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
	
	@Column(name="cantidad", nullable=false)
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="idPrenda", nullable = false)
	private Prenda prenda;

	@ManyToOne
	@JoinColumn(name="idServicio", nullable = false)
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="idPedido", nullable = false)
	private Pedido pedido;
	
	public Detalle() {
		super();
	}

	public Detalle(int idDetalle, Prenda prenda, int cantidad, Servicio servicio, Pedido pedido) {
		super();
		this.idDetalle = idDetalle;
		this.prenda = prenda;
		this.cantidad = cantidad;
		this.servicio = servicio;
		this.pedido = pedido;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
