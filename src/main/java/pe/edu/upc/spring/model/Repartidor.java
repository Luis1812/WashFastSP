package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Repartidor")
public class Repartidor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRepartidor;
	
	@OneToOne
	@JoinColumn(name="idUsuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idLocal", nullable = false)
	private Local local;
	
	@Column(name="codLicencia", length=9, nullable=false)
	private String codLicencia;
	
	@Column(name="placaMoto", length=6, nullable=false)
	private String placaMoto;

	public Repartidor() {
		super();
	}

	public Repartidor(int idRepartidor, Usuario usuario, Local local, String codLicencia, String placaMoto) {
		super();
		this.idRepartidor = idRepartidor;
		this.usuario = usuario;
		this.local = local;
		this.codLicencia = codLicencia;
		this.placaMoto = placaMoto;
	}

	public int getIdRepartidor() {
		return idRepartidor;
	}

	public void setIdRepartidor(int idRepartidor) {
		this.idRepartidor = idRepartidor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getCodLicencia() {
		return codLicencia;
	}

	public void setCodLicencia(String codLicencia) {
		this.codLicencia = codLicencia;
	}

	public String getPlacaMoto() {
		return placaMoto;
	}

	public void setPlacaMoto(String placaMoto) {
		this.placaMoto = placaMoto;
	}

}
