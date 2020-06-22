package ipn.mx.SystemHealth.SystemHealthF.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class paciente 
{
	@Id
	@Column(name="idpaciente", nullable=false , unique = true)
	private int idPaciente;
	
	@Column(name="idusuario", nullable=false , unique = true)
	private String idUsuario;
	
	private String nombre;

	private String apellidos;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="peso")
	private int peso;
	
	@Column(name="estatura")
	private int estatura;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="tipodesangre", nullable=false)
	private String tipoDeSangre;

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDeSangre() {
		return tipoDeSangre;
	}

	public void setTipoDeSangre(String tipoDeSangre) {
		this.tipoDeSangre = tipoDeSangre;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", edad=" + edad + ", peso=" + peso + ", estatura=" + estatura + ", sexo=" + sexo
				+ ", tipoDeSangre=" + tipoDeSangre + ", getIdPaciente()=" + getIdPaciente() + ", getIdUsuario()="
				+ getIdUsuario() + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getEdad()=" + getEdad() + ", getPeso()=" + getPeso() + ", getEstatura()=" + getEstatura()
				+ ", getSexo()=" + getSexo() + ", getTipoDeSangre()=" + getTipoDeSangre() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
