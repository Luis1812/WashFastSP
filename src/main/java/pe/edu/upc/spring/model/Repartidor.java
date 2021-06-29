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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLicencia == null) ? 0 : codLicencia.hashCode());
		result = prime * result + idRepartidor;
		result = prime * result + ((placaMoto == null) ? 0 : placaMoto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Repartidor other = (Repartidor) obj;
		if (codLicencia == null) {
			if (other.codLicencia != null)
				return false;
		} else if (!codLicencia.equals(other.codLicencia))
			return false;
		if (idRepartidor != other.idRepartidor)
			return false;
		if (placaMoto == null) {
			if (other.placaMoto != null)
				return false;
		} else if (!placaMoto.equals(other.placaMoto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
