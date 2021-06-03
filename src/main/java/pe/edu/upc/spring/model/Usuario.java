package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;

	@Column(name="usuario", nullable=false, length=30)
	private String usuario;
	
	@Column(name="contrasena", nullable=false, length = 30)
	private String contrasena;
	
	@Column(name="sexo", nullable=false, length = 1)
	private char sexo;
	
	@Column(name="direccion", nullable=false, length = 100)
    private String direccion;

	@Column(name="telefono", nullable=false, length = 20)
    private String telefono;

	@Column(name="nombreCompleto", nullable=false, length = 100)
    private String nombreCompleto;

	@Column(name="correo", nullable=false, length = 100)
    private String correo;

	public Usuario(int idUsuario, String usuario, String contrasena, char sexo, String direccion, String telefono,
			String nombreCompleto, String apellidos, String correo) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.sexo = sexo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nombreCompleto = nombreCompleto;
		this.correo = correo;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}

