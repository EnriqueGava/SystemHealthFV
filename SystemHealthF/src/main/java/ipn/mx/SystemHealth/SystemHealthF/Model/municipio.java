package ipn.mx.SystemHealth.SystemHealthF.Model;

import java.io.InputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="municipio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class municipio 
{

	@Id	
	@Column(name="idmunicipio", nullable=false , unique = true)
	private int idMunicipio;
	
	@Column(name="cveent" , nullable=false)
	private String cveEnt;

	@Column(name="cvemun" , nullable=false)
	private String cveMun;
	
	@Column(name="nommun" , nullable=false)
	private String nomMun;
	
	@Column(name="cvecab", nullable=false)
	private String cveCab;
	
	@Column(name="nomcab", nullable=false)
	private String nomCab;

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}


	public String getCveMun() {
		return cveMun;
	}

	public void setCveMun(String cveMun) {
		this.cveMun = cveMun;
	}

	public String getNomMun() {
		return nomMun;
	}

	public void setNomMun(String nomMun) {
		this.nomMun = nomMun;
	}

	public String getCveCab() {
		return cveCab;
	}

	public void setCveCab(String cveCab) {
		this.cveCab = cveCab;
	}

	public String getNomCab() {
		return nomCab;
	}

	public void setNomCab(String nomCab) {
		this.nomCab = nomCab;
	}

	@Override
	public String toString() {
		return "municipio [idMunicipio=" + idMunicipio + ", cveEnt=" + cveEnt + ", cveMun=" + cveMun + ", nomMun="
				+ nomMun + ", cveCab=" + cveCab + ", nomCab=" + nomCab + ", getIdMunicipio()=" + getIdMunicipio()
				+ ", getCveMun()=" + getCveMun() + ", getNomMun()=" + getNomMun() + ", getCveCab()=" + getCveCab()
				+ ", getNomCab()=" + getNomCab() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
}
