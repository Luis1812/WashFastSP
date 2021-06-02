package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Metodopago")
public class MetodoPago implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMetodopago;
	
	@Column(name="nombreMetodopago", length = 60, nullable = false)
	private String nameMetodopago;

	public MetodoPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MetodoPago(int idMetodopago, String nameMetodopago) {
		super();
		this.idMetodopago = idMetodopago;
		this.nameMetodopago = nameMetodopago;
	}

	public int getIdMetodopago() {
		return idMetodopago;
	}

	public void setIdMetodopago(int idMetodopago) {
		this.idMetodopago = idMetodopago;
	}

	public String getNameMetodopago() {
		return nameMetodopago;
	}

	public void setNameMetodopago(String nameMetodopago) {
		this.nameMetodopago = nameMetodopago;
	}

	
}
