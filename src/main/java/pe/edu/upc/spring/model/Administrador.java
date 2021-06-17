package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	
	@OneToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;

	public Administrador() {
		super();
	}

	public Administrador(int idAdministrador, Usuario usuario) {
		super();
		this.idAdministrador = idAdministrador;
		this.usuario = usuario;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
