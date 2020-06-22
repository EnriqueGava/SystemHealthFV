package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entidad")
public class entidad 
{

	@Id	
	@Column(name="cveent" , nullable=false)
	private String cveEnt;

	@Column(name="noment" , nullable=false)
	private String nomEnt;
	
	@Column(name="nomabr" , nullable=false)
	private String nomAbr;



	public String getCveEnt() {
		return cveEnt;
	}

	public void setCveEnt(String cveEntidad) {
		this.cveEnt = cveEntidad;
	}

	public String getNomEnt() {
		return nomEnt;
	}

	public void setNomEnt(String nomEnt) {
		this.nomEnt = nomEnt;
	}

	public String getNomAbr() {
		return nomAbr;
	}

	public void setNomAbr(String nomAbr) {
		this.nomAbr = nomAbr;
	}

	@Override
	public String toString() {
		return "entidad [cveEnt=" + cveEnt + ", nomEnt=" + nomEnt + ", nomAbr=" + nomAbr + ", getCveEnt()="
				+ getCveEnt() + ", getNomEnt()=" + getNomEnt() + ", getNomAbr()=" + getNomAbr() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	
}