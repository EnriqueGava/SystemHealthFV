package ipn.mx.SystemHealth.SystemHealthF.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import java.util.Date;

@Entity
@Table(name = "receta")
public class receta {
	@Id
	@Column(name = "idreceta", nullable = false, unique = true)
	private int idReceta;

	@Column(name = "idcantidades", nullable = false)
	private int idCantidades;

	@Column(name = "idpaciente", nullable = false)
	private int idPaciente;

	@Column(name = "numreceta", nullable = false)
	private int numReceta;
	
	@Column(name="iddoctor", nullable = false)
	private int idDoctor;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public int getIdCantidades() {
		return idCantidades;
	}

	public void setIdCantidades(int idCantidades) {
		this.idCantidades = idCantidades;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getNumReceta() {
		return numReceta;
	}

	public void setNumReceta(int numReceta) {
		this.numReceta = numReceta;
	}
	
	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "receta [idReceta=" + idReceta + ", idCantidades=" + idCantidades + ", idPaciente=" + idPaciente
				+ ", fecha=" + fecha + ", getIdReceta()=" + getIdReceta() + ", getIdCantidades()=" + getIdCantidades()
				+ ", getIdPaciente()=" + getIdPaciente() + ", getFecha()=" + getFecha() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
