package pe.edu.upc.spring.model;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@ManyToOne
	@JoinColumn(name="idMetodoPago", nullable = false)
	private MetodoPago metodoPago;
//	
//	@OneToOne
//	@JoinColumn(name="idUsuario", nullable = false)
//	private Usuario usuario;
//
//	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int idCliente, MetodoPago metodoPago) {
		super();
		this.idCliente = idCliente;
		this.metodoPago = metodoPago;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public MetodoPago getMetodoPago() {
		return metodoPago;
	}
	
	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	
}
