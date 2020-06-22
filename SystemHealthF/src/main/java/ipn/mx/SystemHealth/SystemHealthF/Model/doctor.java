package ipn.mx.SystemHealth.SystemHealthF.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class doctor 
{
	@Id
	@Column(name="iddoctor", nullable=false , unique = true)
	private int idDoctor;
	
	@Column(name="idusuario", nullable=false , unique = true)
	private String idUsuario;

	private String cedula;

	private String nombre;

	private String apellidos;
	
	private int edad;
	
	private String especialidad;

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "doctor [idDoctor=" + idDoctor + ", idUsuario=" + idUsuario + ", cedula=" + cedula + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", edad=" + edad + ", especialidad=" + especialidad + ", getIdDoctor()="
				+ getIdDoctor() + ", getIdUsuario()=" + getIdUsuario() + ", getCedula()=" + getCedula()
				+ ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos() + ", getEdad()=" + getEdad()
				+ ", getEspecialidad()=" + getEspecialidad() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
