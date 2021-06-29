package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Prenda")
public class Prenda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrenda;
	
	@Column(name="nombrePrenda", length=60, nullable=false)
	private String namePrenda;
	
	@Column(name="montoPrenda", nullable=false)
	private int montoPrenda;

	public Prenda() {
		super();
	}

	public Prenda(int idPrenda, String namePrenda, int montoPrenda) {
		super();
		this.idPrenda = idPrenda;
		this.namePrenda = namePrenda;
		this.montoPrenda = montoPrenda;
	}

	public int getIdPrenda() {
		return idPrenda;
	}

	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}

	public String getNamePrenda() {
		return namePrenda;
	}

	public void setNamePrenda(String namePrenda) {
		this.namePrenda = namePrenda;
	}

	public int getMontoPrenda() {
		return montoPrenda;
	}

	public void setMontoPrenda(int montoPrenda) {
		this.montoPrenda = montoPrenda;
	}


}
