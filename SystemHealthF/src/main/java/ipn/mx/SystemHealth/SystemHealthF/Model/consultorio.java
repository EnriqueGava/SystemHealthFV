package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultorio")
public class consultorio 
{
	@Id	
	@Column(name="idconsultorio", nullable=false , unique = true)
	private int idconsultorio;
	
	@Column(name="iddoctor",  nullable=false)
	private int idDoctor;
	
	@Column(name="idmunicipio",  nullable=false)
	private int idMunicipio;

	public int getIdconsultorio() {
		return idconsultorio;
	}

	public void setIdconsultorio(int idconsultorio) {
		this.idconsultorio = idconsultorio;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	@Override
	public String toString() {
		return "consultorio [idconsultorio=" + idconsultorio + ", idDoctor=" + idDoctor + ", idMunicipio=" + idMunicipio
				+ ", getIdconsultorio()=" + getIdconsultorio() + ", getIdDoctor()=" + getIdDoctor()
				+ ", getIdMunicipio()=" + getIdMunicipio() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
