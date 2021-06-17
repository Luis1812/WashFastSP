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

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;
	
	private Date fechaPedido;
	
	private Date fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)
	private Cliente cliente;
	
	@Column(name="monto", nullable=false)
	private float monto;

	public Pedido() {
		super();
	}

	public Pedido(int idPedido, Date fechaPedido, Date fechaEntrega, Cliente cliente, float monto) {
		super();
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.cliente = cliente;
		this.monto = monto;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
}
