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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPedido", nullable=false, length=45)
	private Date fechaPedido;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaEntrega", nullable=false, length=45)
	private Date fechaEntrega;
	
	@Column(name="cantidad", nullable = false)
	private int cantidad;
	
	@Column(name="montofinal", nullable=false)
	private double montofinal;

	
	@ManyToOne
	@JoinColumn(name="idDetalle", nullable = false)
	private Detalle detalle;
	
	@ManyToOne
	@JoinColumn(name = "idRepartidor", nullable = false )
	private Repartidor repartidor;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)
	private Cliente cliente;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int idPedido, Date fechaPedido, Date fechaEntrega, int cantidad, double montofinal, Detalle detalle,
			Repartidor repartidor, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.cantidad = cantidad;
		this.montofinal = montofinal;
		this.detalle = detalle;
		this.repartidor = repartidor;
		this.cliente = cliente;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMontofinal() {
		return montofinal;
	}

	public void setMontofinal(double montofinal) {
		this.montofinal = montofinal;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	
}
